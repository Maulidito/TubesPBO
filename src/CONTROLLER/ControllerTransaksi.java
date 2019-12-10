/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Pegawai;
import MODEL.TransaksiM;
import View.Transaksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.xml.transform.Source;

/**
 *
 * @author Maulidito
 */
public class ControllerTransaksi implements  ActionListener{
    private Database db;
    private Pegawai pegawai;
    private Transaksi View;
    private JTable table;
    int i =0;
    public ControllerTransaksi(Pegawai pegawai) {
        db = new Database();
        View = new Transaksi();
        this.pegawai = pegawai;
        View.setVisible(true);
        View.AddActionListener(this);
        table = View.getJTTransaksi();
        
        for (TransaksiM T : db.getTransaksi()){
            if (T.getPegTerima().getIdpeg().equals(this.pegawai.getIdpeg())){
                table.setValueAt(T.getTransaksiId(), i, 0);
                table.setValueAt(T.getCustomer().getNama(), i, 1);
                table.setValueAt(T.getTotalsatuTransaksi(0)/5000, i, 2);
                table.setValueAt(T.getTotalsatuTransaksi(1)/25000, i, 3);
                table.setValueAt(T.getTotalHarga(T), i, 4);
                i++;
                }
        }
        
        
    }

    public ControllerTransaksi() {
        db = new Database();
        View = new Transaksi();
        this.pegawai = pegawai;
        View.setVisible(true);
        View.AddActionListener(this);
        table = View.getJTTransaksi();
        
        for (TransaksiM T : db.getTransaksi()){
                table.setValueAt(T.getTransaksiId(), i, 0);
                table.setValueAt(T.getCustomer().getNama(), i, 1);
                table.setValueAt(T.getTotalsatuTransaksi(0)/5000, i, 2);
                table.setValueAt(T.getTotalsatuTransaksi(1)/25000, i, 3);
                table.setValueAt(T.getTotalHarga(T), i, 4);
                i++;
                }
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (View.getKembali().equals(source)){
            View.setVisible(false);
            if(pegawai != null){
                new ControllerHomePegawai(pegawai);
            }else{
            System.out.println("INI BENER");
                new ControllerUIMain();
            }
            }
    }
}
    

 
    
    

