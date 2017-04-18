/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.AdminFacade;
import domini.Admin;
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
public class AdminServei implements Serializable{
    @Inject
    private AdminFacade adminDao;

    @Transactional
    public void inserirAdmin(Admin entity) {
        adminDao.create(entity);
    }

    @Transactional
    public void modificarAdmin(Admin entity) {
        adminDao.edit(entity);
    }

    @Transactional
    public void eliminarAdmin(String dowId) {
        adminDao.remove(adminDao.find(dowId));
    }

    @Transactional
    public Admin obtenirAdmin(String dowId) {
        return adminDao.find(dowId);
    }

    @Transactional
    public List<Admin> llistarAdmins() {
        return adminDao.findAll();
    }
    
    
    
}
