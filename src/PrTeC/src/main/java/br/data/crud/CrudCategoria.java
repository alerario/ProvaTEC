/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Admin
 */
public class CrudCategoria extends AbstractCrud<br.data.entity.Categoria> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudCategoria() {
        super(Categoria.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }
}
    
     
