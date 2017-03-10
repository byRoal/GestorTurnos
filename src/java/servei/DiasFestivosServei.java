/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.DiasfestivosFacade;
import domini.Diasfestivos;
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
public class DiasFestivosServei implements Serializable{
    @Inject
    private DiasfestivosFacade diasfestivosDao;
    
    @Transactional
    public void inserirDiaFestivo(Diasfestivos entity) {
        diasfestivosDao.create(entity);
    }

    @Transactional
    public void modificarDiaFestivo(Diasfestivos entity) {
        diasfestivosDao.edit(entity);
    }

    @Transactional
    public void eliminarDiaFestivo(int id) {
        diasfestivosDao.remove(diasfestivosDao.find(id));
    }

    @Transactional
    public Diasfestivos obtenirDiaFestivo(int id) {
        return diasfestivosDao.find(id);
    }

    @Transactional
    public List<Diasfestivos> llistarDiasFestivos() {
        return diasfestivosDao.findAll();
    }
    
}
