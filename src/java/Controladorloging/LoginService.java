/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladorloging;

import java.sql.*;

public class LoginService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/materiasingcomp";
    private String dbUser = "root";
    private String dbPassword = "";

    public boolean authenticateUser(String username, String password) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        String query = "SELECT * FROM usuarios WHERE username=? AND password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        boolean isValidUser = resultSet.next();

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return isValidUser;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }

    }
     public String getRol(String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String query = "SELECT rol FROM usuarios WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            String userRole = null;
            if (resultSet.next()) {
                userRole = resultSet.getString("rol");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return userRole;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
    
    
