package com.example.nlrs_main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ManageLecturers_Controller implements Initializable {
    @FXML
    private Button logoutButton;
    @FXML
    private ImageView manageLecturersIcon;
    @FXML
    private ImageView registrationImage;
    @FXML
    private ImageView deactivationImage1;
    @FXML
    private Label adminNameId;
    @FXML
    private Label dateTimeID;

    @FXML
    private void manageLecturerCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //ReadWriteDB userDetails = new ReadWriteDB();

        /**Image studentsIcon = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//" +
                "example//nlrs_main//ImagesAndIcons//Lecturers.png/");
        manageLecturersIcon.setImage(studentsIcon);

        Image registrationIcon = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//" +
                "example//nlrs_main//ImagesAndIcons//registrationImage.png/");
        registrationImage.setImage(registrationIcon);

        Image deactivationIcon = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//" +
                "example//nlrs_main//ImagesAndIcons//Account De-Activation.png/");
        deactivationImage1.setImage(deactivationIcon);**/

        //adminNameId.setText(userDetails.getUserDetailsFromDB(getuserID()));

        Date currentDate = new Date();
        dateTimeID.setText(String.valueOf(currentDate));

    }
    @FXML
    public void loadRegisterLecturerScene(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LecturerRegistration.fxml"));
            Parent root1 = fxmlLoader.load();
            // Create a new stage
            Stage lecturerRegistrationStage = new Stage();
            lecturerRegistrationStage.setTitle("Lecturer Account Registration");
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
