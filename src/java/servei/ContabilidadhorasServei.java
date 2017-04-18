/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import dao.ContabilidadhorasFacade;
import domini.Contabilidadhoras;
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
public class ContabilidadhorasServei implements Serializable{
    @Inject
    private ContabilidadhorasFacade contabilidadhorasDao;

    @Transactional
    public void inserirContabilidadhoras(Contabilidadhoras entity) {
        contabilidadhorasDao.create(entity);
    }

    @Transactional
    public void modificarContabilidadhoras(Contabilidadhoras entity) {
        contabilidadhorasDao.edit(entity);
    }

    @Transactional
    public void eliminarContabilidadhoras(Object dowId) {
        contabilidadhorasDao.remove(contabilidadhorasDao.find(dowId));
    }

    @Transactional
    public Contabilidadhoras obtenirContabilidadhoras(Object dowId) {
        return contabilidadhorasDao.find(dowId);
    }

    @Transactional
    public List<Contabilidadhoras> llistarContabilidadhoras() {
        return contabilidadhorasDao.findAll();
    }
    
    
}
