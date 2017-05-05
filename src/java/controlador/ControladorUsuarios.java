/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.Polivalencias;
import domini.Usuarios;
import dto.UsuariosDTO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import servei.PolivalenciasServei;
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

    @Inject
    private PolivalenciasServei serveiPolivalencies;

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
        return "superuser/AltaUsuario?faces-redirect=true";
    }

    /**
     * función para poner null a todas las variables de usuariActual
     */
    public void netejarFormulari() {
        usuariActual.setFechaIncorporacion(null);
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
        //variables que puede tener un usuario
        byte[] foto = null;
        String nombre = null, sexo = null, direccion = null, telefono = null, movil = null, email = null, planta = null, departamento = null, supervisor = null;
        Date fechaNacimiento = null, fechaIncorporacion = null;
        Character turno = null;
        
       //cojemos los datos de la foto subida
        try {
            foto = IOUtils.toByteArray(usuariActual.getArxiuFoto().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Si no se ha subido ninguna foto, se pone una imagen por defecto al usuario
        if (foto.length == 0) {
            try {
                foto = Files.readAllBytes(new File("C:\\Users\\ND17613\\Documents\\NetBeansProjects\\GestorTurnos\\web\\resources\\images\\profile.png").toPath());

//                InputStream input = new FileInputStream("profile.png");
//                foto = IOUtils.toByteArray(input);
            } catch (IOException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //todas las variables toman el valor que se les ha dado en el formulario de inserción
        nombre = usuariActual.getNombre();
        sexo = usuariActual.getSexo();
        direccion = usuariActual.getDireccion();
        telefono = usuariActual.getTelefono();
        movil = usuariActual.getMovil();
        email = usuariActual.getEmail();
        planta = usuariActual.getPlanta();
        departamento = usuariActual.getDepartamento();
        supervisor = usuariActual.getSupervisor();
        fechaIncorporacion = usuariActual.getFechaIncorporacion();
        fechaNacimiento = usuariActual.getFechaNacimiento();
        turno = usuariActual.getTurno();

        //Se crea un usuario nuevo con todos los datos y se inserta en la BD
        Usuarios u = new Usuarios(dowId);
        u.setFoto(foto);
        u.setFechaIncorporacion(fechaIncorporacion);
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

        //Se crea un campo en la tabla polivalencias con el nuevo usuario pero sin ningún dato extra 
        Polivalencias p = new Polivalencias(u);
        p.setA(false);
        p.setA1(false);
        p.setA2(false);
        p.setA3(false);
        p.setA4(false);
        p.setA5(false);
        p.setCampoOcteno(false);
        p.setPanelOcteno(false);
        p.setPanelZC(false);
        p.setPanelZF(false);
        serveiPolivalencies.inserirPolivalencia(p);
        
        return "/index?faces-redirect=true";
    }

    /**
     * función para pasar información de un usuario de la BD a la web 
     * @param u 
     */
    private void passarUsuariosUsuariosDTO(Usuarios u) {
        usuariActual.setFechaIncorporacion(u.getFechaIncorporacion());
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

    public String obtenirUsuarioFitxaSU(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_su?faces-redirect=true";
    }

    public String obtenirUsuarioFitxaUser(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_usuario?faces-redirect=true";
    }

    public String obtenirUsuarioFitxaAdmin(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_admin?faces-redirect=true";
    }

    public String obtenirUsuarioFitxaRRHH(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_RRHH?faces-redirect=true";
    }

    public String obtenirUsuarioModificacio(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Modificar?faces-redirect=true";
    }

    public String obtenirUsuarioEliminacio(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Eliminar?faces-redirect=true";
    }

    /**
     * función para pasar informacón de un usuario de la web a la BD
     * @param u 
     */
    private void passarUsuarioDTOUsuario(Usuarios u) {
        byte[] foto = {0};
        u.setFechaIncorporacion(usuariActual.getFechaIncorporacion());
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

//        try {
//            foto = IOUtils.toByteArray(usuariActual.getArxiuFoto().getInputstream());
//        } catch (IOException ex) {
//            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        if (foto.length != 0) {
//            u.setFoto(foto);
//        }
    }

    /**
     * función para pasar información de un usuario de la web a la BD
     * @param u 
     */
    private void passarUsuarioDTOUsuarioFoto(Usuarios u) {
        byte[] foto = {0};
        u.setFechaIncorporacion(usuariActual.getFechaIncorporacion());
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
//        return "/index1?faces-redirect=true";
        return "Ficha_su";
    }

    public String modificarUsuarioFoto(String id) {
        Usuarios u = serveiUsuarios.obtenirUsuariDowId(id);
        passarUsuarioDTOUsuarioFoto(u);
        serveiUsuarios.modificarUsuario(u);
        return "/index?faces-redirect=true";
//        return "Ficha_su";
    }

    public String eliminarUsuario(String id) {
        Usuarios u = serveiUsuarios.obtenirUsuariDowId(id);
        Polivalencias p = serveiPolivalencies.obtenirPolivalenciaDowId(u.getDowID());
        serveiPolivalencies.eliminarPolivalencia(p.getIDpolivalencias());
        serveiUsuarios.eliminarUsuario(u.getDowID());
        return "/index?faces-redirect=true";
    }

    public List<Usuarios> llistarUsuarios() {
        return serveiUsuarios.llistarUsuarios();
    }

    public List<Usuarios> llistarUsuariosAsc() {
        return serveiUsuarios.llistarUsuariosAsc();
    }

    /**
     * función para determinar los años de antiguedad que lleva un usuario en la empresa pasandole por parámetro su año de incorporación
     * @param incorporacion
     * @return 
     */
    public String añosAntiguedad(Date incorporacion) {
        int antiguedad = 0;
        if (incorporacion == null) {
            return "--";
        } else {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            cal2.setTime(incorporacion);

            antiguedad = cal1.getInstance().get(Calendar.YEAR) - cal2.get(Calendar.YEAR);

            return String.valueOf(antiguedad);
        }
    }

    /**
     * función que cambia la lista de departamentos en el formulario de inserción dependiendo de la planta que reciba por parametro
     * @param planta
     * @return 
     */
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

    /**
     * función para formatear la fecha de incorporación de un usuario
     * @return 
     */
    public String fechaInc() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fechaInc = df.format(usuariActual.getFechaIncorporacion());

        return fechaInc;
    }

    public int renderRole() {
//        Map<String, Object> cookies = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
//        Cookie cookie = (Cookie) cookies.get("dowid");
//        String dowid = cookie.getValue();
//        Usuarios usuari = serveiUsuarios.obtenirUsuariDowId(dowid);
        String role = "user";
    
        switch(role){
            case "user":
                return 1;
                
            case "rrhh":
                return 2;
               
            case "admin":
                return 3;
                
            case "su":
                return 4;
        }
        return 0;
    }   
    
}
