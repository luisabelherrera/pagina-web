package ControllerMaterias;


import java.util.ArrayList;
import ModelMaterias.GestorBD;
import ModelMaterias.Uea;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "controllerManagedBean")
@SessionScoped
public class ControllerManagedBean {

    public String mensajelogin;
    public String mensajeborrado;
    public String mensajeModificacion;
    public String id;
    public String clave;
    public String nombre;
    public Integer trimestre;
    public String requisito;
    public String dias;
    public String lugar;
    public String hora;
    public GestorBD gestorBD;

    private static ArrayList<Uea> ueasList;

    public ControllerManagedBean() {
        gestorBD = new GestorBD();
        ueasList = gestorBD.leerUeas();

    }

    public void pedirDatosUEA_aAgregar() {
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("agregar_UEA.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarUEA() {
        try {
            Uea ueaNueva = new Uea(id, clave, nombre, trimestre, requisito, dias, lugar, hora);
            if (gestorBD.guardarUea(ueaNueva)) {
                ueasList = gestorBD.leerUeas();
                FacesContext.getCurrentInstance().getExternalContext().redirect("TablaDatos.xhtml");
            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al guardar."));
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String irATablaDatos() {

        return "TablaDatos?faces-redirect=true";
    }

    public void pedirDatosUEA_aBorrar() {
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("borrar_UEA.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarUEA() {
        Uea ueaABorrar = new Uea(id, clave, nombre, trimestre, requisito, dias, lugar, hora);
        boolean borrado = gestorBD.borrarUea(ueaABorrar);

        if (borrado) {
            mensajeborrado = "¡UEA eliminada con éxito!";
        } else {
            mensajeborrado = "No se pudo eliminar la UEA.";
        }

        try {
            ueasList = gestorBD.leerUeas();
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("borrar_UEA.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void localizarUEA() {
        if (gestorBD.localizaUEA(clave, nombre))
try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("modificar_UEA.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } else
try {
            ueasList = gestorBD.leerUeas();
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("error.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarUEA() {
        Uea uea_a_Cambiar = new Uea(id, clave, nombre, trimestre, requisito, dias, lugar, hora);
        boolean modificado = gestorBD.modificarUea(uea_a_Cambiar);

        if (modificado) {
            mensajeModificacion = "¡Datos modificados!";
        } else {
            mensajeModificacion = "No se realizaron cambios.";
        }

        try {
            ueasList = gestorBD.leerUeas();
            FacesContext.getCurrentInstance().getExternalContext().redirect("modificar_UEA.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String otraPagina() {

        return "login.xhtml";
    }

    public String modificar() {

        return "modificar_UEA.xhtml";
    }

    public String login() {

        return "inicio/login.xhtml";
    }
    
    public String volverAInicio() {
        return "inicio.xhtml?faces-redirect=true";
    }

    public String seleccionarTecnologo() {
        // Lógica para seleccionar Tecnólogo en Desarrollo de Software
        return "tecnologo.xhtml?faces-redirect=true";
    }

    public String verTablaUsuarios() {
        // Lógica para ver la tabla de usuarios
        return "tabla_usuarios.xhtml?faces-redirect=true";
    }
    
    

    public void exportarDatos() {

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.responseReset();
        ec.setResponseContentType("text/csv");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"datos_ueas.csv\"");

        try (OutputStream output = ec.getResponseOutputStream(); PrintWriter writer = new PrintWriter(output)) {
            for (Uea uea : ueasList) {
                writer.println(uea.getClave() + "," + uea.getNombre() + "," + uea.getTrimestre() + "," + uea.getRequisito());
            }
        } catch (IOException e) {

        }

        fc.responseComplete();

    }



    
    
    public String getMensajelogin() {
        return mensajelogin;
    }

    public void setMensajelogin(String mensajelogin) {
        this.mensajelogin = mensajelogin;
    }

    public String getMensajeborrado() {
        return mensajeborrado;
    }

    public void setMensajeborrado(String mensajeborrado) {
        this.mensajeborrado = mensajeborrado;
    }

    public String getMensajeModificacion() {
        return mensajeModificacion;
    }

    public void setMensajeModificacion(String mensajeModificacion) {
        this.mensajeModificacion = mensajeModificacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String Dias) {
        this.dias = Dias;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

      public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public ArrayList<Uea> getUeasList() {
        return ueasList;
    }

}
