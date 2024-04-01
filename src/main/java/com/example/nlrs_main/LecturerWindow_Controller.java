package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadWriteDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LecturerWindow_Controller {
    @FXML
    private Button unit1;
    @FXML
    private Button unit2;
    @FXML
    private Button unit3;
    @FXML
    private Button unit4;

    private String lecturerID;

    public void setUnitFromDB(String lecturerID) {
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();
            if (dbConnect != null) {
                String query = "SELECT unitName FROM units WHERE userID = ?";
                PreparedStatement statement = dbConnect.prepareStatement(query);
                statement.setString(1, lecturerID);
                ResultSet resultSet = statement.executeQuery();

                // Clear previous text on buttons
                unit1.setText("Unit Name");

                // Loop through the result set and set unit names on buttons
                int i = 1;
                while (resultSet.next() && i <= 4) {
                    String unitName = resultSet.getString("unitName");
                    switch (i) {
                        case 1:
                            unit1.setText(unitName);
                        break;
                    }
                    i++;
                }

                resultSet.close();
                statement.close();
                dbConnect.close();
            } else {
                // Handle case when connection is null
                System.out.println("Database Connection Failed");
            }
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    @FXML
    public void changeAllLecturerDetails(ActionEvent event) {
        // Retrieve the unit name from the clicked button
        String unitName = ((Button) event.getSource()).getText();

        // Pass lecturer ID and unit name to PerformanceReport_Controller
        openPerformanceReport(lecturerID, unitName);
    }
    @FXML
    public void changeLecturerContactDetails(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LecturerContactDetailsUpdate.fxml"));
            Parent root1 = fxmlLoader.load();
            updatePassword_Controller controller = fxmlLoader.getController();

            // Pass data to PerformanceReport_Controller
            controller.initialize(lecturerID);

            // Create a new stage
            Stage performanceReportStage = new Stage();
            performanceReportStage.setTitle("Update Password Page");
            performanceReportStage.initModality(Modality.APPLICATION_MODAL);
            performanceReportStage.setScene(new Scene(root1));
            performanceReportStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void changeLecturePassword(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LecturerPasswordUpdate.fxml"));
            Parent root1 = fxmlLoader.load();
            updatePassword_Controller controller = fxmlLoader.getController();

            // Pass data to PerformanceReport_Controller
            controller.initialize(lecturerID);

            // Create a new stage
            Stage performanceReportStage = new Stage();
            performanceReportStage.setTitle("Update Password Page");
            performanceReportStage.initModality(Modality.APPLICATION_MODAL);
            performanceReportStage.setScene(new Scene(root1));
            performanceReportStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void loadLecturerPerfomanceReport(ActionEvent event) {
        // Retrieve the unit name from the clicked button
        String unitName = ((Button) event.getSource()).getText();

        // Pass lecturer ID and unit name to PerformanceReport_Controller
        openPerformanceReport(lecturerID, unitName);
    }
    private void openPerformanceReport(String lecturerID, String unitName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PerformanceReport.fxml"));
            Parent root1 = fxmlLoader.load();
            PerformanceReport_Controller controller = fxmlLoader.getController();

            // Pass data to PerformanceReport_Controller
            controller.initialize(lecturerID, unitName);

            // Create a new stage
            Stage performanceReportStage = new Stage();
            performanceReportStage.setTitle("Lecturer Performance Report");
            performanceReportStage.initModality(Modality.APPLICATION_MODAL);
            performanceReportStage.setScene(new Scene(root1));
            performanceReportStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getLecturerID() {
        String lecturerID = null;
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();
            if (dbConnect != null) {
                String query = "SELECT userID FROM users WHERE userType = 'Lecturer'";
                PreparedStatement statement = dbConnect.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                // Assuming you want to retrieve the first lecturer's ID
                if (resultSet.next()) {
                    lecturerID = resultSet.getString("userID");
                }

                resultSet.close();
                statement.close();
                dbConnect.close();
            } else {
                System.out.println("Database Connection Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred: " + e.getMessage());
        }

        // If lecturerID is still null, return a default value
        return lecturerID != null ? lecturerID : "L001";
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }





}
