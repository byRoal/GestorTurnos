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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        return "InsercioUsuari?faces-redirect=true";
    }

    public void netejarFormulari() {
        usuariActual.setAñoIncorporacion(null);
        usuariActual.setBajasPermisosList(null);
        usuariActual.setContabilidadhorasList(null);
        usuariActual.setDepartamento(null);
        usuariActual.setDireccion(null);
        usuariActual.setDowID(null);
        usuariActual.setFechaNacimiento(null);
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
        usuariActual.setTurno(null);
    }

    public String crearUsuari(String dowId) {
        byte[] foto = null;
        String nombre = null, sexo = null, direccion = null, telefono = null, movil = null, email = null, planta = null, departamento = null, supervisor = null, añoIncorporacion = null;
        Date fechaNacimiento = null;
        Character turno = null;
        try {
            foto = IOUtils.toByteArray(usuariActual.getArxiuFoto().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        nombre=usuariActual.getNombre();
        sexo=usuariActual.getSexo();
        direccion=usuariActual.getDireccion();
        telefono=usuariActual.getTelefono();
        movil=usuariActual.getMovil();
        email=usuariActual.getEmail();
        planta=usuariActual.getPlanta();
        departamento=usuariActual.getDepartamento();
        supervisor=usuariActual.getSupervisor();
        añoIncorporacion=usuariActual.getAñoIncorporacion();
        fechaNacimiento=usuariActual.getFechaNacimiento();
        turno=usuariActual.getTurno();
        
        Usuarios u = new Usuarios(dowId);
        u.setFoto(foto);
        u.setAñoIncorporacion(añoIncorporacion);
        u.setDepartamento(departamento);
        u.setDireccion(direccion);
        u.setEmail(email);
        u.setFechaNacimiento(fechaNacimiento);
        u.setMovil(movil);
        u.setNombre(nombre);
        u.setPlanta(planta);
        u.setSexo(sexo);
        u.setSupervisor(supervisor);
        u.setTelefono(telefono);
        u.setTurno(turno);
        serveiUsuarios.inserirUsuario(u);
        return "/index1?faces-redirect=true";
    }

    private void passarUsuariosUsuariosDTO(Usuarios u) {
        usuariActual.setAñoIncorporacion(u.getAñoIncorporacion());
        usuariActual.setBajasPermisosList(u.getBajasPermisosList());
        usuariActual.setContabilidadhorasList(u.getContabilidadhorasList());
        usuariActual.setDepartamento(u.getDepartamento());
        usuariActual.setDireccion(u.getDireccion());
        usuariActual.setDowID(u.getDowID());
        usuariActual.setFechaNacimiento(u.getFechaNacimiento());
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
        return "Ficha_su?faces-redirect=true";
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
        u.setFechaNacimiento(usuariActual.getFechaNacimiento());
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

        try {
            foto = IOUtils.toByteArray(usuariActual.getArxiuFoto().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (foto.length != 0) {
            u.setFoto(foto);
        }
    }

    public String modificarUsuario(String id) {
        Usuarios u = serveiUsuarios.obtenirUsuariDowId(id);
        passarUsuarioDTOUsuario(u);
        serveiUsuarios.modificarUsuario(u);
        return "/index1?faces-redirect=true";
//        return "Ficha_su";
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

    public int añosAntiguedad(int incorporacion) {
        Calendar cal = new GregorianCalendar();
        int antiguedad;
        antiguedad = cal.getInstance().get(Calendar.YEAR) - incorporacion;

        return antiguedad;
    }

    public List<String> departaments(String planta) {
        List<String> departament = new ArrayList<>();
        if (planta.equals("Cracker")) {

            departament.add("LHC Tarragona Operations");
            departament.add("Octene Tarragona Operations");
            return departament;
        } else if (planta.equals("Octeno")) {
//            departament= new String[]{"Octene Productions", "Tarragona Analytical Services"};
            departament.add("Octene Productions");
            departament.add("Tarragona Analytical Services");
            return departament;
        } else {
            departament.add("---");
            return departament;
        }
    }
}
