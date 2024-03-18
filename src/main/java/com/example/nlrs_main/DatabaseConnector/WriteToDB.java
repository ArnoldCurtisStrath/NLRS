package com.example.nlrs_main.DatabaseConnector;

import com.example.nlrs_main.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriteToDB extends Users
{
    public void insertUserDetailsToDB(Users users) {
        String host = "jdbc:mysql://localhost:3306/nlp_schema";
        String uName = "root";
        String uPass = "1234";

        try (Connection con = DriverManager.getConnection(host, uName, uPass)) {
            String sql = "INSERT INTO users (userType, userName, password, firstName, lastName, dateOfBirth, email, " +
                    "phoneNumber, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, getUserType());
            preparedStatement.setString(2, getUserName());
            preparedStatement.setString(3, getPassword());
            preparedStatement.setString(4, getFirstName());
            preparedStatement.setString(5, getLastName());
            preparedStatement.setString(6, getDateOfBirth());
            preparedStatement.setString(7, getEmail());
            preparedStatement.setInt(   8, getContact());
            preparedStatement.setString(9, getCountry());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(getUserType() + "account created Successfully.");
            } else {
                System.out.println("Failed to create " + getUserType() + " account.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting user details: " + e.getMessage());
        }
    }



}
