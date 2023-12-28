/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladorloging;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/materiasingcomp";
    private String dbUser = "root";
    private String dbPassword = "";

    public boolean registerUser(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String query = "INSERT INTO usuarios (username, password, rol) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, "user"); // Establecer el rol predeterminado

            int rowsInserted = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rowsInserted > 0; // Devuelve true si se insertó al menos una fila
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
