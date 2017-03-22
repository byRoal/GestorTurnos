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
import javax.persistence.FetchType;
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

/**
 *
 * @author ND17613
 */
@Entity
@Table(name = "polivalencias")
@NamedQueries({
    @NamedQuery(name = "Polivalencias.findAll", query = "SELECT p FROM Polivalencias p")
    , @NamedQuery(name = "Polivalencias.findByIDpolivalencias", query = "SELECT p FROM Polivalencias p WHERE p.iDpolivalencias = :iDpolivalencias")
    , @NamedQuery(name = "Polivalencias.findByPanelZC", query = "SELECT p FROM Polivalencias p WHERE p.panelZC = :panelZC")
    , @NamedQuery(name = "Polivalencias.findByFechaPanelZC", query = "SELECT p FROM Polivalencias p WHERE p.fechaPanelZC = :fechaPanelZC")
    , @NamedQuery(name = "Polivalencias.findByA", query = "SELECT p FROM Polivalencias p WHERE p.a = :a")
    , @NamedQuery(name = "Polivalencias.findByFecha111", query = "SELECT p FROM Polivalencias p WHERE p.fecha111 = :fecha111")
    , @NamedQuery(name = "Polivalencias.findByA1", query = "SELECT p FROM Polivalencias p WHERE p.a1 = :a1")
    , @NamedQuery(name = "Polivalencias.findByFecha2", query = "SELECT p FROM Polivalencias p WHERE p.fecha2 = :fecha2")
    , @NamedQuery(name = "Polivalencias.findByA2", query = "SELECT p FROM Polivalencias p WHERE p.a2 = :a2")
    , @NamedQuery(name = "Polivalencias.findByFecha3", query = "SELECT p FROM Polivalencias p WHERE p.fecha3 = :fecha3")
    , @NamedQuery(name = "Polivalencias.findByA3", query = "SELECT p FROM Polivalencias p WHERE p.a3 = :a3")
    , @NamedQuery(name = "Polivalencias.findByFecha4510", query = "SELECT p FROM Polivalencias p WHERE p.fecha4510 = :fecha4510")
    , @NamedQuery(name = "Polivalencias.findByPanelZF", query = "SELECT p FROM Polivalencias p WHERE p.panelZF = :panelZF")
    , @NamedQuery(name = "Polivalencias.findByFechaPanelZF", query = "SELECT p FROM Polivalencias p WHERE p.fechaPanelZF = :fechaPanelZF")
    , @NamedQuery(name = "Polivalencias.findByA4", query = "SELECT p FROM Polivalencias p WHERE p.a4 = :a4")
    , @NamedQuery(name = "Polivalencias.findByFecha67", query = "SELECT p FROM Polivalencias p WHERE p.fecha67 = :fecha67")
    , @NamedQuery(name = "Polivalencias.findByA5", query = "SELECT p FROM Polivalencias p WHERE p.a5 = :a5")
    , @NamedQuery(name = "Polivalencias.findByFecha89", query = "SELECT p FROM Polivalencias p WHERE p.fecha89 = :fecha89")
    , @NamedQuery(name = "Polivalencias.findByPanelOcteno", query = "SELECT p FROM Polivalencias p WHERE p.panelOcteno = :panelOcteno")
    , @NamedQuery(name = "Polivalencias.findByFechaPanelOcteno", query = "SELECT p FROM Polivalencias p WHERE p.fechaPanelOcteno = :fechaPanelOcteno")
    , @NamedQuery(name = "Polivalencias.findByCampoOcteno", query = "SELECT p FROM Polivalencias p WHERE p.campoOcteno = :campoOcteno")
    , @NamedQuery(name = "Polivalencias.findByFechaCampoOcteno", query = "SELECT p FROM Polivalencias p WHERE p.fechaCampoOcteno = :fechaCampoOcteno")
    , @NamedQuery(name = "Polivalencias.findByDowID", query = "SELECT p FROM Polivalencias p WHERE p.dowID.iDusuarios = :id ")})
