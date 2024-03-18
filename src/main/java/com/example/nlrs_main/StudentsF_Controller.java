package com.example.nlrs_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;



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
}