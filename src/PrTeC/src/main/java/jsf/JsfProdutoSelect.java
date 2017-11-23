/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author admin
 */
@ManagedBean
@SessionScoped
public class JsfProdutoSelect  {

    /**
     * Creates a new instance of JsfProdutoSelect
     */
    public JsfProdutoSelect() {
    }
    
    private int idproduto;
    private String descricao;
    private int categoria;
    
    public java.util.Collection<br.data.entity.Produto> getSelect(){
            return new br.data.crud.CrudProduto().SelectByDescricao(this.descricao);
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
