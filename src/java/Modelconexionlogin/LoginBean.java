/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelconexionlogin;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Controladorloging.LoginService;

@ManagedBean
@SessionScoped
public class LoginBean {

    private String username;
    private String password;
    private String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getters y Setters para password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public String login() {
    LoginService loginService = new LoginService();
    String userRole = loginService.getRol(username); // Obtener el rol del usuario desde la base de datos u otra fuente

    if (userRole != null && loginService.authenticateUser(username, password)) {
        FacesContext context = FacesContext.getCurrentInstance();

        // Verificar el rol del usuario para permitir/denegar acceso
        if (userRole.equals("user")) {
            context.getExternalContext().getSessionMap().put("loggedInUser", username);
            context.getExternalContext().getSessionMap().put("userRole", userRole); // Guardar el rol del usuario en la sesión
            return "selecionardecarrera.xhtml"; // Redirigir a la página permitida para usuarios
        } else if (userRole.equals("admin")) {
            context.getExternalContext().getSessionMap().put("loggedInUser", username);
            context.getExternalContext().getSessionMap().put("userRole", userRole); // Guardar el rol del usuario en la sesión
            return "TablaDatos.xhtml"; // Redirigir a la página para administradores
        } else if (userRole.equals("coordinador")) {
            context.getExternalContext().getSessionMap().put("loggedInUser", username);
            context.getExternalContext().getSessionMap().put("userRole", userRole); // Guardar el rol del usuario en la sesión
            return "CoordinadorPanel.xhtml"; // Redirigir a la página para coordinadores
        } else {
            // Otros roles o manejo de excepciones aquí
            return "PaginaNoAutorizada.xhtml"; // Redirigir a una página indicando falta de autorización
        }
    } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al ingresar", "Usuario o contraseña incorrectos. Inténtalo de nuevo."));
        return "login.xhtml"; // Permanecer en la misma página con un mensaje de error
    }
}
}