/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.PolivalenciasFacade;
import domini.Polivalencias;
import domini.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.ejb.TransactionAttribute;
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
public class PolivalenciasServei implements Serializable{
    @Inject
    private PolivalenciasFacade polivalenciasDao;

    @Transactional
    public void inserirPolivalencia(Polivalencias entity) {
        polivalenciasDao.create(entity);
    }

    @Transactional
    public void modificarPolivalencia(Polivalencias entity) {
        polivalenciasDao.edit(entity);
    }

    @Transactional
    public void eliminarPolivalencia(Object id) {
        polivalenciasDao.remove(polivalenciasDao.find(id));
    }

    @Transactional
    public Polivalencias obtenirPolivalencia(Object id) {
        return polivalenciasDao.find(id);
    }

    @Transactional
    public List<Polivalencias> llistarPolivalencia() {
        return polivalenciasDao.findAll();
    }
  
    @TransactionAttribute
    public List<Polivalencias> obtenirPolivalenciaDowId(Object id){
        return  polivalenciasDao.findByDowID(id);
    }
}
