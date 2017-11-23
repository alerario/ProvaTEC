/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Produto;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author alexandrelerario
 */
public class CrudProduto extends AbstractCrud<br.data.entity.Produto> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudProduto() {
        super(Produto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }

    public Collection<Produto> SelectByDescricao(String descricao) {
       try {
            return getEntityManager().createNamedQuery("Produto.findByDescricao").setParameter("descricao", "%" + descricao.toUpperCase() + "%").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    
    }

}
