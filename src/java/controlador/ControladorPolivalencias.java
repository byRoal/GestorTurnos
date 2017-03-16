/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.PolivalenciasDTO;
import java.io.Serializable;
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
}
