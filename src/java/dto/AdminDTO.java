/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ND17613
 */
@RequestScoped
public class AdminDTO {
    private Integer iDadmin;    
    private String dowID;    
    private String nombre;
    private String apellidos;
    private Character nivelAdmin;

    public AdminDTO() {
    }

    public Integer getiDadmin() {
        return iDadmin;
    }

    public void setiDadmin(Integer iDadmin) {
        this.iDadmin = iDadmin;
    }

    public String getDowID() {
        return dowID;
    }

    public void setDowID(String dowID) {
        this.dowID = dowID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Character getNivelAdmin() {
        return nivelAdmin;
    }

    public void setNivelAdmin(Character nivelAdmin) {
        this.nivelAdmin = nivelAdmin;
    }
    
}
