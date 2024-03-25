package com.example.nlrs_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Admin_Controller extends Login_Page {

    @FXML
    public void loadManageStudentsScene(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manage_Students.fxml"));
            Parent root1 = fxmlLoader.load();
            // Create a new stage
            Stage manageStudentsStage = new Stage();
            manageStudentsStage.setTitle("Manage Students");
            manageStudentsStage.initModality(Modality.APPLICATION_MODAL); // This makes the new stage modal
            manageStudentsStage.setScene(new Scene(root1));
            manageStudentsStage.showAndWait(); // Show and wait for the new stage to be closed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadManageLecturersScene(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manage_Lecturers.fxml"));
            Parent root1 = fxmlLoader.load();
            // Create a new stage
            Stage manageLecturersStage = new Stage();
            manageLecturersStage.setTitle("Manage Lecturers");
            manageLecturersStage.initModality(Modality.APPLICATION_MODAL);
            manageLecturersStage.setScene(new Scene(root1));
            manageLecturersStage.showAndWait();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadCreateReviewStage(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateReview.fxml"));
            Parent root1 = fxmlLoader.load();

            // Create a new stage
            Stage createReviewStage = new Stage();
            createReviewStage.setTitle("Create Review");
            createReviewStage.initModality(Modality.APPLICATION_MODAL);
            createReviewStage.setScene(new Scene(root1));
            createReviewStage.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
