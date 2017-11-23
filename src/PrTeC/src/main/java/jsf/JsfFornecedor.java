/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class JsfFornecedor {

    /**
     * Creates a new instance of JsfFornecedor
     */
    public JsfFornecedor() {
    }
    
    public java.util.Collection<br.data.entity.Fornecedor> getAll(){
        return new br.data.crud.CrudFornecedor().getAll();
    }
}
