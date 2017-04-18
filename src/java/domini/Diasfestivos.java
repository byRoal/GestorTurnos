/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domini;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
    , @NamedQuery(name = "Diasfestivos.findByComentario", query = "SELECT d FROM Diasfestivos d WHERE d.comentario = :comentario")
    ,@NamedQuery(name = "Diasfestivos.findByTitulo", query = "SELECT d FROM Diasfestivos d WHERE d.titulo = :titulo")})

public class Diasfestivos implements Serializable {

    @Size(max = 250)
    @Column(name = "titulo")
    private String titulo;

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
    @Column(name = "esCursillo")
    private Boolean esCursillo;

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

    public Diasfestivos(String titulo, Date fechaFestivo, String comentario) {
        this.titulo = titulo;
        this.fechaFestivo = fechaFestivo;
        this.comentario = comentario;
    }

    public Diasfestivos(String titulo, Date fechaFestivo, String comentario, Boolean cursillo) {
        this.titulo = titulo;
        this.fechaFestivo = fechaFestivo;
        this.comentario = comentario;
        this.esCursillo = cursillo;
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

    public Boolean getEsCursillo() {
        return esCursillo;
    }

    public void setEsCursillo(Boolean esCursillo) {
        this.esCursillo = esCursillo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.titulo);
        hash = 19 * hash + Objects.hashCode(this.fechaFestivo);
        hash = 19 * hash + Objects.hashCode(this.comentario);
        hash = 19 * hash + Objects.hashCode(this.esCursillo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Diasfestivos other = (Diasfestivos) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.fechaFestivo, other.fechaFestivo)) {
            return false;
        }
        if (!Objects.equals(this.esCursillo, other.esCursillo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
