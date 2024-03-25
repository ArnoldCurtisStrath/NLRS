package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadWriteDB;
import com.example.nlrs_main.NLS.NaturalLanguageAnalyzer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerReview_Controller {
    @FXML
    private VBox questionReviewContainer;

    private List<QuestionReviewContainer> questionReviewContainers;

    public void initialize() {
        questionReviewContainers = new ArrayList<>();
        // Set the number of questions here
        int numQuestions = 10;
        for (int i = 0; i < numQuestions; i++) {
            QuestionReviewContainer container = new QuestionReviewContainer("Question " + (i + 1));
            questionReviewContainers.add(container);
            questionReviewContainer.getChildren().add(container.getRoot());
        }
    }

    @FXML
    private void submitReviews() {
        StudentsF_Controller studentsF_controller = new StudentsF_Controller();
        for (QuestionReviewContainer container : questionReviewContainers) {
            String review = container.getReview();
            System.out.println("Review submitted for question: " + container.getQuestion() + "\nReview: " + review);
            NaturalLanguageAnalyzer nls = new NaturalLanguageAnalyzer();
            int reviewV = nls.analyzeSentiment(review);
            System.out.println("This is the rating for the review of the question  " + reviewV);
            studentsF_controller.inputReview(review, reviewV);
        }
    }

    private static class QuestionReviewContainer {
        private Label questionLabel;
        private TextArea reviewTextArea;
        private VBox root;

        public QuestionReviewContainer(String question) {
            questionLabel = new Label("Question: " + question);
            reviewTextArea = new TextArea();
            reviewTextArea.setPromptText("Enter your review here");

            root = new VBox(10, questionLabel, reviewTextArea);
        }

        public String getQuestion() {
            return questionLabel.getText().substring(10); // Remove "Question: " prefix
        }

        public String getReview() {
            return reviewTextArea.getText();
        }

        public VBox getRoot() {
            return root;
        }
    }
}