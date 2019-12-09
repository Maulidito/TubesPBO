/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import CONTROLLER.Database;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Customer extends Person{
    private String idcust;
 
    
    
    public Customer(String nama, String kelamin, String tgl_lahir, String alamat) {
        super(nama, kelamin, tgl_lahir, alamat);
    }

   
    public String getIdcust() {
        return idcust;
    }

   
    public void setIdcust(String idcust) {
        if (idcust.equals("")){
            this.idcust = "C001";
        }else{
            int id= Integer.valueOf(idcust.substring(1));
            id++;
            if (id<10){
                this.idcust = "C00";
            }else if (id<100){
                this.idcust = "C0";
            }else{
                this.idcust = "C";
            }
            this.idcust = this.idcust + String.valueOf(id);
            
        }
    }
    public void setID(String id){
        this.idcust = id;
    }

   

    
    
}
