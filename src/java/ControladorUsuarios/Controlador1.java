/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorUsuarios;

import ControllerMaterias.*;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class Controlador1 implements Serializable {

    public String irANuevaPagina() {
        // Realizar acciones necesarias antes de cambiar de página, si las hay
        return "Registro.xhtml?faces-redirect=true";
    }
}
