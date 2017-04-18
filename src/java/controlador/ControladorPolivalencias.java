/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.Polivalencias;
import domini.Usuarios;
import dto.PolivalenciasDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import servei.PolivalenciasServei;
import servei.UsuariosServei;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class ControladorPolivalencias implements Serializable{
    @Inject
    private PolivalenciasServei serveiPolivalencias;
    
    @Inject
    private PolivalenciasDTO polivalenciasActual;
    
    @Inject
    private UsuariosServei serveiUsuarios;

    public PolivalenciasServei getServeiPolivalencias() {
        return serveiPolivalencias;
    }

    public void setServeiPolivalencias(PolivalenciasServei serveiPolivalencias) {
        this.serveiPolivalencias = serveiPolivalencias;
    }

    public PolivalenciasDTO getPolivalenciasActual() {
        return polivalenciasActual;
    }

    public void setPolivalenciasActual(PolivalenciasDTO polivalenciasActual) {
        this.polivalenciasActual = polivalenciasActual;
    }
    
    public String prepararInsercio(){
        netejarFormulari();
        return "FormulariInsercio";
    }
    
    private void netejarFormulari(){
        polivalenciasActual.setA2(null);
        polivalenciasActual.setA3(null);
        polivalenciasActual.setA4(null);
        polivalenciasActual.setA5(null);
        polivalenciasActual.setCampoOcteno(null);
        polivalenciasActual.setDowID(null);
        polivalenciasActual.setFecha111(null);
        polivalenciasActual.setFecha2(null);
        polivalenciasActual.setFecha3(null);
        polivalenciasActual.setFecha4510(null);
        polivalenciasActual.setFecha67(null);
        polivalenciasActual.setFecha89(null);
        polivalenciasActual.setFechaCampoOcteno(null);
        polivalenciasActual.setFechaPanelOcteno(null);
        polivalenciasActual.setFechaPanelZC(null);
        polivalenciasActual.setFechaPanelZF(null);
        polivalenciasActual.setPanelOcteno(null);
        polivalenciasActual.setPanelZC(null);
        polivalenciasActual.setPanelZF(null);
        polivalenciasActual.setA(null);
        polivalenciasActual.setA1(null);
    }
    
    public String crearPolivalencias(Boolean panelZC, Date fechaPanelZC, Boolean a, Date fecha111, Boolean a1, Date fecha2, Boolean a2, Date fecha3, Boolean a3, Date fecha4510, Boolean panelZF, Date fechaPanelZF, Boolean a4, Date fecha67, Boolean a5, Date fecha89, Boolean panelOcteno, Date fechaPanelOcteno, Boolean campoOcteno, Date fechaCampoOcteno, String dowID){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowID);
        Polivalencias p = new Polivalencias( panelZC,  fechaPanelZC,  a,  fecha111,  a1,  fecha2,  a2,  fecha3,  a3,  fecha4510,  panelZF,  fechaPanelZF,  a4,  fecha67,  a5,  fecha89,  panelOcteno,  fechaPanelOcteno,  campoOcteno,  fechaCampoOcteno, usuari);
        serveiPolivalencias.inserirPolivalencia(p);
        return "index";
    }
    
    private void passarPolivalenciasPolivalenciasDTO(Polivalencias p){
        polivalenciasActual.setA(p.getA());
        polivalenciasActual.setA1(p.getA1());
        polivalenciasActual.setA2(p.getA2());
        polivalenciasActual.setA3(p.getA3());
        polivalenciasActual.setA4(p.getA4());
        polivalenciasActual.setA5(p.getA5());
        polivalenciasActual.setCampoOcteno(p.getCampoOcteno());
        polivalenciasActual.setDowID(p.getDowID());
        polivalenciasActual.setFecha111(p.getFecha111());
        polivalenciasActual.setFecha2(p.getFecha2());
        polivalenciasActual.setFecha3(p.getFecha3());
        polivalenciasActual.setFecha4510(p.getFecha4510());
        polivalenciasActual.setFecha67(p.getFecha67());
        polivalenciasActual.setFecha89(p.getFecha89());
        polivalenciasActual.setFechaCampoOcteno(p.getFechaCampoOcteno());
        polivalenciasActual.setFechaPanelOcteno(p.getFechaPanelOcteno());
        polivalenciasActual.setFechaPanelZC(p.getFechaPanelZC());
        polivalenciasActual.setFechaPanelZF(p.getFechaPanelZF());
        polivalenciasActual.setPanelOcteno(p.getPanelOcteno());
        polivalenciasActual.setPanelZC(p.getPanelZC());
        polivalenciasActual.setPanelZF(p.getPanelZF());        
    }
    
    public String obtenirPolivalenciasConsulta(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Polivalencias p = serveiPolivalencias.obtenirPolivalencia(usuari);
        passarPolivalenciasPolivalenciasDTO(p);
        return "Consulta";
    }
    
    public String obtenirPolivalenciasModificacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Polivalencias p = serveiPolivalencias.obtenirPolivalencia(usuari);
        passarPolivalenciasPolivalenciasDTO(p);
        return "Modificacio";
    }
    
    public String obtenirPolivalenciasEliminacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Polivalencias p = serveiPolivalencias.obtenirPolivalencia(usuari);
        passarPolivalenciasPolivalenciasDTO(p);
        return "Eliminacio";
    }
    
    private void passarPolivalenciasDTOPolivalencias(Polivalencias p){
        p.setA(polivalenciasActual.getA());
        p.setA1(polivalenciasActual.getA1());
        p.setA2(polivalenciasActual.getA2());
        p.setA3(polivalenciasActual.getA2());
        p.setA4(polivalenciasActual.getA4());
        p.setA5(polivalenciasActual.getA5());
        p.setCampoOcteno(polivalenciasActual.getCampoOcteno());
        p.setDowID(polivalenciasActual.getDowID());
        p.setFecha111(polivalenciasActual.getFecha111());
        p.setFecha2(polivalenciasActual.getFecha2());
        p.setFecha3(polivalenciasActual.getFecha3());
        p.setFecha4510(polivalenciasActual.getFecha4510());
        p.setFecha67(polivalenciasActual.getFecha67());
        p.setFecha89(polivalenciasActual.getFecha89());
        p.setFechaCampoOcteno(polivalenciasActual.getFechaCampoOcteno());
        p.setFechaPanelOcteno(polivalenciasActual.getFechaPanelOcteno());
        p.setFechaPanelZC(polivalenciasActual.getFechaPanelZC());
        p.setFechaPanelZF(polivalenciasActual.getFechaPanelZF());
    }
    
    public String modificarPolivalencias(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Polivalencias p = serveiPolivalencias.obtenirPolivalencia(usuari);
        passarPolivalenciasDTOPolivalencias(p);
        serveiPolivalencias.modificarPolivalencia(p);
        return "index";
    }
    
    public String eliminarPolivalencias(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Polivalencias p = serveiPolivalencias.obtenirPolivalencia(usuari);
        serveiPolivalencias.eliminarPolivalencia(p);
        return "index";
    }
    
    public List<Polivalencias> llistarPolivalencias(){
        return serveiPolivalencias.llistarPolivalencia();
    }
}