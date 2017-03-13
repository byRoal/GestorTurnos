/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import domini.Usuarios;
import dto.BajasPermisosDTO;
import dto.UsuariosDTO;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import servei.BajasPermisosServei;

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
    private UsuariosDTO usuariActual;

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
    
    private String crearBajaPermiso(String dowId, boolean baja, boolean permiso, Date dataInici, Date dataFi, int diesTotals, String comentari){
        
        return "index";
    }
}
