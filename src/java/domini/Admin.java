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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ND17613
 */
@Entity
@Table(name = "admin")
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
    , @NamedQuery(name = "Admin.findByIDadmin", query = "SELECT a FROM Admin a WHERE a.iDadmin = :iDadmin")
    , @NamedQuery(name = "Admin.findByDowID", query = "SELECT a FROM Admin a WHERE a.dowID = :dowID")
    , @NamedQuery(name = "Admin.findByNombre", query = "SELECT a FROM Admin a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Admin.findByApellidos", query = "SELECT a FROM Admin a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "Admin.findByNivelAdmin", query = "SELECT a FROM Admin a WHERE a.nivelAdmin = :nivelAdmin")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDadmin")
    private Integer iDadmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "dowID")
    private String dowID;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "nivelAdmin")
    private Character nivelAdmin;

    public Admin() {
    }

    public Admin(Integer iDadmin) {
        this.iDadmin = iDadmin;
    }

    public Admin(Integer iDadmin, String dowID) {
        this.iDadmin = iDadmin;
        this.dowID = dowID;
    }

    public Integer getIDadmin() {
        return iDadmin;
    }

    public void setIDadmin(Integer iDadmin) {
        this.iDadmin = iDadmin;
    }

    public String getDowID() {
        return dowID;
    }

    public void setDowID(String dowID) {
        this.dowID = dowID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Character getNivelAdmin() {
        return nivelAdmin;
    }

    public void setNivelAdmin(Character nivelAdmin) {
        this.nivelAdmin = nivelAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDadmin != null ? iDadmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.iDadmin == null && other.iDadmin != null) || (this.iDadmin != null && !this.iDadmin.equals(other.iDadmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domini.Admin[ iDadmin=" + iDadmin + " ]";
    }
    
}
