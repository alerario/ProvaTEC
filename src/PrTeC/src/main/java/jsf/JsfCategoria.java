/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import br.data.entity.Categoria;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author alexandrelerario
 */
@ManagedBean
@RequestScoped
public class JsfCategoria {

    /**
     * Creates a new instance of JsfProduto
     */
    private int idcategoria;
    private String descricao;
   
        
    public JsfCategoria(){
    }
    
    
      
    public void persist(){
       br.data.entity.Categoria cat = new br.data.entity.Categoria();
       cat.setIdcategoria(idcategoria);
       cat.setDescricao(descricao);
       new br.data.crud.CrudCategoria().persist(cat);
       this.idcategoria=0;
        
    }
    
    public void remove(br.data.entity.Produto categoria){
        new br.data.crud.CrudProduto().remove(categoria);
    }
    
    public java.util.Collection<br.data.entity.Categoria> getAll(){
        return new br.data.crud.CrudCategoria().getAll();
    }

    public String update(br.data.entity.Produto categoria){
        return "merge.xhtml";
    }
    
    public void merge(){
        br.data.entity.Produto teste;
        teste = new br.data.crud.CrudProduto().find(this.idcategoria);
        teste.setDescricao(this.descricao);
        new br.data.crud.CrudProduto().merge(teste);
         this.idcategoria=0;  
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
        
}
