/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.BajasPermisosFacade;
import domini.BajasPermisos;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class BajasPermisosServei implements Serializable{
    @Inject
    private BajasPermisosFacade bajasPermisosDao;

    @Transactional
    public void inserirBajasPermiso(BajasPermisos entity) {
        bajasPermisosDao.create(entity);
    }

    @Transactional
    public void modificarBajasPermiso(BajasPermisos entity) {
        bajasPermisosDao.edit(entity);
    }

    @Transactional
    public void eliminarBajasPermiso(Object id) {
        bajasPermisosDao.remove(bajasPermisosDao.find(id));
    }

    @Transactional
    public BajasPermisos obtenirBajasPermiso(Object id) {
        return bajasPermisosDao.find(id);
    }

    @Transactional
    public List<BajasPermisos> llistarBajasPermisos() {
        return bajasPermisosDao.findAll();
    }
    
    
}
