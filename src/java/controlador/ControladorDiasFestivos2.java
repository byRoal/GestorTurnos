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

    /**
     * función que permite inserir un nuevo día festivo a la BD.
     *
     * @param titulo titulo del día fesivo
     * @param fechaFestivo fecha del día festivo
     * @param comentario breve descripción del porque del día festivo
     * @param cursillo booleano que determina si el día festivo es debido a un
     * cursillo o no
     * @return String correspondente a la página dónde se redireccionará al
     * finalizar
     */
    public String crearDiaFestivo(String titulo, Date fechaFestivo, String comentario, Boolean cursillo) {
        Diasfestivos d = new Diasfestivos(titulo, fechaFestivo, comentario, cursillo);
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

    /**
     * función para pasar información de un día festivo de la BD a la web y así
     * poder tratarlo.
     *
     * @param d Objeto de la clase Diasfestivos de dónde será extraída la
     * información, que previamente ha sido obtenido de la BD
     */
    private void passarDiasFestivosDiasFestivosDTO(Diasfestivos d) {
        diasFestivosactual.setComentario(d.getComentario());
        diasFestivosactual.setFechaFestivo(d.getFechaFestivo());
        diasFestivosactual.setTitulo(d.getTitulo());
    }

    /**
     * Busca el el día festivo correspondiente a la fecha que se le haya enviado
     * y, después de transformar los datos para poderlos tratar, te redirecciona
     * a una página web
     *
     * @param data fecha del día que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirDiasFestivosConsulta(Date data) {
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDiasFestivosDTO(d);
        return "Consulta";
    }

    /**
     * Busca el el día festivo correspondiente a la fecha que se le haya enviado
     * y, después de transformar los datos para poderlos tratar, te redirecciona
     * a una página web
     *
     * @param data fecha del día que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirDiasFestivosModificacio(Date data) {
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDiasFestivosDTO(d);
        return "Modificacio";
    }

    /**
     * Busca el el día festivo correspondiente al titulo que se le haya enviado
     * y, después de transformar los datos para poderlos tratar, te redirecciona
     * a una página web
     *
     * @param titulo titulo del día que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirDiasFestivosEliminacioAdmin(String titulo) {
        Diasfestivos d = serveiDiasFestivos.eliminarFiesta(titulo);
        passarDiasFestivosDiasFestivosDTO(d);
        return "EliminarDiaFestivoAdmin";
    }

    /**
     * Busca el el día festivo correspondiente al titulo que se le haya enviado
     * y, después de transformar los datos para poderlos tratar, te redirecciona
     * a una página web
     *
     * @param titulo titulo del día que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirDiasFestivosEliminacioSu(String titulo) {
        Diasfestivos d = serveiDiasFestivos.eliminarFiesta(titulo);
        passarDiasFestivosDiasFestivosDTO(d);
        return "EliminarDiaFestivoSu";
    }

    /**
     * función para pasar información de un día festivo de la web a información
     * para ser introducida en la BD
     *
     * @param d Objeto de la clase Diasfestivos dónde se almacenará toda la
     * informacón
     */
    private void passarDiasFestivosDTODiasFestivos(Diasfestivos d) {
        d.setComentario(diasFestivosactual.getComentario());
        d.setFechaFestivo(diasFestivosactual.getFechaFestivo());
        d.setTitulo(diasFestivosactual.getTitulo());
    }

    /**
     * Busca el día festivo por la fcha y modifica sus datos por los nuevos
     * introducidos en la web. Al finalizar te redirecciona a otra página.
     *
     * @param data fecha del día que se quiere modificar.
     * @return String que identifica la dirección a la página dónde serás
     * redirigido.
     */
    public String modificarDiaFestivo(Date data) {
        Diasfestivos d = serveiDiasFestivos.obtenirDiaFestivo(data);
        passarDiasFestivosDTODiasFestivos(d);
        serveiDiasFestivos.modificarDiaFestivo(d);
        return "index";
    }

    /**
     * Busca el día festivo por el título y borra las tablas de la BD dónde
     * aparece. Al finalizar te redirecciona a otra página.
     *
     * @param titulo título del día que se quiere borrar.
     * @return String que identifica la dirección a la página dónde serás
     * redirigido.
     */
    public String eliminarDiaFestivo(String titulo) {
        Diasfestivos d = serveiDiasFestivos.eliminarFiesta(titulo);
        serveiDiasFestivos.eliminarDiaFestivo(d.getIDDiasFestivos());
        return "/index?faces-redirect=true";
    }

    /**
     * función que devuelve una lista de todos los días festivos de la BD
     *
     * @return lista de días festivos
     */
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

    public String formataData() {
        return "c-50:c+50";
    }

}
