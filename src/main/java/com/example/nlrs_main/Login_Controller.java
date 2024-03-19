package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadWriteDB;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

//This is poor but do not remove the commented out end of the login_Controller className
//It works together with the methods that display images/Icons on our windows.
public class Login_Controller extends ReadWriteDB /**implements Initializable**/ {
    @FXML
    private ImageView loginIcon;
    @FXML
    private ChoiceBox<String> accountTypeChoiceBox;

    @FXML
    private TextField userIDtf;

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField passwordtf;

    @FXML
    private Label messageLabel;

    private Runnable onLoginHandler;

    //I have commented out this part. So it doesn't give any of us problems.
    //But it works. so don't worry about the icons and don't change anything on it.
    /**@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("C://Users//Alvin Majawa//Desktop//IS Project Final//src//main//java//com//example//nlrs_main//ImagesAndIcons//loginIcon.png/");
        loginIcon.setImage(image);
    }**/
    @FXML
    private void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    @FXML
    private void loginButton(ActionEvent event) {
        String userID = userIDtf.getText();
        String password = passwordtf.getText();

        //I am going to cook and do some html for the project.
        //I will fix this probably tonight or later in the afternoon.
        try {
            if (!userID.isBlank() && !password.isBlank()) {
                if (!accountTypeChoiceBox.getValue().isBlank()) {
                    ReadWriteDB dbReader = new ReadWriteDB();
                    boolean loginSuccess = dbReader.getLoginDetailsFromDB(userID, password);
                    if (loginSuccess) {
                        if (onLoginHandler != null) {
                            onLoginHandler.run();
                            System.out.println(getAccountType());
                        }
                    } else {
                        messageLabel.setText("Incorrect credentials. Please try again.");
                    }
                } else {
                    messageLabel.setText("Select Account Type!");
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
