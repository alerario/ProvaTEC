/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.entity.Categoria;
import br.data.entity.Fornecedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alexandrelerario
 */
@ManagedBean
@RequestScoped
public class JsfProduto {

    /**
     * Creates a new instance of JsfProduto
     */
    private int idproduto;
    private String descricao;
    private int categoria;
    private int fornecedores[];

    public int[] getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(int[] fornecedores) {
        this.fornecedores = fornecedores;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public JsfProduto() {

    }

    public void persist() {
        br.data.entity.Produto prod = new br.data.entity.Produto();
        prod.setIdproduto(idproduto);
        prod.setDescricao(descricao);
        prod.setCategoria(new br.data.crud.CrudCategoria().find(categoria));
        java.util.ArrayList<br.data.entity.Fornecedor> lforn = new java.util.ArrayList<>();
        for (int codforn : fornecedores) {
            lforn.add(new br.data.crud.CrudFornecedor().find(codforn));
        }
        prod.setFornecedorCollection(lforn);
        new br.data.crud.CrudProduto().persist(prod);
        this.idproduto = 0;
        this.descricao = "";
        this.categoria = 0;
    }

    public void remove(br.data.entity.Produto produto) {
        new br.data.crud.CrudProduto().remove(produto);
    }

    public java.util.Collection<br.data.entity.Produto> getAll() {
        return new br.data.crud.CrudProduto().getAll();
    }

    public String update(br.data.entity.Produto produto) {
        this.idproduto = produto.getIdproduto();
        this.descricao = produto.getDescricao();
        if (produto.getCategoria() != null) {
            this.setCategoria(produto.getCategoria().getIdcategoria());
        }
        this.fornecedores = new int[produto.getFornecedorCollection().size()];        
        int i = 0;
        for (Fornecedor forns : produto.getFornecedorCollection()) {
            this.fornecedores[i++] = forns.getIdfornecedor();            
        }        
        return "merge.xhtml";
    }

    public void merge() {
        br.data.entity.Produto teste;
        teste = new br.data.crud.CrudProduto().find(this.idproduto);
        teste.setDescricao(this.descricao);
        teste.setCategoria(new br.data.crud.CrudCategoria().find(categoria));
        java.util.ArrayList<br.data.entity.Fornecedor> lforn = new java.util.ArrayList<>();
        for (int codforn : fornecedores) {
            lforn.add(new br.data.crud.CrudFornecedor().find(codforn));
        }
        teste.setFornecedorCollection(lforn);
        new br.data.crud.CrudProduto().merge(teste);
        this.descricao = "";
        this.idproduto = 0;
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

    public java.util.Collection<br.data.entity.Produto> getSelect(){
            return new br.data.crud.CrudProduto().SelectByDescricao(this.descricao);
    }
}
