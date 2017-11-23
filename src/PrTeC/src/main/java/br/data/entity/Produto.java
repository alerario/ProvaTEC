/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto")
    , @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE UPPER(p.descricao) LIKE :descricao")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduto")
    private Integer idproduto;
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "produtoCollection")
    private Collection<Fornecedor> fornecedorCollection;
    @JoinColumn(name = "categoria", referencedColumnName = "idcategoria")
    @ManyToOne
    private Categoria categoria;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
