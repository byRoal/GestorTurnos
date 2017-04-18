/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ND17613
 */
@RequestScoped
public class DiasfestivosDTO {
    private Integer iDDiasFestivos;
    private Date fechaFestivo;
    private String comentario;
    private String titulo;
    private boolean esCursillo;
    
    
    public DiasfestivosDTO() {
    }

    public Integer getiDDiasFestivos() {
        return iDDiasFestivos;
    }

    public void setiDDiasFestivos(Integer iDDiasFestivos) {
        this.iDDiasFestivos = iDDiasFestivos;
    }

    public Date getFechaFestivo() {
        return fechaFestivo;
    }

    public void setFechaFestivo(Date fechaFestivo) {
        this.fechaFestivo = fechaFestivo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEsCursillo() {
        return esCursillo;
    }

    public void setEsCursillo(boolean esCursillo) {
        this.esCursillo = esCursillo;
    }
    
    
    
}
