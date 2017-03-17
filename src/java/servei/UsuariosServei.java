/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.UsuariosFacade;
import domini.Usuarios;
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
public class UsuariosServei implements Serializable{
    @Inject
    private UsuariosFacade usuariosDao;

    @Transactional
    public void inserirUsuario(Usuarios entity) {
        usuariosDao.create(entity);
    }

    @Transactional
    public void modificarUsuario(Usuarios entity) {
        usuariosDao.edit(entity);
    }

    @Transactional
    public void eliminarUsuario(Object id) {
        usuariosDao.remove(usuariosDao.find(id));
    }

    @Transactional
    public Usuarios obtenirUsuario(Object id) {
        return usuariosDao.find(id);
    }

    @Transactional
    public List<Usuarios> llistarUsuarios() {
        return usuariosDao.findAll();
    }
}
