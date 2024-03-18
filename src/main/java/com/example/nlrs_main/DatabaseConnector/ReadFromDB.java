package com.example.nlrs_main.DatabaseConnector;

import javafx.scene.control.ChoiceBox;

import java.sql.*;

public class ReadFromDB {
    public boolean getLoginDetailsFromDB(String userID, String password) {
        try {
            String host = "jdbc:mysql://localhost:3306/nlrs";
            String uName = "root";
            String uPass = "1234";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            String sql = "SELECT COUNT(*) FROM users WHERE userID = ? AND password = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, userID);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
