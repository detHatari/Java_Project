package com.example.attendancesystem.Student;


import com.example.attendancesystem.LoginFormApp;
import com.example.attendancesystem.Teacher.StudentListController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    public static ArrayList<StudentData> stuList = new ArrayList<>();
    @FXML
    private TextField input_name;
    @FXML
    private TextField input_id;
    @FXML
    private TextField input_department;
    @FXML
    private TextField input_course;
    @FXML
    private DatePicker input_date;
//    @FXML
//    private Button submitBtn;
    @FXML
    protected void OnSubmitButton (Event event) throws IOException{
        if (input_name.getText().length()>0 && input_id.getText().length()>0){
//            try {
                StudentData u = new StudentData();
                u.setList_name(input_name.getText());
                u.setList_id(Integer.parseInt(input_id.getText()));
                u.setList_department(input_department.getText());
                u.setList_course(input_course.getText());
                u.setList_date(input_date.getValue());
//                stuList.add(u);
                StudentController.stuList.add(u);
                input_name.setText("");
                input_id.setText("");
                input_department.setText("");
                input_course.setText("");
                input_date.setValue(null);
//            }catch (NumberFormatException e){
//                e.printStackTrace();
//            }
            System.out.println("Student Added!");
        }
    }

    @FXML
    private void OnListButton(Event event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("StudentList.fxml"));
//        Stage stage = (Stage) ( (Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setWidth(stage.getWidth());
//        stage.setHeight(stage.getHeight());
//        stage.setTitle("List Student");
//        stage.setScene(scene);
//        stage.show();

    }
}
