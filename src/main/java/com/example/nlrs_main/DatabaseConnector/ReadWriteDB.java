package com.example.nlrs_main.DatabaseConnector;

import com.example.nlrs_main.Users;

import java.sql.*;

public class ReadWriteDB extends Users {
    private Connection databaseLink;

    public Connection getConnection(){
        String dbName = "nlrs";
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://192.168.100.5/"+dbName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
    public boolean getLoginDetailsFromDB(String userID, String password, String accountType) {
        try {
            Connection dbConnect = getConnection();

            String sql = "SELECT COUNT(*) FROM users WHERE userID = ? AND password = ? AND userType = ?";
            try (PreparedStatement preparedStatement = dbConnect.prepareStatement(sql)) {
                preparedStatement.setString(1, userID);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, accountType);
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
