/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.HorasextrasRFacade;
import domini.HorasextrasR;
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
public class HorasextrasRServei implements Serializable{
    @Inject
    private HorasextrasRFacade horasextrasRDao;
    
    @Transactional
    public void inserirHorasextrasR(HorasextrasR entity) {
        horasextrasRDao.create(entity);
    }
    
    @Transactional
    public void modificarHorasextrasR(HorasextrasR entity) {
        horasextrasRDao.edit(entity);
    }
    
    @Transactional
    public void eliminarHorasextrasR(int id) {
        horasextrasRDao.remove(horasextrasRDao.find(id));
    }
    
    @Transactional
    public HorasextrasR obtenirHorasextrasR(int id) {
        return horasextrasRDao.find(id);
    }
    
    @Transactional
    public List<HorasextrasR> llistarHorasextrasR() {
        return horasextrasRDao.findAll();
    }
    
    
}
