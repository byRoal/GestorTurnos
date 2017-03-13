/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.Admin;
import dto.AdminDTO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import servei.AdminServei;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class ControladorAdmin implements Serializable {

    @Inject
    private AdminServei serveiAdmin;

    @Inject
    private AdminDTO adminActual;

    public AdminServei getServeiAdmin() {
        return serveiAdmin;
    }

    public void setServeiAdmin(AdminServei serveiAdmin) {
        this.serveiAdmin = serveiAdmin;
    }

    public AdminDTO getAdminActual() {
        return adminActual;
    }

    public void setAdminActual(AdminDTO adminActual) {
        this.adminActual = adminActual;
    }

    public String prepararInsercio() {
        netejarFormulari();
        return "FormulariInsercio";
    }

    private void netejarFormulari() {
        adminActual.setDowID(null);
        adminActual.setNombre(null);
        adminActual.setApellidos(null);
        adminActual.setNivelAdmin(null);
    }

    private String crearAdmin(String dowId, String nom, String cognom, char nivellAdmin) {
        Admin a = new Admin(dowId, nom, cognom, nivellAdmin);
        serveiAdmin.inserirAdmin(a);
        return "index";
    }

    private void passarAdminAdminDTO(Admin a) {
        adminActual.setDowID(a.getDowID());
        adminActual.setNombre(a.getNombre());
        adminActual.setApellidos(a.getApellidos());
        adminActual.setNivelAdmin(a.getNivelAdmin());
    }

    public String obtenirAdminConsulta(String dowId) {
        Admin a = serveiAdmin.obtenirAdmin(dowId);
        passarAdminAdminDTO(a);
        return "Consulta";
    }

    public String obtenirAdminModificacio(String dowId) {
        Admin a = serveiAdmin.obtenirAdmin(dowId);
        passarAdminAdminDTO(a);
        return "Modificacio";
    }

    public String obtenirAdminEliminacio(String dowId) {
        Admin a = serveiAdmin.obtenirAdmin(dowId);
        passarAdminAdminDTO(a);
        return "Eliminacio";
    }

    public void passarAdminDTOAdmin(Admin a) {
        a.setDowID(adminActual.getDowID());
        a.setNombre(adminActual.getNombre());
        a.setApellidos(adminActual.getApellidos());
        a.setNivelAdmin(adminActual.getNivelAdmin());
    }

    public String modificarAdmin(String dowId) {
        Admin a = serveiAdmin.obtenirAdmin(dowId);
        passarAdminDTOAdmin(a);
        serveiAdmin.modificarAdmin(a);
        return "index";
    }

    public String eliminarAdmin(String dowId) {
        serveiAdmin.eliminarAdmin(dowId);
        return "index";
    }

}
