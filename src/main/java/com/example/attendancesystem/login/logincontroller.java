package com.example.attendancesystem.login;

import com.example.attendancesystem.LoginFormApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.List;


public class logincontroller {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessagelabel;

//    @FXML
//    private MenuButton menuButton;

//    public void onLoginAs(ActionEvent event) {
//        String selectedRole = menuButton.getText();
//
//        if (selectedRole.equals("Teacher")) {
//            // Handle Teacher login
//        } else if (selectedRole.equals("Student")) {
//            // Load StudentView.fxml for Student login
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/attendancesystem/student/StudentView.fxml"));
//                Parent root = loader.load();
//
////                 StudentController studentController = loader.getController();
//
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                Scene scene = new Scene(root);
//                stage.setTitle("Student Interface");
//                stage.setScene(scene);
//                stage.show();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


//    public void onLogin(ActionEvent event) throws IOException {
//        String adminUsername = "Admin";
//        String adminPassword = "admin123";
//        List<User> users = Userdata.loadUsers();
//
//        String enterUsername = usernameTextField.getText();
//        String enterPassword = passwordField.getText();
//        if (!usernameTextField.getText().isBlank() && !passwordField.getText().isBlank()) {
//            if (enterUsername.equals(adminUsername) && enterPassword.equals(adminPassword)) {
//                loginMessagelabel.setText("You are trying to login");
//                Parent root = FXMLLoader.load(LoginFormApp.class.getResource("hello-view.fxml"));
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                Scene scene = new Scene(root);
//                stage.setTitle("View");
//                stage.setWidth(stage.getWidth());
//                stage.setHeight(stage.getHeight());
//                stage.setScene(scene);
//                stage.show();
//            }
//            else if (users != null) {
//                for (User user : users) {
//                    if (user.getUsername().equals(enterUsername) && user.getPassword().equals(enterPassword)) {
//                        loginMessagelabel.setText("You are trying to login");
//                        Parent root = FXMLLoader.load(LoginFormApp.class.getResource("hello-view.fxml"));
//                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                        Scene scene = new Scene(root);
//                        stage.setTitle("View");
//                        stage.setWidth(stage.getWidth());
//                        stage.setHeight(stage.getHeight());
//                        stage.setScene(scene);
//                        stage.show();
//                    }
//                    else {
//                        loginMessagelabel.setText("Incorrect username and password");
//                    }
//                }
//            }
//        }
////        else if (users !=null) {
////            for (User user : users){
////                if(user.getUsername().equals(enterUsername) && user.getPassword().equals(enterPassword)){
////                    loginMessagelabel.setText("You are trying to login");
////                    Parent root = FXMLLoader.load(LoginFormApp.class.getResource("hello-view.fxml"));
////                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////                    Scene scene = new Scene(root);
////                    stage.setTitle("View");
////                    stage.setWidth(stage.getWidth());
////                    stage.setHeight(stage.getHeight());
////                    stage.setScene(scene);
////                    stage.show();
////                }
////                else {
////                    loginMessagelabel.setText("Incorrect username and password");
////                }
////            }
////        }
//        else {
//            loginMessagelabel.setText("Please enter username and password");
//        }
//    }






    public void onLogin(ActionEvent event) throws IOException {
        String adminUsername = "Admin";
        String adminPassword = "admin123";
        List<User> users = Userdata.loadUsers();

        String enterUsername = usernameTextField.getText();
        String enterPassword = passwordField.getText();

        if (enterUsername.isBlank() || enterPassword.isBlank()) {
            loginMessagelabel.setText("Please enter both username and password");
        } else if (enterUsername.equals(adminUsername) && enterPassword.equals(adminPassword)) {
            // Admin login
            loginMessagelabel.setText("Admin login successful");
            openMainView(event);
        } else if (users != null) {
            // User login
            boolean userAuthenticated = false;
            for (User user : users) {
                if (user.getUsername().equals(enterUsername) && user.getPassword().equals(enterPassword)) {
                    userAuthenticated = true;
                    break;
                }
            }

            if (userAuthenticated) {
                loginMessagelabel.setText("User login successful");
                openMainView(event);
            } else {
                loginMessagelabel.setText("Incorrect username or password");
            }
        }
    }
    private void openMainView(ActionEvent event) throws IOException {
        VBox root = FXMLLoader.load(LoginFormApp.class.getResource("StudentView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("View");
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }


//    public void onLogin(ActionEvent event) throws IOException {
//        String Username = "Admin";
//        String Password = "admin123";
//        List<User> users = Userdata.loadUsers();
//
//        String username = usernameTextField.getText();
//        String password = passwordField.getText();
//        if(null != users){
////            List<User> users = Userdata.loadUsers();
//            for(User user: users){
//                if(user.getUsername().equals(username) && user.getPassword().equals(password)){
//                    loginMessagelabel.setText("Login success");
//                    openMainView(event);
//                }
//                else if (username.equals(Username) && password.equals(Password)) {
//                    loginMessagelabel.setText("Login success");
//                    openMainView(event);
//                }
//            }
//        }
//        if (username.isEmpty() || password.isEmpty()) {
//            loginMessagelabel.setText("Please enter both username and password.");
//        } else {
//            loginMessagelabel.setText("Wrong username or password");
//        }
//
//    }




    public void onResgister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(LoginFormApp.class.getResource("RegisterView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Register View");
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.setScene(scene);
        stage.show();




    }
}


