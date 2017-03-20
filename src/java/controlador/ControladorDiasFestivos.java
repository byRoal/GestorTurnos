/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import servei.DiasFestivosServei;
import dto.DiasfestivosDTO;
import java.util.Date;
import domini.Diasfestivos;
import java.util.List;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class ControladorDiasFestivos implements Serializable{
    @Inject
    private DiasFestivosServei serveiDiasFestivos;
    
    @Inject
    private DiasfestivosDTO diasFestivosactual;

    public DiasFestivosServei getServeiDiasFestivos() {
        return serveiDiasFestivos;
    }

    public void setServeiDiasFestivos(DiasFestivosServei serveiDiasFestivos) {
        this.serveiDiasFestivos = serveiDiasFestivos;
    }

    public DiasfestivosDTO getDiasFestivosactual() {
        return diasFestivosactual;
    }

    public void setDiasFestivosactual(DiasfestivosDTO diasFestivosactual) {
        this.diasFestivosactual = diasFestivosactual;
    }
    
    public String prepararInsercio(){
        netejarFormulari();
        return "FormulariInsercio";
    }
    
    private void netejarFormulari(){
        diasFestivosactual.setComentario(null);
        diasFestivosactual.setFechaFestivo(null);
    }
    
    public String crearDiaFestivo(Date fechaFestivo, String comentario){
        Diasfestivos d = new Diasfestivos(fechaFestivo,comentario);
        serveiDiasFestivos.inserirDiaFestivo(d);
        return "index";
    }
    
    private void passarDiasFestivosDiasFestivosDTO(Diasfestivos d){
        diasFestivosactual.setComentario(d.getComentario());
        diasFestivosactual.setFechaFestivo(d.getFechaFestivo());
    }
    
    public String obtenirDiasFestivosConsulta(Date data){
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDiasFestivosDTO(d);
        return "Consulta";
    }
    
    public String obtenirDiasFestivosModificacio(Date data){
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDiasFestivosDTO(d);
        return "Modificacio";
    }
    
    public String obtenirDiasFestivosEliminacio(Date data){
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDiasFestivosDTO(d);
        return "Eliminacio";
    }
    
    private void passarDiasFestivosDTODiasFestivos(Diasfestivos d){
        d.setComentario(diasFestivosactual.getComentario());
        d.setFechaFestivo(diasFestivosactual.getFechaFestivo());
    }
    
    public String modificarDiaFestivo(Date data){
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDTODiasFestivos(d);
        serveiDiasFestivos.modificarDiaFestivo(d);
        return "index";
    }
    
    public String eliminarDiaFestivo(Date data){
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);        
        serveiDiasFestivos.eliminarDiaFestivo(d);
        return "index";
    }
    
    public List<Diasfestivos> llistarDiasFestivos(){
        return serveiDiasFestivos.llistarDiasFestivos();
    }
    
}
