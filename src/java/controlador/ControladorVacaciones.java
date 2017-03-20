/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.Usuarios;
import domini.Vacaciones;
import dto.VacacionesDTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import servei.UsuariosServei;
import servei.VacacionesServei;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class ControladorVacaciones implements Serializable{
    @Inject
    private VacacionesServei serveiVacaciones;
    
    @Inject
    private VacacionesDTO vacacionesActual;
    
    @Inject
    private UsuariosServei serveiUsuarios;

    public VacacionesServei getServeiVacaciones() {
        return serveiVacaciones;
    }

    public void setServeiVacaciones(VacacionesServei serveiVacaciones) {
        this.serveiVacaciones = serveiVacaciones;
    }

    public VacacionesDTO getVacacionesActual() {
        return vacacionesActual;
    }

    public void setVacacionesActual(VacacionesDTO vacacionesActual) {
        this.vacacionesActual = vacacionesActual;
    }
    
    public String prepararInsercio(){
        netejarFormulari();
        return "FormulariInsercio";
    }
    
    private void netejarFormulari(){
        vacacionesActual.setDiasTotales(null);
        vacacionesActual.setDowID(null);
        vacacionesActual.setFechaFinal(null);
        vacacionesActual.setFechaInicio(null);
        vacacionesActual.setMedioDia(null);
    }
    
    public String crearVacaciones(Date fechaInicio, Date fechaFinal, BigDecimal diasTotales, Boolean medioDia, String dowID){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowID);
        Vacaciones v = new Vacaciones( fechaInicio,  fechaFinal,  diasTotales,  medioDia,  usuari);
        serveiVacaciones.inserirVacaciones(v);
        return "index";
    }
    
    private void passarVacacionesVacacionesDTO(Vacaciones v){
        vacacionesActual.setDiasTotales(v.getDiasTotales());
        vacacionesActual.setDowID(v.getDowID());
        vacacionesActual.setFechaFinal(v.getFechaFinal());
        vacacionesActual.setFechaInicio(v.getFechaInicio());
        vacacionesActual.setMedioDia(v.getMedioDia());
    }
    
    public String obtenirVacacionesConsulta(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Vacaciones v= serveiVacaciones.obtenirVacaciones(usuari);
        passarVacacionesVacacionesDTO(v);
        return "Consulta";
    }
    
    public String obtenirVacacionesModificacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Vacaciones v= serveiVacaciones.obtenirVacaciones(usuari);
        passarVacacionesVacacionesDTO(v);
        return "Modificacio";
    }
    
    public String obtenirVacacionesEliminacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Vacaciones v= serveiVacaciones.obtenirVacaciones(usuari);
        passarVacacionesVacacionesDTO(v);
        return "Eliminacio";
    }
    
    public void passarVacacionesDTOVacaciones(Vacaciones v){
        v.setDiasTotales(vacacionesActual.getDiasTotales());
        v.setDowID(vacacionesActual.getDowID());
        v.setFechaFinal(vacacionesActual.getFechaFinal());
        v.setFechaInicio(vacacionesActual.getFechaInicio());
        v.setMedioDia(vacacionesActual.getMedioDia());
    }
    
    public String modificarVacaciones(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Vacaciones v= serveiVacaciones.obtenirVacaciones(usuari);
        passarVacacionesDTOVacaciones(v);
        serveiVacaciones.modificarVacaciones(v);
        return "index";        
    }
    
    public String eliminarVacaciones(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Vacaciones v= serveiVacaciones.obtenirVacaciones(usuari);        
        serveiVacaciones.eliminarVacaciones(v);
        return "index";        
    }
    
    public List<Vacaciones> llistarVacaciones(){
        return serveiVacaciones.llistarVacaciones();
    }        
    
}
