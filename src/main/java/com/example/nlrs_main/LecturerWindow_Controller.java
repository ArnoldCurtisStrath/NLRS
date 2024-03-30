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

public class LecturerWindow_Controller implements Initializable {
    @FXML
    private Button unit1;
    @FXML
    private Button unit2;
    @FXML
    private Button unit3;
    @FXML
    private Button unit4;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUnitFromDB();
    }

    public void setUnitFromDB() {
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();
            if (dbConnect != null) {
                String query = "SELECT unitName FROM units WHERE unitID = 1";
                PreparedStatement statement = dbConnect.prepareStatement(query);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String unitName = resultSet.getString("unitName");
                    unit1.setText(unitName);
                    unit2.setText(unitName);
                    unit3.setText(unitName);
                    unit4.setText(unitName);
                } else {
                    unit1.setText("Unit Name");
                    unit2.setText("Unit Name");
                    unit3.setText("Unit Name");
                    unit4.setText("Unit Name");
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
    public void loadLecturerPerfomanceReport(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PerformanceReport.fxml"));
            Parent root1 = fxmlLoader.load();

            // Create a new stage
            Stage answerReviewsStage = new Stage();
            answerReviewsStage.setTitle("Lecturer Performance Report");
            answerReviewsStage.initModality(Modality.APPLICATION_MODAL);
            answerReviewsStage.setScene(new Scene(root1));
            answerReviewsStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
