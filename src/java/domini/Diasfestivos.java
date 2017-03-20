/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domini;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ND17613
 */
@Entity
@Table(name = "diasfestivos")
@NamedQueries({
    @NamedQuery(name = "Diasfestivos.findAll", query = "SELECT d FROM Diasfestivos d")
    , @NamedQuery(name = "Diasfestivos.findByIDDiasFestivos", query = "SELECT d FROM Diasfestivos d WHERE d.iDDiasFestivos = :iDDiasFestivos")
    , @NamedQuery(name = "Diasfestivos.findByFechaFestivo", query = "SELECT d FROM Diasfestivos d WHERE d.fechaFestivo = :fechaFestivo")
    , @NamedQuery(name = "Diasfestivos.findByComentario", query = "SELECT d FROM Diasfestivos d WHERE d.comentario = :comentario")})
public class Diasfestivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDiasFestivos")
    private Integer iDDiasFestivos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFestivo")
    @Temporal(TemporalType.DATE)
    private Date fechaFestivo;
    @Size(max = 250)
    @Column(name = "comentario")
    private String comentario;

    public Diasfestivos() {
    }

    public Diasfestivos(Integer iDDiasFestivos) {
        this.iDDiasFestivos = iDDiasFestivos;
    }

    public Diasfestivos(Integer iDDiasFestivos, Date fechaFestivo) {
        this.iDDiasFestivos = iDDiasFestivos;
        this.fechaFestivo = fechaFestivo;
    }

    public Diasfestivos(Date fechaFestivo, String comentario) {
        this.fechaFestivo = fechaFestivo;
        this.comentario = comentario;
    }

    public Integer getIDDiasFestivos() {
        return iDDiasFestivos;
    }

    public void setIDDiasFestivos(Integer iDDiasFestivos) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDiasFestivos != null ? iDDiasFestivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diasfestivos)) {
            return false;
        }
        Diasfestivos other = (Diasfestivos) object;
        if ((this.iDDiasFestivos == null && other.iDDiasFestivos != null) || (this.iDDiasFestivos != null && !this.iDDiasFestivos.equals(other.iDDiasFestivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domini.Diasfestivos[ iDDiasFestivos=" + iDDiasFestivos + " ]";
    }
    
}
