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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author ND17613
 */
//@Named
//@SessionScoped
@ManagedBean
@ViewScoped
public class ControladorDiasFestivos2 implements Serializable {

    @Inject
    private DiasFestivosServei serveiDiasFestivos;

    @Inject
    private DiasfestivosDTO diasFestivosactual;

    private boolean cursillo;

    public boolean isCursillo() {
        return cursillo;
    }

    public void setCursillo(boolean cursillo) {
        this.cursillo = cursillo;
    }
    
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

    public String prepararInsercio() {
        netejarFormulari();
        return "FormulariInsercio";
    }

    private void netejarFormulari() {
        diasFestivosactual.setComentario(null);
        diasFestivosactual.setFechaFestivo(null);
        diasFestivosactual.setTitulo(null);
    }

    public String crearDiaFestivo(String titulo, Date fechaFestivo, String comentario, Boolean cursillo) {
        Diasfestivos d = new Diasfestivos(titulo, fechaFestivo, comentario,cursillo);
        serveiDiasFestivos.inserirDiaFestivo(d);

        return "/index?faces-redirect=true";
    }

    public void cargarDiasFestivos() {

        ScheduleModel eventModel;
        eventModel = new DefaultScheduleModel();

        List<Diasfestivos> diasfestivos = serveiDiasFestivos.llistarDiasFestivos();
        for (int i = 0; i < diasfestivos.size(); i++) {
            eventModel.addEvent(new DefaultScheduleEvent(diasfestivos.get(i).getTitulo(), diasfestivos.get(i).getFechaFestivo(), diasfestivos.get(i).getFechaFestivo()));
        }
    }

    private void passarDiasFestivosDiasFestivosDTO(Diasfestivos d) {
        diasFestivosactual.setComentario(d.getComentario());
        diasFestivosactual.setFechaFestivo(d.getFechaFestivo());
        diasFestivosactual.setTitulo(d.getTitulo());
    }

    public String obtenirDiasFestivosConsulta(Date data) {
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDiasFestivosDTO(d);
        return "Consulta";
    }

    public String obtenirDiasFestivosModificacio(Date data) {
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDiasFestivosDTO(d);
        return "Modificacio";
    }

    public String obtenirDiasFestivosEliminacio(String titulo) {
        Diasfestivos d = serveiDiasFestivos.eliminarFiesta(titulo);
        passarDiasFestivosDiasFestivosDTO(d);
        return "EliminarDiaFestivo?faces-redirect=true";
    }

    private void passarDiasFestivosDTODiasFestivos(Diasfestivos d) {
        d.setComentario(diasFestivosactual.getComentario());
        d.setFechaFestivo(diasFestivosactual.getFechaFestivo());
        d.setTitulo(diasFestivosactual.getTitulo());
    }

    public String modificarDiaFestivo(Date data) {
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDTODiasFestivos(d);
        serveiDiasFestivos.modificarDiaFestivo(d);
        return "index";
    }

    public String eliminarDiaFestivo(String titulo) {
        Diasfestivos d = serveiDiasFestivos.eliminarFiesta(titulo);
        serveiDiasFestivos.eliminarDiaFestivo(d.getIDDiasFestivos());
        return "/index?faces-redirect=true";
    }

    public List<Diasfestivos> llistarDiasFestivos() {
        return serveiDiasFestivos.llistarDiasFestivos();
    }
     private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     
     

   public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    public String formataData(){
        return "c-50:c+50";
    }
    
    
    
    

}
