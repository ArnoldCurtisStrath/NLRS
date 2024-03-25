package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadWriteDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StudentsF_Controller {



        @FXML
        public void loadAnswerReviewsScene(ActionEvent event)
        {
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AnswerReview.fxml"));
                Parent root1 = fxmlLoader.load();

                // Create a new stage
                Stage answerReviewsStage = new Stage();
                answerReviewsStage.setTitle("Answer Review");
                answerReviewsStage.initModality(Modality.APPLICATION_MODAL); // This makes the new stage modal
                answerReviewsStage.setScene(new Scene(root1));
                answerReviewsStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void inputReview(String comment, int CoScore)
    {
        try
        {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbconnect = con.getConnection();

            if(dbconnect != null)
            {
                String InsertDBReview = "INSERT INTO comments (Comment, CoScore) VALUES (?,?)";

                PreparedStatement statement = dbconnect.prepareStatement(InsertDBReview);
                statement.setString(1,comment);
                statement.setInt(2,CoScore);

                int rowsInserted = statement.executeUpdate();
                if(rowsInserted > 0)
                {
                    System.out.println("Review has been inserted");
                }else
                {
                    System.out.println("Review has not been inserted");
                }
            }else {
                System.out.println("Connection not established");
            }
        } catch (SQLException e) {
            System.out.println("Damn");
            throw new RuntimeException(e);
        }
    }
}