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
public class HorasextrasRDTO {
    private Integer iDHorasExtras;
    private Date dia;
    private int horasExtras;
    private String comentario;
    private Usuarios dowID;

    public HorasextrasRDTO() {
    }

    public Integer getiDHorasExtras() {
        return iDHorasExtras;
    }

    public void setiDHorasExtras(Integer iDHorasExtras) {
        this.iDHorasExtras = iDHorasExtras;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
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
