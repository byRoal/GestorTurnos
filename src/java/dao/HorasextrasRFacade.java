/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domini.HorasextrasR;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class HorasextrasRFacade extends AbstractFacade<HorasextrasR> implements Serializable{

    @PersistenceContext(unitName = "GestorTurnosPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorasextrasRFacade() {
        super(HorasextrasR.class);
    }
    
}
