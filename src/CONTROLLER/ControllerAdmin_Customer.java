/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Customer;
import View.Admin_Customer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author Maulidito
 */
public class ControllerAdmin_Customer implements ActionListener{
    

    private Admin_Customer View;
    private Database db;
    private JTable table;
    int i;
    String idCust;
    public ControllerAdmin_Customer() {
        View = new Admin_Customer();
        View.setVisible(true);
        View.addActionListener(this);
        db = new Database();
        table = View.getjTable1();
        for (Customer p : db.getCustomer()){
            System.out.println("INI mASALAH"+ p.getIdcust());
            table.setValueAt(p.getIdcust(), i, 0);
            table.setValueAt(p.getNama(), i, 1);
            table.setValueAt(p.getKelamin(), i, 2);
            table.setValueAt(p.getTgl_lahir(), i, 3);
            table.setValueAt(p.getAlamat(), i, 4);
            i++;
        }
        
      
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
            View.setVisible(false);
        if (View.getjBCreate().equals(source)){

            new ControllerRegis_Customer();
        
        }else if (View.getjBDelete().equals(source)){
            int selectedrow = table.getSelectedRow();
            String idselectedrow = (String) table.getValueAt(selectedrow, 0);   
            db.delCustomer(idselectedrow);
            table.removeRowSelectionInterval(selectedrow, selectedrow);
            new ControllerAdmin_Customer();
                  
        }else if (View.getjBUpdate().equals(source)){
            int selectedrow = table.getSelectedRow();
            String idselectedrow = (String) table.getValueAt(selectedrow, 0);
            new ControllerRegis_Customer(idselectedrow);
            
        
        }else if (View.getjBKembali().equals(source)){
            new ControllerAdmin();
        }
    }
    
    
}
