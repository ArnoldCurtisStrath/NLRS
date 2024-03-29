package com.example.nlrs_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
//Hello Majawa
//This is Genius territory
//Man cant use comments


public class Main extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent loginRoot = fxmlLoader.load();
        Scene loginScene = new Scene(loginRoot, 594, 400);

        //The commented out line of code is what hides the minimize, close and maximize buttons
        //I commented it, so you can be able to use them if you want.
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(loginScene);
        primaryStage.show();

        Login_Controller loginController = fxmlLoader.getController();
        loginController.setOnLoginHandler(() -> handleLogin(loginController));
    }

    private void handleLogin(Login_Controller loginController) {
        String userID = loginController.getUserID();
        try {
            String accountType = loginController.getUserAccountType(userID);
            if (accountType != null) {
                String selectedAccountType = loginController.accountTypeChoiceBox.getValue();
                if (selectedAccountType.equalsIgnoreCase(accountType)) {
                    switch (accountType) {
                        case "Admin":
                            loadAdminScene();
                            break;
                        case "Student":
                            loadStudentScene();
                            break;
                        case "Lecturer":
                            // Handle Lecturer case
                            break;
                        default:
                            System.out.println("Invalid account type retrieved from the database");
                    }
                } else {
                    System.out.println("Invalid account type selected");
                }
            } else {
                System.out.println("Failed to retrieve account type from the database");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadAdminScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin_Page.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setTitle("Admin Dashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStudentScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Students_fPage.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setTitle("Student Dashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
