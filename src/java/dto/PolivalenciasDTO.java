/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domini.Usuarios;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ND17613
 */
@RequestScoped
public class PolivalenciasDTO {
    private Integer iDpolivalencias;
    private Boolean panelZC;
    private Date fechaPanelZC;
    private Boolean a;
    private Date fecha111;
    private Boolean a1;
    private Date fecha2;
    private Boolean a2;
    private Date fecha3;
    private Boolean a3;
    private Date fecha4510;
    private Boolean panelZF;
    private Date fechaPanelZF;
    private Boolean a4;
    private Date fecha67;
    private Boolean a5;
    private Date fecha89;
    private Boolean panelOcteno;
    private Date fechaPanelOcteno;
    private Boolean campoOcteno;
    private Date fechaCampoOcteno;
    private Usuarios dowID;
    private List<String[]> llistaP;
    
    public PolivalenciasDTO() {
    }

    public Integer getiDpolivalencias() {
        return iDpolivalencias;
    }

    public void setiDpolivalencias(Integer iDpolivalencias) {
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

}
