/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.Contabilidadhoras;
import domini.Usuarios;
import dto.ContabilidadhorasDTO;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import servei.ContabilidadhorasServei;
import servei.UsuariosServei;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class ControladorContabilidadhoras implements Serializable{
    @Inject
    private ContabilidadhorasServei serveiContabilidadhoras;
    
    @Inject
    private ContabilidadhorasDTO contabilidadhorasActual;
    
    @Inject
    private UsuariosServei serveiUsuarios;

    public ContabilidadhorasServei getServeiContabilidadhoras() {
        return serveiContabilidadhoras;
    }

    public void setServeiContabilidadhoras(ContabilidadhorasServei serveiContabilidadhoras) {
        this.serveiContabilidadhoras = serveiContabilidadhoras;
    }

    public ContabilidadhorasDTO getContabilidadhorasActual() {
        return contabilidadhorasActual;
    }

    public void setContabilidadhorasActual(ContabilidadhorasDTO contabilidadhorasActual) {
        this.contabilidadhorasActual = contabilidadhorasActual;
    }
    
    public String prepararInsercio() {
        netejarFormulari();
        return "FormulariInsercio";
    }
    
    private void netejarFormulari(){
        contabilidadhorasActual.setDowID(null);
        contabilidadhorasActual.setHorasAnuales(null);
        contabilidadhorasActual.setHorasHechas(null);
        contabilidadhorasActual.setHorasRestantes(null);
        contabilidadhorasActual.setHorasTurno(null);
    }
    
    public String crearContabilidadhoras(Integer horasAnuales, Integer horasTurno, Integer horasRestantes, Integer horasHechas, String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Contabilidadhoras c = new Contabilidadhoras(horasAnuales,horasTurno,horasRestantes, horasHechas,usuari);
        serveiContabilidadhoras.inserirContabilidadhoras(c);
        return "index";
    }
    
    private void passarContabilidadhorasContabilidadhorasDTO(Contabilidadhoras c){
        contabilidadhorasActual.setDowID(c.getDowID());
        contabilidadhorasActual.setHorasAnuales(c.getHorasAnuales());
        contabilidadhorasActual.setHorasHechas(c.getHorasHechas());
        contabilidadhorasActual.setHorasRestantes(c.getHorasRestantes());
        contabilidadhorasActual.setHorasTurno(c.getHorasTurno());
    }
    
    public String obtenirContabilidadhorasConsulta(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Contabilidadhoras c = serveiContabilidadhoras.obtenirContabilidadhoras(usuari);
        passarContabilidadhorasContabilidadhorasDTO(c);
        return "Consulta";
    }
    
    public String obtenirContabilidadhorasModificacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Contabilidadhoras c = serveiContabilidadhoras.obtenirContabilidadhoras(usuari);
        passarContabilidadhorasContabilidadhorasDTO(c);
        return "Modificacio";
    }
    
    public String obtenirContabilidadhorasEliminacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Contabilidadhoras c = serveiContabilidadhoras.obtenirContabilidadhoras(usuari);
        passarContabilidadhorasContabilidadhorasDTO(c);
        return "Eliminacio";
    }
    
    private void passarContabilidadhorasDTOContabilidadhoras(Contabilidadhoras c){
        c.setDowID(contabilidadhorasActual.getDowID());
        c.setHorasAnuales(contabilidadhorasActual.getHorasAnuales());
        c.setHorasHechas(contabilidadhorasActual.getHorasHechas());
        c.setHorasRestantes(contabilidadhorasActual.getHorasRestantes());
        c.setHorasTurno(contabilidadhorasActual.getHorasTurno());
    }
    
    public String modificarContabilidadhoras(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Contabilidadhoras c = serveiContabilidadhoras.obtenirContabilidadhoras(usuari);
        passarContabilidadhorasDTOContabilidadhoras(c);
        serveiContabilidadhoras.modificarContabilidadhoras(c);
        return "index";
    }
    
    public String eliminarContabilidadhoras(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        Contabilidadhoras c = serveiContabilidadhoras.obtenirContabilidadhoras(usuari);
        serveiContabilidadhoras.eliminarContabilidadhoras(c);
        return "index";
    }
    
    public List<Contabilidadhoras> llistarContabilidadhoras(){
        return serveiContabilidadhoras.llistarContabilidadhoras();
    }
}