public class Polivalencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDpolivalencias")
    private Integer iDpolivalencias;
    @Column(name = "panelZC")
    private Boolean panelZC;
    @Column(name = "fechaPanelZC")
    @Temporal(TemporalType.DATE)
    private Date fechaPanelZC;
    @Column(name = "1_11")
    private Boolean a;
    @Column(name = "fecha1_11")
    @Temporal(TemporalType.DATE)
    private Date fecha111;
    @Column(name = "2")
    private Boolean a1;
    @Column(name = "fecha2")
    @Temporal(TemporalType.DATE)
    private Date fecha2;
    @Column(name = "3")
    private Boolean a2;
    @Column(name = "fecha3")
    @Temporal(TemporalType.DATE)
    private Date fecha3;
    @Column(name = "4_5_10")
    private Boolean a3;
    @Column(name = "fecha4_5_10")
    @Temporal(TemporalType.DATE)
    private Date fecha4510;
    @Column(name = "panelZF")
    private Boolean panelZF;
    @Column(name = "fechaPanelZF")
    @Temporal(TemporalType.DATE)
    private Date fechaPanelZF;
    @Column(name = "6_7")
    private Boolean a4;
    @Column(name = "fecha6_7")
    @Temporal(TemporalType.DATE)
    private Date fecha67;
    @Column(name = "8_9")
    private Boolean a5;
    @Column(name = "fecha8_9")
    @Temporal(TemporalType.DATE)
    private Date fecha89;
    @Column(name = "panelOcteno")
    private Boolean panelOcteno;
    @Column(name = "fechaPanelOcteno")
    @Temporal(TemporalType.DATE)
    private Date fechaPanelOcteno;
    @Column(name = "campoOcteno")
    private Boolean campoOcteno;
    @Column(name = "fechaCampoOcteno")
    @Temporal(TemporalType.DATE)
    private Date fechaCampoOcteno;
    @JoinColumn(name = "dowID", referencedColumnName = "dowID")
    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    private Usuarios dowID;

    public Polivalencias() {
    }

    public Polivalencias(Boolean panelZC, Date fechaPanelZC, Boolean a, Date fecha111, Boolean a1, Date fecha2, Boolean a2, Date fecha3, Boolean a3, Date fecha4510, Boolean panelZF, Date fechaPanelZF, Boolean a4, Date fecha67, Boolean a5, Date fecha89, Boolean panelOcteno, Date fechaPanelOcteno, Boolean campoOcteno, Date fechaCampoOcteno, Usuarios dowID) {
        this.panelZC = panelZC;
        this.fechaPanelZC = fechaPanelZC;
        this.a = a;
        this.fecha111 = fecha111;
        this.a1 = a1;
        this.fecha2 = fecha2;
        this.a2 = a2;
        this.fecha3 = fecha3;
        this.a3 = a3;
        this.fecha4510 = fecha4510;
        this.panelZF = panelZF;
        this.fechaPanelZF = fechaPanelZF;
        this.a4 = a4;
        this.fecha67 = fecha67;
        this.a5 = a5;
        this.fecha89 = fecha89;
        this.panelOcteno = panelOcteno;
        this.fechaPanelOcteno = fechaPanelOcteno;
        this.campoOcteno = campoOcteno;
        this.fechaCampoOcteno = fechaCampoOcteno;
        this.dowID = dowID;
    }

    public Polivalencias(Integer iDpolivalencias) {
        this.iDpolivalencias = iDpolivalencias;
    }

    public Integer getIDpolivalencias() {
        return iDpolivalencias;
    }

    public void setIDpolivalencias(Integer iDpolivalencias) {
        this.iDpolivalencias = iDpolivalencias;
    }

    public Boolean getPanelZC() {
        return panelZC;
    }

    public void setPanelZC(Boolean panelZC) {
        this.panelZC = panelZC;
    }

    public Date getFechaPanelZC() {
        return fechaPanelZC;
    }

    public void setFechaPanelZC(Date fechaPanelZC) {
        this.fechaPanelZC = fechaPanelZC;
    }

    public Boolean getA() {
        return a;
    }

    public void setA(Boolean a) {
        this.a = a;
    }

    public Date getFecha111() {
        return fecha111;
    }

    public void setFecha111(Date fecha111) {
        this.fecha111 = fecha111;
    }

    public Boolean getA1() {
        return a1;
    }

    public void setA1(Boolean a1) {
        this.a1 = a1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Boolean getA2() {
        return a2;
    }

    public void setA2(Boolean a2) {
        this.a2 = a2;
    }

    public Date getFecha3() {
        return fecha3;
    }

    public void setFecha3(Date fecha3) {
        this.fecha3 = fecha3;
    }

    public Boolean getA3() {
        return a3;
    }

    public void setA3(Boolean a3) {
        this.a3 = a3;
    }

    public Date getFecha4510() {
        return fecha4510;
    }

    public void setFecha4510(Date fecha4510) {
        this.fecha4510 = fecha4510;
    }

    public Boolean getPanelZF() {
        return panelZF;
    }

    public void setPanelZF(Boolean panelZF) {
        this.panelZF = panelZF;
    }

    public Date getFechaPanelZF() {
        return fechaPanelZF;
    }

    public void setFechaPanelZF(Date fechaPanelZF) {
        this.fechaPanelZF = fechaPanelZF;
    }

    public Boolean getA4() {
        return a4;
    }

    public void setA4(Boolean a4) {
        this.a4 = a4;
    }

    public Date getFecha67() {
        return fecha67;
    }

    public void setFecha67(Date fecha67) {
        this.fecha67 = fecha67;
    }

    public Boolean getA5() {
        return a5;
    }

    public void setA5(Boolean a5) {
        this.a5 = a5;
    }

    public Date getFecha89() {
        return fecha89;
    }

    public void setFecha89(Date fecha89) {
        this.fecha89 = fecha89;
    }

    public Boolean getPanelOcteno() {
        return panelOcteno;
    }

    public void setPanelOcteno(Boolean panelOcteno) {
        this.panelOcteno = panelOcteno;
    }

    public Date getFechaPanelOcteno() {
        return fechaPanelOcteno;
    }

    public void setFechaPanelOcteno(Date fechaPanelOcteno) {
        this.fechaPanelOcteno = fechaPanelOcteno;
    }

    public Boolean getCampoOcteno() {
        return campoOcteno;
    }

    public void setCampoOcteno(Boolean campoOcteno) {
        this.campoOcteno = campoOcteno;
    }

    public Date getFechaCampoOcteno() {
        return fechaCampoOcteno;
    }

    public void setFechaCampoOcteno(Date fechaCampoOcteno) {
        this.fechaCampoOcteno = fechaCampoOcteno;
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
        hash += (iDpolivalencias != null ? iDpolivalencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polivalencias)) {
            return false;
        }
        Polivalencias other = (Polivalencias) object;
        if ((this.iDpolivalencias == null && other.iDpolivalencias != null) || (this.iDpolivalencias != null && !this.iDpolivalencias.equals(other.iDpolivalencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domini.Polivalencias[ iDpolivalencias=" + iDpolivalencias + " ]";
    }
    
}
