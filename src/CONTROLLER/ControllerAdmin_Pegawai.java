/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Pegawai;
import View.Admin_Pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Maulidito
 */
public class ControllerAdmin_Pegawai implements ActionListener{
    private Admin_Pegawai View;
    private Database db;
    private JTable table;
    int i;
    public ControllerAdmin_Pegawai() {
        View = new Admin_Pegawai();
        View.setVisible(true);
        View.AddActionListener(this);
        db = new Database();
        table = View.getjTable1();
        for (Pegawai p : db.getPegawai()){
            table.setValueAt(p.getIdpeg(), i, 0);
            table.setValueAt(p.getNama(), i, 1);
            table.setValueAt(p.getKelamin(), i, 2);
            table.setValueAt(p.getTgl_lahir(), i, 3);
            i++;
        }
        
      
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
            View.setVisible(false);
        if (View.getjBCreate().equals(source)){

            new ControllerRegis_Pegawai();
        
        }else if (View.getjBDelete().equals(source)){
                int selectedrow = table.getSelectedRow();
                String idselectedrow = (String) table.getValueAt(selectedrow, 0);   
                db.delPegawai(idselectedrow);
                table.removeRowSelectionInterval(selectedrow, selectedrow);
   
            new ControllerAdmin_Pegawai();
                  
        }else if (View.getjBUpdate().equals(source)){
            int selectedrow = table.getSelectedRow();
            String idselectedrow = (String) table.getValueAt(selectedrow, 0);
            new ControllerRegis_Pegawai(idselectedrow);
            
        
        }else if (View.getjBKembali().equals(source)){
            new ControllerAdmin();
        }
    }
    
}
