package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Login_Controller extends ReadFromDB {
    @FXML
    private ChoiceBox<String> accountTypeChoiceBox;

    @FXML
    private TextField userIDtf;

    @FXML
    public Button cancelButton;

    @FXML
    private PasswordField passwordtf;

    @FXML
    private Label messageLabel; // Added message label

    private Runnable onLoginHandler;

    @FXML
    private void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loginButton(ActionEvent event) {
        String userID = userIDtf.getText();
        String password = passwordtf.getText();

        try {
            if (!userID.isBlank() && !password.isBlank()) {
                if (!accountTypeChoiceBox.getValue().isBlank()) {
                    ReadFromDB dbReader = new ReadFromDB();
                    boolean loginSuccess = dbReader.getLoginDetailsFromDB(userID, password);
                    if (loginSuccess) {
                        if (onLoginHandler != null) {
                            onLoginHandler.run();
                        }
                    } else {
                        messageLabel.setText("Incorrect credentials. Please try again.");
                    }
                } else {
                    messageLabel.setText("Select Account Type!!");
                }
            } else {
                messageLabel.setText("Fill in the Details");
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
