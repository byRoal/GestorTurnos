/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domini.BajasPermisos;
import domini.Contabilidadhoras;
import domini.HorasextrasR;
import domini.Polivalencias;
import domini.Vacaciones;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ND17613
 */
@SessionScoped
public class UsuariosDTO implements Serializable{
    private Integer iDusuarios;
    private String dowID;
    private String nombre;
    private String sexo;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String movil;
    private String email;
    private StreamedContent foto;
    private UploadedFile arxiuFoto;
    private String planta;
    private String departamento;
    private Character turno;
    private String supervisor;
    private Date fechaIncorporacion;
    private BigDecimal vacacionesHechas;
    private BigDecimal vacacionesPendientes;
    private BigDecimal vacacionesArrastradas;
    private List<HorasextrasR> horasextrasRList;
    private List<Contabilidadhoras> contabilidadhorasList;
    private List<BajasPermisos> bajasPermisosList;
    private List<Vacaciones> vacacionesList;
    private List<Polivalencias> polivalenciasList;

    public UsuariosDTO() {
    }

    public Integer getiDusuarios() {
        return iDusuarios;
    }

    public void setiDusuarios(Integer iDusuarios) {
        this.iDusuarios = iDusuarios;
    }

    public String getDowID() {
        return dowID;
    }

    public void setDowID(String dowID) {
        this.dowID = dowID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StreamedContent getFoto() {
        return foto;
    }

    public void setFoto(StreamedContent foto) {
        this.foto = foto;
    }

    public UploadedFile getArxiuFoto() {
        return arxiuFoto;
    }

    public void setArxiuFoto(UploadedFile arxiuFoto) {
        this.arxiuFoto = arxiuFoto;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Character getTurno() {
        return turno;
    }

    public void setTurno(Character turno) {
        this.turno = turno;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public BigDecimal getVacacionesHechas() {
        return vacacionesHechas;
    }

    public void setVacacionesHechas(BigDecimal vacacionesHechas) {
        this.vacacionesHechas = vacacionesHechas;
    }

    public BigDecimal getVacacionesPendientes() {
        return vacacionesPendientes;
    }

    public void setVacacionesPendientes(BigDecimal vacacionesPendientes) {
        this.vacacionesPendientes = vacacionesPendientes;
    }

    public BigDecimal getVacacionesArrastradas() {
        return vacacionesArrastradas;
    }

    public void setVacacionesArrastradas(BigDecimal vacacionesArrastradas) {
        this.vacacionesArrastradas = vacacionesArrastradas;
    }

    public List<HorasextrasR> getHorasextrasRList() {
        return horasextrasRList;
    }

    public void setHorasextrasRList(List<HorasextrasR> horasextrasRList) {
        this.horasextrasRList = horasextrasRList;
    }

    public List<Contabilidadhoras> getContabilidadhorasList() {
        return contabilidadhorasList;
    }

    public void setContabilidadhorasList(List<Contabilidadhoras> contabilidadhorasList) {
        this.contabilidadhorasList = contabilidadhorasList;
    }

    public List<BajasPermisos> getBajasPermisosList() {
        return bajasPermisosList;
    }

    public void setBajasPermisosList(List<BajasPermisos> bajasPermisosList) {
        this.bajasPermisosList = bajasPermisosList;
    }

    public List<Vacaciones> getVacacionesList() {
        return vacacionesList;
    }

    public void setVacacionesList(List<Vacaciones> vacacionesList) {
        this.vacacionesList = vacacionesList;
    }

    public List<Polivalencias> getPolivalenciasList() {
        return polivalenciasList;
    }

    public void setPolivalenciasList(List<Polivalencias> polivalenciasList) {
        this.polivalenciasList = polivalenciasList;
    }
    
}
