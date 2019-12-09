/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Pegawai;
import MODEL.TransaksiM;
import View.Admin_Transaksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Maulidito
 */
public class ControllerAdmin_Transaksi implements ActionListener{
    final private Admin_Transaksi View;
    private Database db;
    private JTable table;
    private JComboBox combobox;
    int i;
    public ControllerAdmin_Transaksi() {
        View = new Admin_Transaksi();
        View.setVisible(true);
        View.addActionListener(this);
        combobox = View.getjCPegawai();
        db = new Database();
        table = View.getJTTransaksi();
        for (Pegawai C : db.getPegawai()){
            View.setjCPegawai(C.getNama());
        }
        
        for (TransaksiM T : db.getTransaksi()){
            table.setValueAt(T.getTransaksiId(), i, 0);
            table.setValueAt(T.getPegTerima().getNama(), i, 1);
            table.setValueAt(T.getCustomer().getNama(), i, 2);
            table.setValueAt(T.getTotalsatuTransaksi(0)/5000, i, 3);
            table.setValueAt(T.getTotalsatuTransaksi(1)/25000, i, 4);
            table.setValueAt(T.getTotalHarga(T), i, 5);
            i++;
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source  = ae.getSource();
        db = new Database();
        if (View.getjBCreate().equals(source)){
            View.setVisible(false);
            new ControllerPakaian(db.searchPegawai(combobox.getSelectedItem().toString()),true);
        
        }else if (View.getjBDelete().equals(source)){
            int selected = table.getSelectedRow();
            String idselectedrow = (String) table.getValueAt(selected, 0);   
            db.delTransaksi(idselectedrow);
            table.removeRowSelectionInterval(selected, selected);
            View.setVisible(false);
            new ControllerAdmin_Transaksi();
        
        }else if (View.getjBUpdate().equals(source)){
            int selectedrow = table.getSelectedRow();
            String idselectedrow = (String) table.getValueAt(selectedrow, 0);
            View.setVisible(false);
            new ControllerPakaian(db.searchidTransaksi(idselectedrow));
            
        
        }else if (View.getjBKembali().equals(source)){
            View.setVisible(false);
            new ControllerAdmin();
        
        }
        
    }
    
    
}
