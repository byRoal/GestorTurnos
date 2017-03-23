/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domini;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ND17613
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findAllAsc", query = "SELECT u FROM Usuarios u ORDER BY u.nombre ASC")
    , @NamedQuery(name = "Usuarios.findByIDusuarios", query = "SELECT u FROM Usuarios u WHERE u.iDusuarios = :iDusuarios")
    , @NamedQuery(name = "Usuarios.findByDowID", query = "SELECT u FROM Usuarios u WHERE u.dowID = :dowID")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo")
    , @NamedQuery(name = "Usuarios.findByEdad", query = "SELECT u FROM Usuarios u WHERE u.edad = :edad")
    , @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuarios.findByMovil", query = "SELECT u FROM Usuarios u WHERE u.movil = :movil")
    , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
    , @NamedQuery(name = "Usuarios.findByFoto", query = "SELECT u FROM Usuarios u WHERE u.foto = :foto")
    , @NamedQuery(name = "Usuarios.findByPlanta", query = "SELECT u FROM Usuarios u WHERE u.planta = :planta")
    , @NamedQuery(name = "Usuarios.findByDepartamento", query = "SELECT u FROM Usuarios u WHERE u.departamento = :departamento")
    , @NamedQuery(name = "Usuarios.findByTurno", query = "SELECT u FROM Usuarios u WHERE u.turno = :turno")
    , @NamedQuery(name = "Usuarios.findBySupervisor", query = "SELECT u FROM Usuarios u WHERE u.supervisor = :supervisor")
    , @NamedQuery(name = "Usuarios.findByA\u00f1oIncorporacion", query = "SELECT u FROM Usuarios u WHERE u.a\u00f1oIncorporacion = :a\u00f1oIncorporacion")
    , @NamedQuery(name = "Usuarios.findByVacacionesHechas", query = "SELECT u FROM Usuarios u WHERE u.vacacionesHechas = :vacacionesHechas")
    , @NamedQuery(name = "Usuarios.findByVacacionesPendientes", query = "SELECT u FROM Usuarios u WHERE u.vacacionesPendientes = :vacacionesPendientes")
    , @NamedQuery(name = "Usuarios.findByVacacionesArrastradas", query = "SELECT u FROM Usuarios u WHERE u.vacacionesArrastradas = :vacacionesArrastradas")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDusuarios")
    private Integer iDusuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "dowID")
    private String dowID;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "edad")
    private Integer edad;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 13)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 13)
    @Column(name = "movil")
    private String movil;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    
    @Column(name = "foto")
    @Lob
    @Basic(fetch= FetchType.EAGER)
    private byte[] foto;
    @Size(max = 45)
    @Column(name = "planta")
    private String planta;
    @Size(max = 45)
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "turno")
    private Character turno;
    @Size(max = 45)
    @Column(name = "supervisor")
    private String supervisor;
    @Size(max = 45)
    @Column(name = "a\u00f1oIncorporacion")
    private String añoIncorporacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vacacionesHechas")
    private BigDecimal vacacionesHechas;
    @Column(name = "vacacionesPendientes")
    private BigDecimal vacacionesPendientes;
    @Column(name = "vacacionesArrastradas")
    private BigDecimal vacacionesArrastradas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dowID")
    private List<HorasextrasR> horasextrasRList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dowID")
    private List<Contabilidadhoras> contabilidadhorasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dowID")
    private List<BajasPermisos> bajasPermisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dowID")
    private List<Vacaciones> vacacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dowID")
    private List<Polivalencias> polivalenciasList;

    public Usuarios() {
    }

    public Usuarios(Integer iDusuarios) {
        this.iDusuarios = iDusuarios;
    }

    public Usuarios(String dowID, String nombre, String sexo, Integer edad, String direccion, String telefono, String movil, String email, byte[] foto, String planta, String departamento, Character turno, String supervisor, String añoIncorporacion, BigDecimal vacacionesHechas, BigDecimal vacacionesPendientes, BigDecimal vacacionesArrastradas) {
        this.dowID = dowID;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.email = email;
        this.foto = foto;
        this.planta = planta;
        this.departamento = departamento;
        this.turno = turno;
        this.supervisor = supervisor;
        this.añoIncorporacion = añoIncorporacion;
        this.vacacionesHechas = vacacionesHechas;
        this.vacacionesPendientes = vacacionesPendientes;
        this.vacacionesArrastradas = vacacionesArrastradas;
    }
    

    public Usuarios(Integer iDusuarios, String dowID) {
        this.iDusuarios = iDusuarios;
        this.dowID = dowID;
    }

    public Integer getIDusuarios() {
        return iDusuarios;
    }

    public void setIDusuarios(Integer iDusuarios) {
        this.iDusuarios = iDusuarios;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Character getTurno() {
        return turno;
    }

    public void setTurno(Character turno) {
        this.turno = turno;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getAñoIncorporacion() {
        return añoIncorporacion;
    }

    public void setAñoIncorporacion(String añoIncorporacion) {
        this.añoIncorporacion = añoIncorporacion;
    }

    public BigDecimal getVacacionesHechas() {
        return vacacionesHechas;
    }

    public void setVacacionesHechas(BigDecimal vacacionesHechas) {
        this.vacacionesHechas = vacacionesHechas;
    }

    public BigDecimal getVacacionesPendientes() {
        return vacacionesPendientes;
    }

    public void setVacacionesPendientes(BigDecimal vacacionesPendientes) {
        this.vacacionesPendientes = vacacionesPendientes;
    }

    public BigDecimal getVacacionesArrastradas() {
        return vacacionesArrastradas;
    }

    public void setVacacionesArrastradas(BigDecimal vacacionesArrastradas) {
        this.vacacionesArrastradas = vacacionesArrastradas;
    }

    public List<HorasextrasR> getHorasextrasRList() {
        return horasextrasRList;
    }

    public void setHorasextrasRList(List<HorasextrasR> horasextrasRList) {
        this.horasextrasRList = horasextrasRList;
    }

    public List<Contabilidadhoras> getContabilidadhorasList() {
        return contabilidadhorasList;
    }

    public void setContabilidadhorasList(List<Contabilidadhoras> contabilidadhorasList) {
        this.contabilidadhorasList = contabilidadhorasList;
    }

    public List<BajasPermisos> getBajasPermisosList() {
        return bajasPermisosList;
    }

    public void setBajasPermisosList(List<BajasPermisos> bajasPermisosList) {
        this.bajasPermisosList = bajasPermisosList;
    }

    public List<Vacaciones> getVacacionesList() {
        return vacacionesList;
    }

    public void setVacacionesList(List<Vacaciones> vacacionesList) {
        this.vacacionesList = vacacionesList;
    }

    public List<Polivalencias> getPolivalenciasList() {
        return polivalenciasList;
    }

    public void setPolivalenciasList(List<Polivalencias> polivalenciasList) {
        this.polivalenciasList = polivalenciasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDusuarios != null ? iDusuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.iDusuarios == null && other.iDusuarios != null) || (this.iDusuarios != null && !this.iDusuarios.equals(other.iDusuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domini.Usuarios[ iDusuarios=" + iDusuarios + " ]";
    }
    
}
