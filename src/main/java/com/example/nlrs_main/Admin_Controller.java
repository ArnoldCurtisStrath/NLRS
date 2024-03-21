package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadWriteDB;
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

public class Admin_Controller extends Login_Page implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private ImageView adminPageIcon;
    @FXML
    private Label adminNameId;
    @FXML
    private Label dateTimeID;
    @FXML
    private ImageView manageStudentsIcon;
    @FXML
    private ImageView manageAdminIcon;
    @FXML
    private ImageView manageLecturerIcon;
    @FXML
    private ImageView performanceReportIcon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ReadWriteDB userDetails = new ReadWriteDB();

        /**Image pageIcon = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//" +
                "example//nlrs_main//ImagesAndIcons//AdminHomeIcon.png/");
        adminPageIcon.setImage(pageIcon);

        Image studentsIcon = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//" +
                "example//nlrs_main//ImagesAndIcons//Manage Students.png/");
        manageStudentsIcon.setImage(studentsIcon);

        Image adminIcon = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//" +
                "example//nlrs_main//ImagesAndIcons//Admin.png/");
        manageAdminIcon.setImage(adminIcon);

        Image lecturesIcon = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//" +
                "example//nlrs_main//ImagesAndIcons//Lecturers.png/");
        manageLecturerIcon.setImage(lecturesIcon);

        Image reportIcon = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//" +
                "example//nlrs_main//ImagesAndIcons//Performance Report.png/");
        performanceReportIcon.setImage(reportIcon);**/

        adminNameId.setText(userDetails.getUserDetailsFromDB(getuserID()));

        Date currentDate = new Date();
        dateTimeID.setText(String.valueOf(currentDate));

    }


    @FXML
    private void adminCancelButtonAction(ActionEvent event){
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

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
