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
@Table(name = "bajas_permisos")
@NamedQueries({
    @NamedQuery(name = "BajasPermisos.findAll", query = "SELECT b FROM BajasPermisos b")
    , @NamedQuery(name = "BajasPermisos.findByIDbajaspermisos", query = "SELECT b FROM BajasPermisos b WHERE b.iDbajaspermisos = :iDbajaspermisos")
    , @NamedQuery(name = "BajasPermisos.findByBaja", query = "SELECT b FROM BajasPermisos b WHERE b.baja = :baja")
    , @NamedQuery(name = "BajasPermisos.findByPermisos", query = "SELECT b FROM BajasPermisos b WHERE b.permisos = :permisos")
    , @NamedQuery(name = "BajasPermisos.findByDataInicio", query = "SELECT b FROM BajasPermisos b WHERE b.dataInicio = :dataInicio")
    , @NamedQuery(name = "BajasPermisos.findByDataFin", query = "SELECT b FROM BajasPermisos b WHERE b.dataFin = :dataFin")
    , @NamedQuery(name = "BajasPermisos.findByDiasTotales", query = "SELECT b FROM BajasPermisos b WHERE b.diasTotales = :diasTotales")
    , @NamedQuery(name = "BajasPermisos.findByComentario", query = "SELECT b FROM BajasPermisos b WHERE b.comentario = :comentario")})
public class BajasPermisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDbajas_permisos")
    private Integer iDbajaspermisos;
    @Column(name = "baja")
    private Boolean baja;
    @Column(name = "permisos")
    private Boolean permisos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataInicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataFin")
    @Temporal(TemporalType.DATE)
    private Date dataFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diasTotales")
    private int diasTotales;
    @Size(max = 100)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "dowID", referencedColumnName = "dowID")
    @ManyToOne(optional = false)
    private Usuarios dowID;

    public BajasPermisos() {
    }

    public BajasPermisos(Integer iDbajaspermisos) {
        this.iDbajaspermisos = iDbajaspermisos;
    }

    public BajasPermisos(Date dataInicio, Date dataFin, int diasTotales, Usuarios dowID) {
        this.dataInicio = dataInicio;
        this.dataFin = dataFin;
        this.diasTotales = diasTotales;
        this.dowID = dowID;
    }

    

    public Integer getIDbajaspermisos() {
        return iDbajaspermisos;
    }

    public void setIDbajaspermisos(Integer iDbajaspermisos) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDbajaspermisos != null ? iDbajaspermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BajasPermisos)) {
            return false;
        }
        BajasPermisos other = (BajasPermisos) object;
        if ((this.iDbajaspermisos == null && other.iDbajaspermisos != null) || (this.iDbajaspermisos != null && !this.iDbajaspermisos.equals(other.iDbajaspermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domini.BajasPermisos[ iDbajaspermisos=" + iDbajaspermisos + " ]";
    }
    
}
