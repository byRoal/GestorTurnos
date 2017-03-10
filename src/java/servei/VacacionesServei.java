/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.VacacionesFacade;
import domini.Vacaciones;
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
public class VacacionesServei implements Serializable{
    @Inject
    private VacacionesFacade vacacionesDao;
    
    @Transactional
    public void inserirVacaciones(Vacaciones entity) {
        vacacionesDao.create(entity);
    }
    
    @Transactional
    public void modificarVacaciones(Vacaciones entity) {
        vacacionesDao.edit(entity);
    }
    
    @Transactional
    public void eliminarVacaciones(int id) {
        vacacionesDao.remove(vacacionesDao.find(id));
    }
    
    @Transactional
    public Vacaciones obtenirVacaciones(int id) {
        return vacacionesDao.find(id);
    }
    
    @Transactional
    public List<Vacaciones> llistarVacaciones() {
        return vacacionesDao.findAll();
    }
}
