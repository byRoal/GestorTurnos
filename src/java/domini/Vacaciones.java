/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domini;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author ND17613
 */
@Entity
@Table(name = "vacaciones")
@NamedQueries({
    @NamedQuery(name = "Vacaciones.findAll", query = "SELECT v FROM Vacaciones v")
    , @NamedQuery(name = "Vacaciones.findByIDVacaciones", query = "SELECT v FROM Vacaciones v WHERE v.iDVacaciones = :iDVacaciones")
    , @NamedQuery(name = "Vacaciones.findByFechaInicio", query = "SELECT v FROM Vacaciones v WHERE v.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Vacaciones.findByFechaFinal", query = "SELECT v FROM Vacaciones v WHERE v.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "Vacaciones.findByDiasTotales", query = "SELECT v FROM Vacaciones v WHERE v.diasTotales = :diasTotales")
    , @NamedQuery(name = "Vacaciones.findByMedioDia", query = "SELECT v FROM Vacaciones v WHERE v.medioDia = :medioDia")})
public class Vacaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVacaciones")
    private Integer iDVacaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFinal")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "diasTotales")
    private BigDecimal diasTotales;
    @Column(name = "medioDia")
    private Boolean medioDia;
    @JoinColumn(name = "dowID", referencedColumnName = "dowID")
    @ManyToOne(optional = false)
    private Usuarios dowID;

    public Vacaciones() {
    }

    public Vacaciones(Integer iDVacaciones) {
        this.iDVacaciones = iDVacaciones;
    }

    public Vacaciones(Integer iDVacaciones, Date fechaInicio, Date fechaFinal, BigDecimal diasTotales) {
        this.iDVacaciones = iDVacaciones;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.diasTotales = diasTotales;
    }

    public Integer getIDVacaciones() {
        return iDVacaciones;
    }

    public void setIDVacaciones(Integer iDVacaciones) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDVacaciones != null ? iDVacaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacaciones)) {
            return false;
        }
        Vacaciones other = (Vacaciones) object;
        if ((this.iDVacaciones == null && other.iDVacaciones != null) || (this.iDVacaciones != null && !this.iDVacaciones.equals(other.iDVacaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domini.Vacaciones[ iDVacaciones=" + iDVacaciones + " ]";
    }
    
}
