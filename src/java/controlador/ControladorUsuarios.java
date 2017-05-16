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

    /**
     * función que llama al método para limpiar los datos del usuario y
     * redirecciona a una nueva página
     *
     * @return Strng qe identifica a la nueva página
     */
    public String prepararInsercio() {
        netejarFormulari();
        return "superuser/AltaUsuario?faces-redirect=true";
    }

    /**
     * función para poner null a todas las variables de usuariActual y evitar
     * mezclar datos de usuarios anteriores
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

    /**
     * Función para insertar un usuario nuevo en la BD. También crea el usuario
     * en la tabla de polivalencias sin ningún valor.
     *
     * @param dowId id del usuario dentro de la empresa
     * @return devuelve el String correspondiente a la página web donde te
     * redireccionará al finalizar el método.
     */
    public String crearUsuari(String dowId) {
        byte[] foto = null;
        String nombre = null, sexo = null, direccion = null, telefono = null, movil = null, email = null, planta = null, departamento = null, supervisor = null;
        Date fechaNacimiento = null, fechaIncorporacion = null;
        Character turno = null;

        try {
            foto = IOUtils.toByteArray(usuariActual.getArxiuFoto().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (foto.length == 0) {
            try {
                foto = Files.readAllBytes(new File("C:\\Users\\ND17613\\Documents\\NetBeansProjects\\GestorTurnos\\web\\resources\\images\\profile.png").toPath());

//                InputStream input = new FileInputStream("profile.png");
//                foto = IOUtils.toByteArray(input);
            } catch (IOException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
        p.setFecha111(null);
        p.setFecha2(null);
        p.setFecha3(null);
        p.setFecha4510(null);
        p.setFecha67(null);
        p.setFecha89(null);
        p.setFechaCampoOcteno(null);
        p.setFechaPanelOcteno(null);
        p.setFechaPanelZC(null);
        p.setFechaPanelZF(null);
        serveiPolivalencies.inserirPolivalencia(p);

        return "/index?faces-redirect=true";
    }

    /**
     * función para pasar información de un usuario de la BD a la web y así
     * poder tratarlo.
     *
     * @param u Objeto de la clase Usuarios de dónde será extraída la
     * información, que previamente ha sido obtenido de la BD
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

    /**
     * Busca el usuario correspondiente al id que se le haya enviado y, después
     * de transformar los datos para poderlos tratar, te redirecciona a una
     * página web
     *
     * @param id id del usuario que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirUsuarioFitxaSU(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_su?faces-redirect=true";
    }

    /**
     * Busca el usuario correspondiente al id que se le haya enviado y, después
     * de transformar los datos para poderlos tratar, te redirecciona a una
     * página web
     *
     * @param id id del usuario que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirUsuarioFitxaUser(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_usuario?faces-redirect=true";
    }

    /**
     * Busca el usuario correspondiente al id que se le haya enviado y, después
     * de transformar los datos para poderlos tratar, te redirecciona a una
     * página web
     *
     * @param id id del usuario que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirUsuarioFitxaAdmin(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_admin?faces-redirect=true";
    }

    /**
     * Busca el usuario correspondiente al id que se le haya enviado y, después
     * de transformar los datos para poderlos tratar, te redirecciona a una
     * página web
     *
     * @param id id del usuario que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirUsuarioFitxaRRHH(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Ficha_RRHH?faces-redirect=true";
    }

    /**
     * Busca el usuario correspondiente al id que se le haya enviado y, después
     * de transformar los datos para poderlos tratar, te redirecciona a una
     * página web
     *
     * @param id id del usuario que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirUsuarioModificacio(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Modificar?faces-redirect=true";
    }

    /**
     * Busca el usuario correspondiente al id que se le haya enviado y, después
     * de transformar los datos para poderlos tratar, te redirecciona a una
     * página web
     *
     * @param id id del usuario que se quiere buscar
     * @return String correspondiente a la página web donde serás redireccionado
     */
    public String obtenirUsuarioEliminacio(int id) {
        Usuarios u = serveiUsuarios.obtenirUsuario(id);
        passarUsuariosUsuariosDTO(u);
        return "Eliminar?faces-redirect=true";
    }

    /**
     * función para pasar información de un usuario de la web a información para
     * ser introducida en la BD (no incluye soporte para el campo foto)
     *
     * @param u Objeto de la clase Usuarios dónde se almacenará toda la
     * infrmacón
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
     * función para pasar información de un usuario de la web a información para
     * ser introducida en la BD
     *
     * @param u Objeto de la clase Usuarios dónde se almacenará toda la
     * infrmacón
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

    /**
     * Busca el usuario por el número de id y modifica sus datos por los nuevos
     * introducidos en la web (no incluye soporte para la foto). Al finalizar te
     * redirecciona a otra página.
     *
     * @param id id del suario que se quiere modificar.
     * @return String que identifica la dirección a la página dónde serás
     * redirigido.
     */
    public String modificarUsuario(String id) {
        Usuarios u = serveiUsuarios.obtenirUsuariDowId(id);
        passarUsuarioDTOUsuario(u);
        serveiUsuarios.modificarUsuario(u);
        return "/index1?faces-redirect=true";
    }

    /**
     * Busca el usuario por el número de id y modifica sus datos por los nuevos
     * introducidos en la web. Al finalizar te redirecciona a otra página.
     *
     * @param id id del suario que se quiere modificar.
     * @return String que identifica la dirección a la página dónde serás
     * redirigido.
     */
    public String modificarUsuarioFoto(String id) {
        Usuarios u = serveiUsuarios.obtenirUsuariDowId(id);
        passarUsuarioDTOUsuarioFoto(u);
        serveiUsuarios.modificarUsuario(u);
        return "/index?faces-redirect=true";
    }

    /**
     * Busca el usuario por el número de id y borra las tablas de la BD dónde
     * aparece. Al finalizar te redirecciona a otra página.
     *
     * @param id id del suario que se quiere borrar.
     * @return String que identifica la dirección a la página dónde serás
     * redirigido.
     */
    public String eliminarUsuario(String id) {
        Usuarios u = serveiUsuarios.obtenirUsuariDowId(id);
        Polivalencias p = serveiPolivalencies.obtenirPolivalenciaDowId(u.getDowID());
        serveiPolivalencies.eliminarPolivalencia(p.getIDpolivalencias());
        serveiUsuarios.eliminarUsuario(u.getDowID());
        return "/index?faces-redirect=true";
    }

    /**
     * función que devuelve una lista de todos los usuarios de la BD
     *
     * @return lista de usuarios
     */
    public List<Usuarios> llistarUsuarios() {
        return serveiUsuarios.llistarUsuarios();
    }

    /**
     * función que devuelve una lista de todos los usarios de la BD ordenados
     * alfabéticamente.
     *
     * @return lista de usuarios
     */
    public List<Usuarios> llistarUsuariosAsc() {
        return serveiUsuarios.llistarUsuariosAsc();
    }

    /**
     * función para determinar los años de antiguedad que lleva un usuario en la
     * empresa pasandole por parámetro su año de incorporación
     *
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
     * función que cambia la lista de departamentos en el formulario de
     * inserción dependiendo de la planta que recibe por parametro
     *
     * @param planta String que identifica la planta
     * @return String que identifica al departamento
     */
    public List<String> departaments(String planta) {
        List<String> departament = new ArrayList<>();
        if (planta.equals("Cracker")) {

            departament.add("LHC Tarragona Operations");
            departament.add("Octene Tarragona Operations");
            return departament;
        } else if (planta.equals("Octeno")) {
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
     *
     * @return nueva fecha formateada
     */
    public String fechaInc() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fechaInc = df.format(usuariActual.getFechaIncorporacion());

        return fechaInc;
    }

    /**
     * Función que devuelve un número en función del rol de cada usuario
     *
     * @return número que determina el rol de cada usuario
     */
    public int renderRole() {
//        Map<String, Object> cookies = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
//        Cookie cookie = (Cookie) cookies.get("dowid");
//        String dowid = cookie.getValue();
//        Usuarios usuari = serveiUsuarios.obtenirUsuariDowId(dowid);
        String role = "su";

        switch (role) {
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
