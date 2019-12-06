/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Customer extends Person{
    private String idcust;
    int idx;
    
    
    public Customer(String nama, String kelamin, String tgl_lahir, String alamat) {
        super(nama, kelamin, tgl_lahir, alamat);
        idcust = "001";
    }

   
    public String getIdcust() {
        return idcust;
    }

   
    public void setIdcust(String idcust) {
        this.idcust = idcust;
    }

   

    
    
}
