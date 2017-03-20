/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domini;

import java.io.Serializable;
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

/**
 *
 * @author ND17613
 */
@Entity
@Table(name = "contabilidadhoras")
@NamedQueries({
    @NamedQuery(name = "Contabilidadhoras.findAll", query = "SELECT c FROM Contabilidadhoras c")
    , @NamedQuery(name = "Contabilidadhoras.findByIDContabilidad", query = "SELECT c FROM Contabilidadhoras c WHERE c.iDContabilidad = :iDContabilidad")
    , @NamedQuery(name = "Contabilidadhoras.findByHorasAnuales", query = "SELECT c FROM Contabilidadhoras c WHERE c.horasAnuales = :horasAnuales")
    , @NamedQuery(name = "Contabilidadhoras.findByHorasTurno", query = "SELECT c FROM Contabilidadhoras c WHERE c.horasTurno = :horasTurno")
    , @NamedQuery(name = "Contabilidadhoras.findByHorasRestantes", query = "SELECT c FROM Contabilidadhoras c WHERE c.horasRestantes = :horasRestantes")
    , @NamedQuery(name = "Contabilidadhoras.findByHorasHechas", query = "SELECT c FROM Contabilidadhoras c WHERE c.horasHechas = :horasHechas")})
public class Contabilidadhoras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDContabilidad")
    private Integer iDContabilidad;
    @Column(name = "horasAnuales")
    private Integer horasAnuales;
    @Column(name = "horasTurno")
    private Integer horasTurno;
    @Column(name = "horasRestantes")
    private Integer horasRestantes;
    @Column(name = "horasHechas")
    private Integer horasHechas;
    @JoinColumn(name = "dowID", referencedColumnName = "dowID")
    @ManyToOne(optional = false)
    private Usuarios dowID;

    public Contabilidadhoras() {
    }

    public Contabilidadhoras(Integer iDContabilidad) {
        this.iDContabilidad = iDContabilidad;
    }

    public Contabilidadhoras(Integer horasAnuales, Integer horasTurno, Integer horasRestantes, Integer horasHechas, Usuarios dowID) {
        this.horasAnuales = horasAnuales;
        this.horasTurno = horasTurno;
        this.horasRestantes = horasRestantes;
        this.horasHechas = horasHechas;
        this.dowID = dowID;
    }

    public Integer getIDContabilidad() {
        return iDContabilidad;
    }

    public void setIDContabilidad(Integer iDContabilidad) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDContabilidad != null ? iDContabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contabilidadhoras)) {
            return false;
        }
        Contabilidadhoras other = (Contabilidadhoras) object;
        if ((this.iDContabilidad == null && other.iDContabilidad != null) || (this.iDContabilidad != null && !this.iDContabilidad.equals(other.iDContabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domini.Contabilidadhoras[ iDContabilidad=" + iDContabilidad + " ]";
    }
    
}
