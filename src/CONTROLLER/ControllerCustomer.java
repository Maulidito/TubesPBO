/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Customer;


/**
 *
 * @author Maulidito
 */
public class ControllerCustomer {

      private static  Database db ;
    public static void main(String[] args) {
        db = new Database();
    Customer C = new Customer("bambank", "lakilaki", "2000-12-12" ,"dirumah");
        System.out.println(C.getNama()+C.getTgl_lahir()+C.getIdcust()+C.getAlamat()+C.getKelamin());
  db.addCustomer(C);

    
}
    
    
    
    
    
    
}
