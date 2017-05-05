/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domini.Usuarios;
import java.io.Serializable;
import java.util.List;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> implements Serializable{

    @PersistenceContext(unitName = "GestorTurnosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Object findByDowID(Object dowID){
        return getEntityManager().createNamedQuery("Usuarios.findByDowID").setParameter("dowID", dowID ).getSingleResult();
    }
    
    public List<Usuarios> findAllAsc(){
        return getEntityManager().createNamedQuery("Usuarios.findAllAsc").getResultList();
    }
    
}
