package com.example.attendancesystem.Teacher;

import com.example.attendancesystem.LoginFormApp;
import com.example.attendancesystem.Student.StudentController;
import com.example.attendancesystem.Student.StudentData;
import com.example.attendancesystem.login.logincontroller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    ObservableList<StudentData> list = FXCollections.observableArrayList();
    @FXML
    TableView<StudentData> list_tabelview;
    @FXML
    TableColumn<StudentData, String> list_name;
    @FXML
    TableColumn<StudentData, String> list_id;
    @FXML
    TableColumn<StudentData, String> list_department;
    @FXML
    TableColumn<StudentData, String> list_course;
    @FXML
    TableColumn<StudentData, LocalDate> list_date;

    private void initeCols(){
        list_name.setCellValueFactory(new PropertyValueFactory<>("list_name"));
        list_id.setCellValueFactory(new PropertyValueFactory<>("list_id"));
        list_department.setCellValueFactory(new PropertyValueFactory<>("list_department"));
        list_course.setCellValueFactory(new PropertyValueFactory<>("list_course"));
        list_date.setCellValueFactory(new PropertyValueFactory<>("list_date"));
    }
    private void loadStudent(){
        list.removeAll(list);
        list.addAll(StudentController.stuList);
        list_tabelview.setItems(list);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        initeCols();
        loadStudent();
    }

    @FXML
    protected  void OnBackButton(Event event) throws IOException {
        Parent root = FXMLLoader.load(LoginFormApp.class.getResource("StudentView.fxml"));
        Stage stage = (Stage) ( (Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Login Form");
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.setScene(scene);

        stage.show();
    }



}
