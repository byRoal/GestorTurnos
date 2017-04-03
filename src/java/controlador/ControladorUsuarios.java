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
import java.math.BigInteger;
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

    public String prepararInsercio() {
        netejarFormulari();
        return "InsercioUsuari";
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

    public String crearUsuari(String dowId) {
        Integer iDusuarios = 104;
        BigDecimal num = new BigDecimal("0");
        char torn = 'A';
        byte[] foto = null;
        try {
            foto = IOUtils.toByteArray(usuariActual.getArxiuFoto().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(dowId);
        Usuarios u = new Usuarios(dowId);
        u.setFoto(foto);
        serveiUsuarios.inserirUsuario(u);
        return "/index1";
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
        //usuariActual.setiDusuarios(u.getIDusuarios());

        if (u.getFoto() != null) {            
            ByteArrayInputStream fotoStream = new ByteArrayInputStream(u.getFoto());
            StreamedContent streamFoto = new DefaultStreamedContent(fotoStream, "image/png");
            usuariActual.setFoto(streamFoto);
        }
    }

    public String obtenirUsuarioConsulta(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_su";
    }

    public String obtenirUsuarioModificacio(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Foto";
    }

    public String obtenirUsuarioEliminacio(String dowId) {
        Usuarios u = serveiUsuarios.obtenirUsuario(dowId);
        passarUsuariosUsuariosDTO(u);
        return "Eliminacio";
    }

    private void passarUsuarioDTOUsuario(Usuarios u) {
        byte[] foto = null;
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
        //u.setIDusuarios(usuariActual.getiDusuarios());

//        try {
//            foto = IOUtils.toByteArray(usuariActual.getArxiuFoto().getInputstream());
//        } catch (IOException ex) {
//            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        u.setFoto(foto);
    }

    public String modificarUsuario(String id) {
        Usuarios u = serveiUsuarios.obtenirUsuariDowId(id);
        passarUsuarioDTOUsuario(u);
        serveiUsuarios.modificarUsuario(u);
//        return "/index1";
return "Ficha_su";
    }

    public String eliminarUsuario(String dowId) {
        serveiUsuarios.eliminarUsuario(dowId);
        return "index";
    }

    public List<Usuarios> llistarUsuarios() {
        return serveiUsuarios.llistarUsuarios();
    }

    public List<Usuarios> llistarUsuariosAsc() {
        return serveiUsuarios.llistarUsuariosAsc();
    }
}
