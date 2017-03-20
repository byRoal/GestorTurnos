/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domini.Usuarios;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ND17613
 */
@RequestScoped
public class ContabilidadhorasDTO {
    private Integer iDContabilidad;
    private Integer horasAnuales;
    private Integer horasTurno;
    private Integer horasRestantes;
    private Integer horasHechas;
    private Usuarios dowID;

    public ContabilidadhorasDTO() {
    }

    public Integer getiDContabilidad() {
        return iDContabilidad;
    }

    public void setiDContabilidad(Integer iDContabilidad) {
        this.iDContabilidad = iDContabilidad;
    }

    public Integer getHorasAnuales() {
        return horasAnuales;
    }

    public void setHorasAnuales(Integer horasAnuales) {
        this.horasAnuales = horasAnuales;
    }

    public Integer getHorasTurno() {
        return horasTurno;
    }

    public void setHorasTurno(Integer horasTurno) {
        this.horasTurno = horasTurno;
    }

    public Integer getHorasRestantes() {
        return horasRestantes;
    }

    public void setHorasRestantes(Integer horasRestantes) {
        this.horasRestantes = horasRestantes;
    }

    public Integer getHorasHechas() {
        return horasHechas;
    }

    public void setHorasHechas(Integer horasHechas) {
        this.horasHechas = horasHechas;
    }

    public Usuarios getDowID() {
        return dowID;
    }

    public void setDowID(Usuarios dowID) {
        this.dowID = dowID;
    }
    
}
