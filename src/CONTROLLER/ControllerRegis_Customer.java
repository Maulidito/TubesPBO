/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Customer;
import View.Registrasi_Customer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Maulidito
 */
public class ControllerRegis_Customer implements ActionListener{
    private Registrasi_Customer View;
    private Database db;
    private boolean idCustomer;
    private Customer C;
    
    
    public ControllerRegis_Customer() {
        View = new Registrasi_Customer();
        View.setVisible(true);
        View.addActionListener(this);
        
    }
      public ControllerRegis_Customer(String Cus) {
        View  = new Registrasi_Customer();
        db = new Database();
        View.setVisible(true);
        View.addActionListener(this);
        idCustomer = true;
        C = db.searchidCustomer(Cus);

        View.setjTNama(C.getNama());
        View.setjTAlamat(C.getAlamat());
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = LocalDate.parse(C.getTgl_lahir(), formatter).format(formatter2);
        View.setjFtgl_lahir(date);
        View.setjLIdcustomer(C.getIdcust());
    }

    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        db = new Database();
        if (View.getjBDone().equals(source)){
            if (idCustomer){
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                 DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                 String date = LocalDate.parse(View.getjFtgl_lahir(), formatter).format(formatter2);
                 Customer a = new Customer(View.getjTNama(), View.getButtonGroup1(),date, View.getjTAlamat());
                 a.setID(View.getjLIdcustomer());
                 db.updateCustomer(a);
                 View.setVisible(false);
                 new ControllerAdmin_Customer();
            
            }else{
                System.out.println(View.getjTNama());
                System.out.println(db.cekDuplikatnamaCustomer(View.getjTNama()));
                 if(!db.cekDuplikatnamaCustomer(View.getjTNama())){
                    try{
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String date = LocalDate.parse(View.getjFtgl_lahir(), formatter).format(formatter2);
                    Customer a = new Customer(View.getjTNama(), View.getButtonGroup1(),date, View.getjTAlamat());
                    a.setIdcust(db.LastidCustomer());
                        System.out.println("INI"+a.getIdcust());
                    db.addCustomer(a);
                    View.setVisible(false);
                    new ControllerAdmin_Customer();
                    }catch (DateTimeParseException e){
                        JOptionPane.showMessageDialog(View, e);
                    }         
            
            }
        }
    }else if (View.getjBCancel().equals(source)){
            View.setVisible(false);
            new ControllerAdmin();
    }
    
    
}
}
