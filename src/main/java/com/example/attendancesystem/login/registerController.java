package com.example.attendancesystem.login;

import com.example.attendancesystem.LoginFormApp;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class registerController {
    @FXML
    protected TextField usernameTextField;

    @FXML
    protected PasswordField passwordField;

    @FXML
    protected PasswordField confirmPasswordField;

    public void OnCreateButton(Event event) throws IOException {
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            // Show an error message to the user
            System.out.println("Passwords do not match!");
            return;
        }


        User newUser = new User();
        newUser.setUsername(usernameTextField.getText());
        newUser.setPassword(password);

        Userdata.saveUser(newUser);

        Parent root = FXMLLoader.load(LoginFormApp.class.getResource("LoginView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Register View");
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }

}
