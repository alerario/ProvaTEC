/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Admin
 */
@ManagedBean
@ApplicationScoped
public class JsfStatus {

    /**
     * Creates a new instance of JsfFornecedor
     */
    private int x;
    
    public JsfStatus() {
        x=0;
    }

    public int getX() {
        return x;
    }

    public void add(){
        x++;
    }
}
