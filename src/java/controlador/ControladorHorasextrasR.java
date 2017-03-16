/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.HorasextrasR;
import domini.Usuarios;
import dto.HorasextrasRDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import servei.HorasextrasRServei;
import servei.UsuariosServei;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class ControladorHorasextrasR implements Serializable{
    @Inject
    private HorasextrasRServei serveiHorasextrasR;
    
    @Inject
    private HorasextrasRDTO horasextrasRActual;
    
    @Inject
    private UsuariosServei serveiUsuarios;

    public HorasextrasRServei getServeiHorasextrasR() {
        return serveiHorasextrasR;
    }

    public void setServeiHorasextrasR(HorasextrasRServei serveiHorasextrasR) {
        this.serveiHorasextrasR = serveiHorasextrasR;
    }

    public HorasextrasRDTO getHorasextrasRActual() {
        return horasextrasRActual;
    }

    public void setHorasextrasRActual(HorasextrasRDTO horasextrasRActual) {
        this.horasextrasRActual = horasextrasRActual;
    }
    
    public String prepararInsercio(){
        netejarFormulari();
        return "FormulariInsercio";
    }
    
    private void netejarFormulari(){
        horasextrasRActual.setComentario(null);
        horasextrasRActual.setDia(null);
        horasextrasRActual.setDowID(null);
        horasextrasRActual.setHorasExtras(0);
    }
    
    public String crearHorasextrasR(Date dia, int horasExtras, String comentario, String dowID){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowID);
        HorasextrasR h = new HorasextrasR(dia, horasExtras,comentario,usuari);
        serveiHorasextrasR.inserirHorasextrasR(h);
        return "index";
    }
    
    private void passarHorasextrasRHorasextrasRDTO(HorasextrasR h){
        horasextrasRActual.setComentario(h.getComentario());
        horasextrasRActual.setDia(h.getDia());
        horasextrasRActual.setDowID(h.getDowID());
        horasextrasRActual.setHorasExtras(h.getHorasExtras());
    }
    
    public String obtenirHorasextrasRConsulta(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        HorasextrasR h = serveiHorasextrasR.obtenirHorasextrasR(usuari);
        passarHorasextrasRHorasextrasRDTO(h);
        return "Consulta";
    }
    
    public String obtenirHorasextrasRModificacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        HorasextrasR h = serveiHorasextrasR.obtenirHorasextrasR(usuari);
        passarHorasextrasRHorasextrasRDTO(h);
        return "Modificacio";
    }
    
    public String obtenirHorasextrasREliminacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        HorasextrasR h = serveiHorasextrasR.obtenirHorasextrasR(usuari);
        passarHorasextrasRHorasextrasRDTO(h);
        return "Eliminacio";
    }
    
    private void passarHorasextrasRDTOHorasextrasR(HorasextrasR h){
        h.setComentario(horasextrasRActual.getComentario());
        h.setDia(horasextrasRActual.getDia());
        h.setDowID(horasextrasRActual.getDowID());
        h.setHorasExtras(horasextrasRActual.getHorasExtras());
    }
    
    public String modificarHorasextrasR(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        HorasextrasR h = serveiHorasextrasR.obtenirHorasextrasR(dowId);
        passarHorasextrasRDTOHorasextrasR(h);
        serveiHorasextrasR.modificarHorasextrasR(h);
        return "index";
    }
    
    public String eliminarHorasextrasR(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        HorasextrasR h = serveiHorasextrasR.obtenirHorasextrasR(dowId);
        serveiHorasextrasR.eliminarHorasextrasR(h);
        return "index";
    }
    
    public List<HorasextrasR> llistarHorasextrasR(){
        return serveiHorasextrasR.llistarHorasextrasR();
    }
    
}
