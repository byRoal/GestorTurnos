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
public class ControladorDiasFestivos implements Serializable {

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

    public String prepararInsercio() {
        netejarFormulari();
        return "FormulariInsercio";
    }

    private void netejarFormulari() {
        diasFestivosactual.setComentario(null);
        diasFestivosactual.setFechaFestivo(null);
        diasFestivosactual.setTitulo(null);
    }

    public String crearDiaFestivo(String titulo, Date fechaFestivo, String comentario) {
        Diasfestivos d = new Diasfestivos(titulo, fechaFestivo, comentario);
        serveiDiasFestivos.inserirDiaFestivo(d);
        System.out.println(d.getComentario());

        init();

        return "index";
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

    public String obtenirDiasFestivosEliminacio(Date data) {
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDiasFestivosDTO(d);
        return "Eliminacio";
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

    public String eliminarDiaFestivo(Date data) {
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        serveiDiasFestivos.eliminarDiaFestivo(d);
        return "index";
    }

    public List<Diasfestivos> llistarDiasFestivos() {
        return serveiDiasFestivos.llistarDiasFestivos();
    }

    private ScheduleModel eventModel;

    private ScheduleModel lazyEventModel;

    private ScheduleEvent event=new DefaultScheduleEvent();

    private Diasfestivos fiesta;

    Date hoy = new Date();

    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        List<Diasfestivos> diasfestivos = serveiDiasFestivos.llistarDiasFestivos();
        ControladorDiasFestivos obj1= new ControladorDiasFestivos();

        
        for (int i = 0; i < diasfestivos.size(); i++) {
                eventModel.addEvent(new DefaultScheduleEvent(diasfestivos.get(i).getTitulo(), diasfestivos.get(i).getFechaFestivo(),diasfestivos.get(i).getFechaFestivo(), diasfestivos.get(i).getComentario()));

            }
        

        lazyEventModel = new LazyScheduleModel() {
            @Override
            public void loadEvents(Date start, Date end) {
                Date random = getRandomDate(start);
                Date avui = Calendar.getInstance().getTime();
                addEvent(new DefaultScheduleEvent("Lazy Event 1", avui, avui));

                random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Festa", random, random));
            }
        };
    }

    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1);    //set random day of month

        return date.getTime();
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent(String titulo,Date fecha,String comentario) {
        if (event.getId() == null) {
            crearDiaFestivo(titulo, fecha, comentario);
            eventModel.addEvent(event);
            
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        String ob1= event.getDescription();

    }

    private void sacarDescripcion(ScheduleEvent event) {
        event.getDescription();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
