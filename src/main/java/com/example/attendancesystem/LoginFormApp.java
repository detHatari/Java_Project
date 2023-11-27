package com.example.attendancesystem;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Set;

public class LoginFormApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
            primaryStage.setTitle("Login Form FXML Application");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }






//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        try {
//            Parent root = FXMLLoader.load(LoginFormApp.class.getResource("LoginView.fxml"));
//            Scene scene = new Scene(root);
//            primaryStage.setTitle("Login Form FXML Application");
//            primaryStage.setScene(scene);
//            primaryStage.setScene(new Scene(root, 600, 400));
//            primaryStage.show();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//@Override
//public void start(Stage primaryStage) throws Exception {
//    try {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentView.fxml"));
//        VBox root = loader.load();
//        Scene scene = new Scene(root, 600, 400);
//
//        primaryStage.setTitle("Login Form FXML Application");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}


}
