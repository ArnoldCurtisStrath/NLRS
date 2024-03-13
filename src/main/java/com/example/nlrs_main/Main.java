package com.example.nlrs_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

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

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(loginScene);
        primaryStage.show();

        Login_Controller loginController = fxmlLoader.getController();
        loginController.setOnLoginHandler(() -> handleLogin(loginController));
    }

    private void handleLogin(Login_Controller loginController) {
        String accountType = loginController.getAccountType();
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
                System.out.println("Invalid account type selected");
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
