package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadWriteDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LecturerRegistration_Controller extends Login_Controller {

    @FXML
    private ImageView registrationImage;

    @FXML
    private Button cancelButton;

    @FXML
    private Button lecturerRegistrationButtonid;

    @FXML
    private PasswordField defaultPasswordTF;

    @FXML
    private TextField firstNameTF;

    @FXML
    private TextField lastNameTF;

    @FXML
    private TextField courseNameTF;

    @FXML
    private TextField phoneNumberTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField countryTF;

    @FXML
    private TextField dateOfBirthTF;

    @FXML
    private Label registrationSuccessMessageLabel;

    @FXML
    private Label registrationMessageFailureLabel;

    @FXML
    private void cancelButton2Action(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registrationButtonAction(ActionEvent event) {
        if (validateFields()) {
            avoidDuplication();
        } else {
            registrationMessageFailureLabel.setText("Please fill up the registration form.");
        }
    }

    private boolean validateFields() {
        return !firstNameTF.getText().isEmpty() &&
                !lastNameTF.getText().isEmpty() &&
                !dateOfBirthTF.getText().isEmpty() &&
                !emailTF.getText().isEmpty() &&
                !countryTF.getText().isEmpty() &&
                !phoneNumberTF.getText().isEmpty();
    }

    private void lecturerRegistration() {
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();

            if (dbConnect != null) {
                String firstName = firstNameTF.getText();
                String lastName = lastNameTF.getText();
                String dateOfBirth = dateOfBirthTF.getText();
                String email = emailTF.getText();
                String country = countryTF.getText();
                String phoneNumber = phoneNumberTF.getText();
                setPassword("Cuba2030");
                String defaultPassword = getPassword();
                String userName = firstName + lastName;
                setUserType("Lecturer");
                String userType = getUserType();
                setUserStatus(true);
                boolean userStatus = getUserStatus();

                String insertDbFields = "INSERT INTO users (userType, userName, password, firstName, lastName, dateOfBirth, " +
                        "email, phoneNumber, course, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statement = dbConnect.prepareStatement(insertDbFields);
                statement.setString(1, userType);
                statement.setString(2, userName);
                statement.setString(3, defaultPassword);
                statement.setString(4, firstName);
                statement.setString(5, lastName);
                statement.setString(6, dateOfBirth);
                statement.setString(7, email);
                statement.setString(8, phoneNumber);
                statement.setString(9, country);
                statement.setBoolean(10, userStatus);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    registrationSuccessMessageLabel.setText(userType + " has been successfully Registered!");
                } else {
                    registrationMessageFailureLabel.setText("Registration failed. Please try again.");
                }
            } else {
                registrationMessageFailureLabel.setText("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            registrationMessageFailureLabel.setText("Registration failed due to a database error.");
        } catch (Exception e) {
            e.printStackTrace();
            registrationMessageFailureLabel.setText("An unexpected error occurred during registration.");
        }
    }

    private void avoidDuplication() {
        try {
            ReadWriteDB con = new ReadWriteDB();
            Connection dbConnect = con.getConnection();

            if (dbConnect != null) {
                String firstName = firstNameTF.getText();
                String lastName = lastNameTF.getText();
                String dateOfBirth = dateOfBirthTF.getText();
                String email = emailTF.getText();
                String country = countryTF.getText();
                String phoneNumber = phoneNumberTF.getText();
                setPassword("Cuba2030");
                String defaultPassword = getPassword();
                String userName = firstName + lastName;
                setUserType("Lecturer");
                String userType = getUserType();
                setUserStatus(true);
                boolean userStatus = getUserStatus();

                String sqlQuery = "SELECT * FROM users WHERE userType = ? AND userName = ? AND password = ? AND firstName = ? AND lastName = ? AND dateOfBirth = ? " +
                        "AND email = ? AND phoneNumber = ? AND course = ? AND status = ?";
                PreparedStatement statement = dbConnect.prepareStatement(sqlQuery);
                statement.setString(1, userType);
                statement.setString(2, userName);
                statement.setString(3, defaultPassword);
                statement.setString(4, firstName);
                statement.setString(5, lastName);
                statement.setString(6, dateOfBirth);
                statement.setString(7, email);
                statement.setString(8, phoneNumber);
                statement.setString(9, country);
                statement.setBoolean(10, userStatus);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    registrationMessageFailureLabel.setText("User: " + firstName + " " + lastName + " already exists!");
                } else {
                    lecturerRegistration();
                }
            } else {
                registrationMessageFailureLabel.setText("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            registrationMessageFailureLabel.setText("Database error occurred while checking for duplicates.");
        } catch (Exception e) {
            e.printStackTrace();
            registrationMessageFailureLabel.setText("An unexpected error occurred while checking for duplicates.");
        }
    }
}