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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "horasextras_r")
@NamedQueries({
    @NamedQuery(name = "HorasextrasR.findAll", query = "SELECT h FROM HorasextrasR h")
    , @NamedQuery(name = "HorasextrasR.findByIDHorasExtras", query = "SELECT h FROM HorasextrasR h WHERE h.iDHorasExtras = :iDHorasExtras")
    , @NamedQuery(name = "HorasextrasR.findByDia", query = "SELECT h FROM HorasextrasR h WHERE h.dia = :dia")
    , @NamedQuery(name = "HorasextrasR.findByHorasExtras", query = "SELECT h FROM HorasextrasR h WHERE h.horasExtras = :horasExtras")
    , @NamedQuery(name = "HorasextrasR.findByComentario", query = "SELECT h FROM HorasextrasR h WHERE h.comentario = :comentario")})
public class HorasextrasR implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDHorasExtras")
    private Integer iDHorasExtras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia")
    @Temporal(TemporalType.DATE)
    private Date dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horasExtras")
    private int horasExtras;
    @Size(max = 250)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "dowID", referencedColumnName = "dowID")
    @ManyToOne(optional = false)
    private Usuarios dowID;

    public HorasextrasR() {
    }

    public HorasextrasR(Integer iDHorasExtras) {
        this.iDHorasExtras = iDHorasExtras;
    }

    public HorasextrasR(Integer iDHorasExtras, Date dia, int horasExtras) {
        this.iDHorasExtras = iDHorasExtras;
        this.dia = dia;
        this.horasExtras = horasExtras;
    }

    public Integer getIDHorasExtras() {
        return iDHorasExtras;
    }

    public void setIDHorasExtras(Integer iDHorasExtras) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDHorasExtras != null ? iDHorasExtras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorasextrasR)) {
            return false;
        }
        HorasextrasR other = (HorasextrasR) object;
        if ((this.iDHorasExtras == null && other.iDHorasExtras != null) || (this.iDHorasExtras != null && !this.iDHorasExtras.equals(other.iDHorasExtras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domini.HorasextrasR[ iDHorasExtras=" + iDHorasExtras + " ]";
    }
    
}
