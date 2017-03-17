/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.Usuarios;
import dto.UsuariosDTO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import servei.UsuariosServei;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class ControladorUsuarios implements Serializable {

    @Inject
    private UsuariosServei serveiUsuarios;

    @Inject
    private UsuariosDTO usuariActual;

    public UsuariosServei getServeiUsuarios() {
        return serveiUsuarios;
    }

    public void setServeiUsuarios(UsuariosServei serveiUsuarios) {
        this.serveiUsuarios = serveiUsuarios;
    }

    public UsuariosDTO getUsuariActual() {
        return usuariActual;
    }

    public void setUsuariActual(UsuariosDTO usuariActual) {
        this.usuariActual = usuariActual;
    }

    public String preprarInsercio() {
        netejarFormulari();
        return "FormulariInsercio";
    }

    public void netejarFormulari() {
        usuariActual.setAñoIncorporacion(null);
        usuariActual.setBajasPermisosList(null);
        usuariActual.setContabilidadhorasList(null);
        usuariActual.setDepartamento(null);
        usuariActual.setDireccion(null);
        usuariActual.setDowID(null);
        usuariActual.setEdad(0);
        usuariActual.setEmail(null);
        usuariActual.setFoto(null);
        usuariActual.setHorasextrasRList(null);
        usuariActual.setMovil(null);
        usuariActual.setNombre(null);
        usuariActual.setPlanta(null);
        usuariActual.setPolivalenciasList(null);
        usuariActual.setSexo(null);
        usuariActual.setSupervisor(null);
        usuariActual.setTelefono(null);
    }

    public String crearUsuari(String dowID, String nombre, String sexo, Integer edad, String direccion, String telefono, String movil, String email, String planta, String departamento, Character turno, String supervisor, String añoIncorporacion, BigDecimal vacacionesHechas, BigDecimal vacacionesPendientes, BigDecimal vacacionesArrastradas) {
        byte[] foto = null;
        try {
            foto = IOUtils.toByteArray(usuariActual.getArxiuFoto().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuarios u = new Usuarios(dowID, nombre, sexo, edad, direccion, telefono, movil, email, foto, planta, departamento, turno, supervisor, añoIncorporacion, vacacionesHechas, vacacionesPendientes, vacacionesArrastradas);
        serveiUsuarios.inserirUsuario(u);
        return "index";
    }

    private void passarUsuariosUsuariosDTO(Usuarios u) {
        usuariActual.setAñoIncorporacion(u.getAñoIncorporacion());
        usuariActual.setBajasPermisosList(u.getBajasPermisosList());
        usuariActual.setContabilidadhorasList(u.getContabilidadhorasList());
        usuariActual.setDepartamento(u.getDepartamento());
        usuariActual.setDireccion(u.getDireccion());
        usuariActual.setDowID(u.getDowID());
        usuariActual.setEdad(u.getEdad());
        usuariActual.setEmail(u.getEmail());
        usuariActual.setHorasextrasRList(u.getHorasextrasRList());
        usuariActual.setMovil(u.getMovil());
        usuariActual.setNombre(u.getNombre());
        usuariActual.setPlanta(u.getPlanta());
        usuariActual.setPolivalenciasList(u.getPolivalenciasList());
        usuariActual.setSexo(u.getSexo());
        usuariActual.setSupervisor(u.getSupervisor());
        usuariActual.setTelefono(u.getTelefono());
        usuariActual.setTurno(u.getTurno());
        usuariActual.setVacacionesArrastradas(u.getVacacionesArrastradas());
        usuariActual.setVacacionesPendientes(u.getVacacionesPendientes());
        usuariActual.setVacacionesHechas(u.getVacacionesHechas());
        usuariActual.setiDusuarios(u.getIDusuarios());

        if (u.getFoto() != null) {
            ByteArrayInputStream fotoStream = new ByteArrayInputStream(u.getFoto());
            StreamedContent streamFoto = new DefaultStreamedContent(fotoStream, "image/png");
            usuariActual.setFoto(streamFoto);
        }
    }

    public String obtenirUsuarioConsulta(String dowId) {
        Usuarios u = serveiUsuarios.obtenirUsuario(dowId);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_su";
    }
    
    public String obtenirUsuarioModificacio(String dowId) {
        Usuarios u = serveiUsuarios.obtenirUsuario(dowId);
        passarUsuariosUsuariosDTO(u);
        return "Modificacio";
    }
    
    public String obtenirUsuarioEliminacio(String dowId) {
        Usuarios u = serveiUsuarios.obtenirUsuario(dowId);
        passarUsuariosUsuariosDTO(u);
        return "Eliminacio";
    }
    
    private void passarUsuarioDTOUsuario(Usuarios u){
        u.setAñoIncorporacion(usuariActual.getAñoIncorporacion());
        u.setDepartamento(usuariActual.getDepartamento());
        u.setDireccion(usuariActual.getDepartamento());
        u.setDowID(usuariActual.getDowID());
        u.setEdad(usuariActual.getEdad());
        u.setEmail(usuariActual.getEmail());
        u.setMovil(usuariActual.getMovil());
        u.setNombre(usuariActual.getNombre());
        u.setPlanta(usuariActual.getPlanta());
        u.setSexo(usuariActual.getSexo());
        u.setSupervisor(usuariActual.getSupervisor());
        u.setTelefono(usuariActual.getTelefono());
        u.setTurno(usuariActual.getTurno());
        u.setVacacionesArrastradas(usuariActual.getVacacionesArrastradas());
        u.setVacacionesHechas(usuariActual.getVacacionesHechas());
        u.setVacacionesPendientes(usuariActual.getVacacionesPendientes());
        u.setIDusuarios(usuariActual.getiDusuarios());
    }
    
    public String modificarUsuario(String dowId) {
        Usuarios u = serveiUsuarios.obtenirUsuario(dowId);
        passarUsuarioDTOUsuario(u);
        serveiUsuarios.modificarUsuario(u);
        return "index";
    }
    
    public String eliminarUsuario(String dowId) {
        serveiUsuarios.eliminarUsuario(dowId);
        return "index";
    }
    
    public List<Usuarios> llistarUsuarios(){
        return serveiUsuarios.llistarUsuarios();
    }
}
