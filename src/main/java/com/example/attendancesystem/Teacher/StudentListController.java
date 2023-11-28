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
        updateStudentList();
        String searchName = SearchNameTextField.getText().trim().toLowerCase();
        ObservableList<Student> filteredList = FXCollections.observableArrayList();
        for(Student student: studentList){
            String studentName= student.getName().toLowerCase();
            if(studentName.contains(searchName)){
                filteredList.add(student);
            }
        }
        studentTableView.setItems(filteredList);

    }

}
