/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domini.Usuarios;
import java.util.Date;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ND17613
 */
@RequestScoped
public class BajasPermisosDTO {
    private Integer iDbajaspermisos;
    private Boolean baja;
    private Boolean permisos;
    private Date dataInicio;
    private Date dataFin;
    private int diasTotales;
    private String comentario;
    private Usuarios dowID;

    public BajasPermisosDTO() {
    }

    public Integer getiDbajaspermisos() {
        return iDbajaspermisos;
    }

    public void setiDbajaspermisos(Integer iDbajaspermisos) {
        this.iDbajaspermisos = iDbajaspermisos;
    }

    public Boolean getBaja() {
        return baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    public Boolean getPermisos() {
        return permisos;
    }

    public void setPermisos(Boolean permisos) {
        this.permisos = permisos;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFin() {
        return dataFin;
    }

    public void setDataFin(Date dataFin) {
        this.dataFin = dataFin;
    }

    public int getDiasTotales() {
        return diasTotales;
    }

    public void setDiasTotales(int diasTotales) {
        this.diasTotales = diasTotales;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuarios getDowID() {
        return dowID;
    }

    public void setDowID(Usuarios dowID) {
        this.dowID = dowID;
    }
    
}
