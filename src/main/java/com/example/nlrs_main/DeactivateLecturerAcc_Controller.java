package com.example.nlrs_main;

import com.example.nlrs_main.DatabaseConnector.ReadWriteDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeactivateLecturerAcc_Controller extends Users implements Initializable {
    ReadWriteDB databaseConnection = new ReadWriteDB();

    @FXML
    private TableView<Users> tableView;
    @FXML
    private TableColumn<Users, Integer> idNumberC;
    @FXML
    private TableColumn<Users, String> usernameC;
    @FXML
    private TableColumn<Users, String> passwordC;
    @FXML
    private TableColumn<Users, String> firstNameC;
    @FXML
    private TableColumn<Users, String> lastNameC;
    @FXML
    private TableColumn<Users, String> dOBC;
    @FXML
    private TableColumn<Users, String> emailC;
    @FXML
    private TableColumn<Users, Integer> phoneNumberC;
    @FXML
    private TableColumn<Users, String> countryC;
    @FXML
    private TableColumn<Users, String> courseC;
    @FXML
    private TableColumn<Users, Integer> statusC;
    @FXML
    private Label messageLabel;
    ObservableList<Users> lecturerDeactivationList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Connection  dbConnect = databaseConnection.getConnection();

       String userType = "Lecturer";
       setUserType(userType);

       String sqlQuery = "SELECT userID, userName, password, firstName, lastName, dateOfBirth, email, phoneNumber, country, course, status FROM users WHERE userType = 'Lecturer'";

       try {
           Statement statement = dbConnect.createStatement();
           ResultSet resultSet = statement.executeQuery(sqlQuery);

           while (resultSet.next()){
               int lecturerID = resultSet.getInt("userID");
               String username = resultSet.getString("userName");
               String password1 = resultSet.getString("password");
               String firstName1 = resultSet.getString("firstName");
               String lastName1 = resultSet.getString("lastName");
               String dateOfBirth1 = resultSet.getString("dateOfBirth");
               String email1 = resultSet.getString("email");
               int phoneNumber1 = resultSet.getInt("phoneNumber");
               String country1 = resultSet.getString("country");
               String course1 = resultSet.getString("course");
               boolean status1 = resultSet.getBoolean("status");

               lecturerDeactivationList.add(new Users());
           }
           idNumberC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           usernameC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           passwordC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           firstNameC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           lastNameC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           idNumberC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           idNumberC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           idNumberC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           idNumberC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           idNumberC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           idNumberC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));
           idNumberC.setCellValueFactory(new PropertyValueFactory<>("lecturerID"));


       } catch (SQLException e){
           Logger.getLogger(DeactivateLecturerAcc_Controller.class.getName()).log(Level.SEVERE, null, e);
           e.printStackTrace();

       }

    }






}
