package Modelconexionlogin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import Controladorloging.RegistrationService;

@ManagedBean
@ViewScoped
public class RegisterBean {

    private String id;
    private String newUsername;
    private String newPassword;
    

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String register() {
        RegistrationService registrationService = new RegistrationService();
        boolean isRegistered = registrationService.registerUser(newUsername, newPassword);

        if (isRegistered) {
            return "login.xhtml"; // Redirigir a una página de éxito
        } else {
            return "failure"; // Redirigir a una página de error
        }
    }
}
