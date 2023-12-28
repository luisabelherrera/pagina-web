/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControladorUsuarios;

import ModelUsuarios.Uea1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/obtenerUsuarios")
public class ObtenerUsuariosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        
        // Aquí realiza la lógica para obtener los usuarios de la base de datos
        ArrayList<Uea1> usuarios = obtenerUsuariosDeLaBaseDeDatos(); // Método ficticio para obtener usuarios
        
        // Convierte la lista de usuarios a JSON
        String jsonUsuarios = convertirAJSON(usuarios);
        
        // Envía el JSON como respuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(jsonUsuarios);
        out.flush();
    }
    
    // Método ficticio para obtener usuarios de la base de datos
    private ArrayList<Uea1> obtenerUsuariosDeLaBaseDeDatos() {
        // Aquí implementa la lógica para obtener los usuarios de la base de datos
        // Retorna una lista de usuarios (puedes usar tu lógica y acceso a la base de datos)
        return new ArrayList<Uea1>();
    }
    
    // Método ficticio para convertir lista de usuarios a JSON
    private String convertirAJSON(ArrayList<Uea1> usuarios) {
        // Aquí utiliza librerías como Gson, Jackson, etc., para convertir la lista de usuarios a JSON
        // Por ejemplo, usando Gson
        // Gson gson = new Gson();
        // return gson.toJson(usuarios);
        return ""; // JSON vacío por simplicidad en este ejemplo
    }
}
