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
import java.util.ResourceBundle;

import com.example.attendancesystem.LoginFormApp;
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

        LocalDate currentDate = LocalDate.now();
        if (date.isEqual(currentDate)) {
            attendance = "Present";
        } else if (date.isAfter(currentDate)) {
            attendance = "Not in the present";
        } else {
            attendance = "Absent";
        }
        message.setText("Save Successfully!");

        // Store attendance data into a file(which is attendance.txt)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("attendance.txt", true))) {
            writer.write(name + "," + id + "," + course + "," + time + "," + date.toString() + "," + attendance + "\n");
        } catch (IOException e) {
            e.printStackTrace();

        }
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
