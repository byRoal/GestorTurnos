/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.BajasPermisos;
import domini.Usuarios;
import dto.BajasPermisosDTO;
import dto.UsuariosDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import servei.BajasPermisosServei;
import servei.UsuariosServei;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class ControladorBajasPermisos implements Serializable{
    @Inject
    private BajasPermisosServei serveiBajasPermisos;
    
    @Inject
    private BajasPermisosDTO bajasPermisosActual;
    
    @Inject
    private UsuariosServei serveiUsuarios;

    public BajasPermisosServei getServeiBajasPermisos() {
        return serveiBajasPermisos;
    }

    public void setServeiBajasPermisos(BajasPermisosServei serveiBajasPermisos) {
        this.serveiBajasPermisos = serveiBajasPermisos;
    }

    public BajasPermisosDTO getBajasPermisosActual() {
        return bajasPermisosActual;
    }

    public void setBajasPermisosActual(BajasPermisosDTO bajasPermisosActual) {
        this.bajasPermisosActual = bajasPermisosActual;
    }
    
    public String prepararInsercio(){
        netejarFormulari();
        return "FormulariInsercio";
    }
    
    private void netejarFormulari(){
        bajasPermisosActual.setDowID(null);
        bajasPermisosActual.setBaja(null);
        bajasPermisosActual.setPermisos(null);
        bajasPermisosActual.setDataInicio(null);
        bajasPermisosActual.setDataFin(null);
        bajasPermisosActual.setDiasTotales(0);
        bajasPermisosActual.setComentario(null);
    }
    
    public String crearBajaPermiso(String dowId, boolean baja, boolean permiso, Date dataInici, Date dataFi, int diesTotals, String comentari){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        BajasPermisos bajaPermiso = new BajasPermisos(baja, permiso, dataInici, dataFi,diesTotals,comentari, usuari);
        serveiBajasPermisos.inserirBajasPermiso(bajaPermiso);
        return "index";
    }
    
    private void passarBajasPermisosBajasPermisosDTO(BajasPermisos b){
        bajasPermisosActual.setBaja(b.getBaja());
        bajasPermisosActual.setComentario(b.getComentario());
        bajasPermisosActual.setDataFin(b.getDataFin());
        bajasPermisosActual.setDataInicio(b.getDataInicio());
        bajasPermisosActual.setDiasTotales(b.getDiasTotales());
        bajasPermisosActual.setPermisos(b.getPermisos());
        bajasPermisosActual.setDowID(b.getDowID());
    }
    
    public String obtenirBajasPermisosConsulta(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        BajasPermisos b = serveiBajasPermisos.obtenirBajasPermiso(usuari);
        passarBajasPermisosBajasPermisosDTO(b);
        return "Consulta";
    }
    
    public String obtenirBajasPermisosModificacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        BajasPermisos b = serveiBajasPermisos.obtenirBajasPermiso(usuari);
        passarBajasPermisosBajasPermisosDTO(b);
        return "Modificacio";
    }
    
    public String obtenirBajasPermisosEliminacio(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        BajasPermisos b = serveiBajasPermisos.obtenirBajasPermiso(usuari);
        passarBajasPermisosBajasPermisosDTO(b);
        return "Eliminacio";
    }
    
    private void passarBajasPermisosDTOBajasPermisos(BajasPermisos b){
        b.setBaja(bajasPermisosActual.getBaja());
        b.setComentario(bajasPermisosActual.getComentario());
        b.setDataFin(bajasPermisosActual.getDataFin());
        b.setDataInicio(bajasPermisosActual.getDataInicio());
        b.setDiasTotales(bajasPermisosActual.getDiasTotales());
        b.setDowID(bajasPermisosActual.getDowID());
        b.setPermisos(bajasPermisosActual.getPermisos());
    } 
    
    public String modificarBajasPermisos(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        BajasPermisos b = serveiBajasPermisos.obtenirBajasPermiso(usuari);
        passarBajasPermisosDTOBajasPermisos(b);
        serveiBajasPermisos.modificarBajasPermiso(b);
        return "index";
    }
    
    public String eliminarBajasPermisos(String dowId){
        Usuarios usuari = serveiUsuarios.obtenirUsuario(dowId);
        BajasPermisos b = serveiBajasPermisos.obtenirBajasPermiso(usuari);        
        serveiBajasPermisos.eliminarBajasPermiso(b);
        return "index";
    }
    
    public List<BajasPermisos> llistarBajasPermisos(){
        return serveiBajasPermisos.llistarBajasPermisos();
    }
}
