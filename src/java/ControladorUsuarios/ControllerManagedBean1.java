package ControladorUsuarios;

import ModelUsuarios.GestorBD1;
import ModelUsuarios.Uea1;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "controllerManagedBean1")
@SessionScoped
public class ControllerManagedBean1 {

    public String id;
    public String username;
    public String password;
    public String rol;

    public GestorBD1 gestorBD;
    private static ArrayList<Uea1> ueasList1;

    public ControllerManagedBean1() {
        gestorBD = new GestorBD1();
        ueasList1 = gestorBD.leerUeas1();
    }

    public void pedirDatosUEA_aAgregar1() {
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("agregar_UEA.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void localizarUEA1() {
        if (gestorBD.localizaUEA1(id, username, password ,rol))
try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("modificar_UEA.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean1.class.getName()).log(Level.SEVERE, null, ex);
        } else
try {
            ueasList1 = gestorBD.leerUeas1();
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("error.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public String agregarUsuario() {

        return "TablaDatos.xhtml";

    }

    
      public String usuariollamardatos() {

        return "usuariollamardatos.xhtml";

    }


    public String agregarUsuario1() {
        // Aquí lógica para agregar un nuevo usuario a la base de datos

        // Después de agregar el usuario, actualiza la lista de usuarios
        ueasList1 = gestorBD.leerUeas1();

        return "TablaDatos_1.xhtml";
    }

    public String agregartabla2() {

        return "TablaDatos_2.xhtml";

    }

    public String agregartabla3() {

        return "TablaDatos_3.xhtml";

    }

    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public ArrayList<Uea1> getUeasList1() {
        return ueasList1;
    }

}
