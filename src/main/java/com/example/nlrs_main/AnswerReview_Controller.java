package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadWriteDB;
import com.example.nlrs_main.NLS.NaturalLanguageAnalyzer;
import com.example.nlrs_main.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerReview_Controller extends Users {
    @FXML
    private VBox questionReviewContainer;

    private List<QuestionReviewContainer> questionReviewContainers;

    public void initialize() {
        questionReviewContainers = new ArrayList<>();
        setQuestionsFromDB();
    }

    @FXML
    private void submitReviews() {
        for (QuestionReviewContainer container : questionReviewContainers) {
            String review = container.getReview();
            System.out.println("Review submitted for question: " + container.getQuestion() + "\nReview: " + review);
            int reviewScore = analyzeSentiment(review);
            System.out.println("This is the rating for the review of the question: " + reviewScore);
            storeFeedback(review, reviewScore);
        }
    }

    private void setQuestionsFromDB() {
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();
            if (dbConnect != null) {
                String query = "SELECT question FROM formcontents WHERE unit = 'Data Structures'";
                PreparedStatement statement = dbConnect.prepareStatement(query);

                ResultSet resultSet = statement.executeQuery();
                int questionNumber = 1;
                while (resultSet.next()) {
                    String question = resultSet.getString("question");
                    QuestionReviewContainer container = new QuestionReviewContainer(questionNumber, question);
                    questionReviewContainers.add(container);
                    questionReviewContainer.getChildren().add(container.getRoot());
                    questionNumber++;
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
    }

    private void storeFeedback(String comment, int score) {
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();
            if (dbConnect != null) {
                int categoryID = getCategoryID(12);

                String query = "INSERT INTO feedback (userID, comment, CaID, stdID, CoScore) " +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = dbConnect.prepareStatement(query);
                statement.setString(1, getLecturerIDForDataStructures());
                statement.setString(2, comment);
                statement.setInt(3, categoryID);
                statement.setString(4, getStudentID());
                statement.setInt(5, score);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Feedback stored successfully");
                } else {
                    System.out.println("Failed to store feedback");
                }
                statement.close();
                dbConnect.close();
            } else {
                System.out.println("Database Connection Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private int analyzeSentiment(String text) {
        NaturalLanguageAnalyzer nls = new NaturalLanguageAnalyzer();
        return nls.analyzeSentiment(text);
    }

    private String getStudentID() {
        return getStuID();
    }

    private int getCategoryID(int formID) {
        int categoryID = 0;
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();
            if (dbConnect != null) {
                String query = "SELECT category FROM formcontents WHERE formID = ?";
                PreparedStatement statement = dbConnect.prepareStatement(query);
                statement.setInt(1, formID);

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    categoryID = resultSet.getInt("category");
                    if (!resultSet.isLast()) {
                        resultSet.next();
                    } else {
                        break;
                    }
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
        return categoryID;
    }


    private String getLecturerIDForDataStructures() {
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();
            if (dbConnect != null) {
                String query = "SELECT userID FROM units WHERE unitName = 'Data Structures'";
                PreparedStatement statement = dbConnect.prepareStatement(query);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String lecturerID = resultSet.getString("userID");
                    resultSet.close();
                    statement.close();
                    dbConnect.close();
                    return lecturerID;
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
        return " ";
    }

    private static class QuestionReviewContainer {
        private Label questionLabel;
        private TextArea reviewTextArea;
        private VBox root;

        public QuestionReviewContainer(int questionNumber, String question) {
            questionLabel = new Label("Question " + questionNumber + ": " + question);
            reviewTextArea = new TextArea();
            reviewTextArea.setPromptText("Enter your review here");

            root = new VBox(10, questionLabel, reviewTextArea);
        }

        public String getQuestion() {
            return questionLabel.getText().substring(questionLabel.getText().indexOf(":") + 2); // Extract question text
        }

        public String getReview() {
            return reviewTextArea.getText();
        }

        public VBox getRoot() {
            return root;
        }
    }
}
