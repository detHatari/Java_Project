package com.example.attendancesystem.Teacher;

import com.example.attendancesystem.LoginFormApp;
import com.example.attendancesystem.Student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    @FXML
    private TextField SearchNameTextField;

    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> courseColumn;

    @FXML
    private TableColumn<Student, String> timeColumn;

    @FXML
    private TableColumn<Student, String> dateColumn;

    @FXML
    private TableColumn<Student, String> attendanceColumn;

    private ObservableList<Student> studentList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    private void OnListStudentButton (ActionEvent event){
        // Arrange the columns so the student information is shown
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        attendanceColumn.setCellValueFactory(new PropertyValueFactory<>("attendance"));

        // Create an ObservableList to hold the student records
        studentList = FXCollections.observableArrayList();

        // Set the data for the TableView
        studentTableView.setItems(studentList);

        // Call the method to update the student list
        updateStudentList();

    }

    public void updateStudentList() {
        // Clear the existing student list
        studentList.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("attendance.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String name = data[0].trim();
                    String id = data[1].trim();
                    String course = data[2].trim();
                    String time = data[3].trim();
                    String date = data[4].trim();
                    String attendance = data[5].trim();

                    addStudent(name, id, course, time, date, attendance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String name, String id, String course, String time, String date, String attendance) {
        //provide the information
        Student student = new Student(name, id, course, time, date, attendance);

        // Add the student to the TableView
        studentList.add(student);
    }
@FXML
    private void OnBackButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(LoginFormApp.class.getResource("LoginView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Login Form");
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void OnSearchName(ActionEvent event) throws IOException {
        String searchName = SearchNameTextField.getText().trim();

        studentList.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("attendance.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String name = data[0].trim();
                    if (name.contains(searchName)) {
                        String id = data[1].trim();
                        String course = data[2].trim();
                        String time = data[3].trim();
                        String date = data[4].trim();
                        String attendance = data[5].trim();

                        addStudent(name, id, course, time, date, attendance);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentTableView.setItems(studentList);
    }
    @FXML
    private void OnClearButton(ActionEvent event)throws IOException{
        studentList.clear();
    }

//    @FXML
//    private void OnRemoveButton(ActionEvent event)throws  IOException{
//        // Get the selected student from the table
//        Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
//
//        // Check if a student is selected
//        if (selectedStudent != null) {
//            // Remove the selected student from the list
//            studentList.remove(selectedStudent);
//
//            // Update the TableView
//            studentTableView.setItems(studentList);
//        } else {
//            // Display a message indicating that no student is selected
//            System.out.println("No student selected to remove.");
//        }
//
//    }
@FXML
private void OnRemoveButton(ActionEvent event) throws IOException {
    Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();

    if (selectedStudent != null) {
        studentList.remove(selectedStudent);

        studentTableView.setItems(studentList);

        removeStudentFromFile(selectedStudent);
    } else {
        System.out.println("No student selected to remove.");
    }
}

    private void removeStudentFromFile(Student studentToRemove) throws IOException {
        // Read the existing data from the file
        Path filePath = Paths.get("attendance.txt");
        List<String> lines = Files.readAllLines(filePath);

        // Create a new list to store the modified data
        List<String> updatedLines = new ArrayList<>();

        // Iterate through the lines, and skip the line containing the student to be removed
        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length == 6) {
                String id = data[1].trim();
                if (!id.equals(studentToRemove.getId())) {
                    updatedLines.add(line);
                }
            }
        }

        // Write the updated data back to the file
        Files.write(filePath, updatedLines);
    }





}
