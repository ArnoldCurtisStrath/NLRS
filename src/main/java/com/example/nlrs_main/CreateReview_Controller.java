package com.example.nlrs_main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CreateReview_Controller {

    @FXML
    private TextField questionTextField;

    @FXML
    private Button addQuestionButton;

    @FXML
    private ListView<String> questionsListView;

    @FXML
    private ChoiceBox<String> categoryChoiceBox;

    private ObservableList<String> questions = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        questionsListView.setItems(questions);

        // Add categories to the categoryChoiceBox
        categoryChoiceBox.getItems().addAll(
                "Knowledge and Expertise",
                "Teaching Style and Delivery",
                "Clarity of Explanations",
                "Engagement and Interaction with Students",
                "Responsiveness and Availability",
                "Course Organization and Structure",
                "Fairness and Objectivity in Grading",
                "Use of Visual Aids and Technology",
                "Providing Relevant and Up-to-Date Content",
                "Encouraging Critical Thinking and Discussion",
                "Providing Constructive Feedback",
                "Punctuality and Time Management",
                "Respect for Diverse Perspectives",
                "Enthusiasm and Passion for Teaching",
                "Overall Effectiveness in Facilitating Learning"
        );

        // Add event handlers
        categoryChoiceBox.setOnAction(event -> handleCategorySelection());
        addQuestionButton.setOnAction(event -> addQuestion());
    }

    private void handleCategorySelection() {
        String selectedCategory = categoryChoiceBox.getValue();
        if (selectedCategory != null) {
            questionTextField.clear();
            questionTextField.setPromptText("Enter question for " + selectedCategory);
        }
    }

    private void addQuestion() {
        String selectedCategory = categoryChoiceBox.getValue();
        if (selectedCategory != null) {
            String question = questionTextField.getText().trim();
            if (!question.isEmpty()) {
                questions.add(selectedCategory + ": " + question);
                questionTextField.clear();
            }
        }
    }
}