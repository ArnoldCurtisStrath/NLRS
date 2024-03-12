package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login_Controller extends ReadFromDB {
    @FXML
    private ChoiceBox<String> accountTypeChoiceBox;

    @FXML
    private TextField userIDtf;

    @FXML
    private TextField passwordtf;

    @FXML
    private Label messageLabel; // Added message label

    private Runnable onLoginHandler;

    @FXML
    private void loginButton(ActionEvent event) {
        String accountType = getAccountType();
        String userID = userIDtf.getText();
        String password = passwordtf.getText();

        try {

            ReadFromDB dbReader = new ReadFromDB();
            boolean loginSuccess = dbReader.getLoginDetailsFromDB(userID, password);

            if (loginSuccess) {
                messageLabel.setText("Login successful!");
                if (onLoginHandler != null) {
                    onLoginHandler.run();
                }
            } else {
                messageLabel.setText("Incorrect credentials. Please try again.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid userID. Please enter a valid integer.");
        }
    }


    public String getAccountType() {
        return accountTypeChoiceBox.getValue();
    }

    public void setOnLoginHandler(Runnable handler) {
        this.onLoginHandler = handler;
    }
}
