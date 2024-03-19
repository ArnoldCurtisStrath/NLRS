package com.example.nlrs_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageLecturers_Controller {
    @FXML
    public void loadRegisterLecturerScene(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LecturerRegistration.fxml"));
            Parent root1 = fxmlLoader.load();
            // Create a new stage
            Stage lecturerRegistrationStage = new Stage();
            lecturerRegistrationStage.setTitle("Lecturer Registration");
            lecturerRegistrationStage.initModality(Modality.APPLICATION_MODAL);
            lecturerRegistrationStage.setScene(new Scene(root1));
            lecturerRegistrationStage.showAndWait();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    public void loadDeActivateLecturerAccScene(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeactivateLecturerAcc.fxml"));
            Parent root1 = fxmlLoader.load();
            // Create a new stage
            Stage lecturerRegistrationStage = new Stage();
            lecturerRegistrationStage.setTitle("Lecturer Account De-Activation");
            lecturerRegistrationStage.initModality(Modality.APPLICATION_MODAL);
            lecturerRegistrationStage.setScene(new Scene(root1));
            lecturerRegistrationStage.showAndWait();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


}
