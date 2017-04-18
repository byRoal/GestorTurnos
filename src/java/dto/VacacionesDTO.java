/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domini.Usuarios;
import java.math.BigDecimal;
import java.util.Date;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ND17613
 */
@RequestScoped
public class VacacionesDTO {
    private Integer iDVacaciones;
    private Date fechaInicio;
    private Date fechaFinal;
    private BigDecimal diasTotales;
    private Boolean medioDia;
    private Usuarios dowID;

    public VacacionesDTO() {
    }

    public Integer getiDVacaciones() {
        return iDVacaciones;
    }

    public void setiDVacaciones(Integer iDVacaciones) {
        this.iDVacaciones = iDVacaciones;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public BigDecimal getDiasTotales() {
        return diasTotales;
    }

    public void setDiasTotales(BigDecimal diasTotales) {
        this.diasTotales = diasTotales;
    }

    public Boolean getMedioDia() {
        return medioDia;
    }

    public void setMedioDia(Boolean medioDia) {
        this.medioDia = medioDia;
    }

    public Usuarios getDowID() {
        return dowID;
    }

    public void setDowID(Usuarios dowID) {
        this.dowID = dowID;
    }
    
}
