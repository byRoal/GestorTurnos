/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.PolivalenciasFacade;
import domini.Polivalencias;
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
public class PolivalenciasServei implements Serializable{
    @Inject
    private PolivalenciasFacade polivalenciasDao;

    @Transactional
    public void inserirPolivalencia(Polivalencias entity) {
        polivalenciasDao.create(entity);
    }

    public void modificarPolivalencia(Polivalencias entity) {
        polivalenciasDao.edit(entity);
    }

    public void eliminarPolivalencia(String dowId) {
        polivalenciasDao.remove(polivalenciasDao.find(dowId));
    }

    public Polivalencias obtenirPolivalencia(String dowId) {
        return polivalenciasDao.find(dowId);
    }

    public List<Polivalencias> llistarPolivalencia() {
        return polivalenciasDao.findAll();
    }
}
