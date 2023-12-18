//package com.example.attendancesystem.Student;
//
//
//import com.example.attendancesystem.LoginFormApp;
//import com.example.attendancesystem.Teacher.StudentListController;
//import javafx.event.Event;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentController {
//
//    public static ArrayList<StudentData> stuList = new ArrayList<>();
//    @FXML
//    private TextField input_name;
//    @FXML
//    private TextField input_id;
//    @FXML
//    private TextField input_department;
//    @FXML
//    private TextField input_course;
//    @FXML
//    private DatePicker input_date;
////    @FXML
////    private Button submitBtn;
//    @FXML
//    protected void OnSubmitButton (Event event) throws IOException{
//        if (input_name.getText().length()>0 && input_id.getText().length()>0){
////            try {
//                StudentData u = new StudentData();
//                u.setList_name(input_name.getText());
//                u.setList_id(Integer.parseInt(input_id.getText()));
//                u.setList_department(input_department.getText());
//                u.setList_course(input_course.getText());
//                u.setList_date(input_date.getValue());
//                stuList.add(u);
//                StudentController.stuList.add(u);
////                LoginFormApp.stuList.add(u);
//                input_name.setText("");
//                input_id.setText("");
//                input_department.setText("");
//                input_course.setText("");
//                input_date.setValue(null);
////            }catch (NumberFormatException e){
////                e.printStackTrace();
////            }
//            System.out.println("Student Added!");
//        }
//    }
//
//    @FXML
//    private void OnListButton(Event event) throws IOException {
//        Parent root = FXMLLoader.load(LoginFormApp.class.getResource("StudentList.fxml"));
//        Stage stage = (Stage) ( (Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setWidth(stage.getWidth());
//        stage.setHeight(stage.getHeight());
//        stage.setTitle("List Student");
//        stage.setScene(scene);
//        stage.show();
//
//    }
//}





package com.example.attendancesystem.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import com.example.attendancesystem.LoginFormApp;
import com.example.attendancesystem.login.User;
import com.example.attendancesystem.login.Userdata;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class StudentController implements Initializable {

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputID;

    @FXML
    private ChoiceBox<String> pickCourse;

    @FXML
    private ChoiceBox<String> pickTime;

    @FXML
    private DatePicker pickDate;

    @FXML
    private Button submitButton;
    @FXML
    private Label message;

    private Stage currentStage; // Reference to the current stage

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pickCourse.getItems().addAll("CCNA", "OOP", "MATH","BasicElectronic");
        pickTime.getItems().addAll("8:30 AM - 10:00 AM", "10:15 AM - 11:45 AM", "1:00 PM - 2:30 PM","2:30 PM - 4:15 PM");
    }

    @FXML
    public void onSubmit(ActionEvent event) {
        // Get user input
        String name = inputName.getText();
        String id = inputID.getText();
        String course = pickCourse.getValue();
        String time = pickTime.getValue();
        LocalDate date = pickDate.getValue();
        String attendance;

        List<User> users = Userdata.loadUsers();

        // Check if the entered name exists in the list of users
        boolean isUserValid = users.stream().anyMatch(user -> user.getUsername().equals(name));

        if (!isUserValid) {
            message.setText("Invalid user name");
            return; // exit the method if the username is invalid
        }

            LocalDate currentDate = LocalDate.now();
            if (date.isEqual(currentDate)) {
                attendance = "Present";
            } else if (date.isAfter(currentDate)) {
                attendance = "Not in the present";
            } else {
                attendance = "Absent";
            }
            message.setText("Attendance Added!");

            // Store attendance data into a file(which is attendance.txt)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("attendance.txt", true))) {
                writer.write(name + "," + id + "," + course + "," + time + "," + date.toString() + "," + attendance + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }



//    @FXML
//    public void onSubmit(ActionEvent event) {
//        // Get user input
//        String username = inputName.getText().trim();
//        List<User> users = Userdata.loadUsers();
//        User authenticatedUser = authenticateUser(username, "", users);
//
//        // Check if the user is authenticated
//        if (authenticatedUser != null) {
//            LocalDate currentDate = LocalDate.now();
//            LocalDate date = pickDate.getValue();
//            String attendance;
//
//            // Determine attendance based on the date
//            if (date.isEqual(currentDate)) {
//                attendance = "Present";
//            } else if (date.isAfter(currentDate)) {
//                attendance = "Not in the present";
//            } else {
//                attendance = "Absent";
//            }
//
//            // Store attendance data into a file (attendance.txt)
//            boolean success = storeAttendance(username, inputID.getText(), pickCourse.getValue(), pickTime.getValue(), date, attendance);
//
//            // Provide feedback to the user
//            if (success) {
//                message.setText("Attendance Added Successfully!");
//            } else {
//                message.setText("Error adding attendance. Please try again.");
//            }
//        } else {
//            // Invalid user
//            message.setText("Invalid username");
//        }
//    }
//
//    // Method to store attendance data into a file
//    private boolean storeAttendance(String username, String id, String course, String time, LocalDate date, String attendance) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("attendance.txt", true))) {
//            writer.write(username + "," + id + "," + course + "," + time + "," + date.toString() + "," + attendance + "\n");
//            return true;  // Successfully added attendance
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false; // Failed to add attendance
//        }
//    }

    private User authenticateUser(String username, String password, List<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
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

}
