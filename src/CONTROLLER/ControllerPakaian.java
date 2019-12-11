/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Customer;
import MODEL.Pegawai;
import MODEL.TransaksiM;
import View.Pakaian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Maulidito
 */
public class ControllerPakaian implements ActionListener{
    private Pakaian View;
    private Database db;
    private JComboBox J;
    private String selectedC,selectedP;
    private Pegawai pegawai;
    private JButton proses;
    private JRadioButton R_siap,R_prosse;
    String idTransaksi;
    private boolean transaksi,loginadmin = false;
    
    public ControllerPakaian(Pegawai pegawai, boolean loginadmin) {
        db = new Database();
        View = new Pakaian();
        J = new JComboBox();
        View.setVisible(true);
        this.loginadmin = loginadmin;
        View.getjLTransaksi().setVisible(false);
        View.getjCPegawai().setVisible(false);
        View.getjRSiap().setVisible(false);
        View.getjRProses().setVisible(false);
        this.pegawai = pegawai;
        View.addActionListener(this);
        for (Customer C : db.getCustomer()){
           View.setjCCustomer(C.getNama());
        }
        
        
        
    }

    public ControllerPakaian(TransaksiM T) {  
        db = new Database();
        View = new Pakaian();
        J = new JComboBox();
        View.setVisible(true);
        R_prosse = View.getjRProses();
        R_siap = View.getjRSiap();
        transaksi = true;
        loginadmin = true;
        for (Pegawai P : db.getPegawai()){
            View.setjCPegawai(P.getNama());
        }
        for (Customer C : db.getCustomer()){
           View.setjCCustomer(C.getNama());
        }
        this.idTransaksi = T.getTransaksiId();
        View.getjCPegawai().setSelectedItem(T.getPegTerima().getNama());
        View.getjCCustomer().setSelectedItem(T.getCustomer().getNama());
        View.getjCPegawai().setVisible(true);
        View.getjLTransaksi().setVisible(true);
        View.setjLTransaksi("Akan Melakukan Update dari Pegawai"+T.getPegTerima().getNama());
        View.addActionListener(this);

        if (T.getStatus().equals("Proses")){
            R_prosse.setSelected(true);
          
        }else{
              System.out.println(T.getStatus());
            R_siap.setSelected(true);
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        db = new Database();
        proses = View.getProses();
        
        
        if (View.getHitung().equals(source)){
            try{
                View.setHargaPakaian(String.valueOf(Integer.parseInt(View.getJTPakaian())*5000 + Integer.parseInt(View.getJTSepatu())*25000));
                proses.setEnabled(true);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(View, e);
            }
        
        }else if (View.getKembali().equals(source)){
            View.setVisible(false);
            if (loginadmin){
                new ControllerAdmin_Transaksi();
            }else{
                new ControllerHomePegawai(pegawai);
            }
            
        }else if (View.getProses().equals(source)){
            if (!transaksi){
                selectedC = View.getjCCustomer().getSelectedItem().toString();
                System.out.println(selectedC.toString());
                View.setVisible(false);
                TransaksiM T = new TransaksiM(this.pegawai, db.searchCustomer(selectedC), Integer.parseInt(View.getPakaian()) ,Integer.parseInt(View.getSepatu()), Integer.parseInt(View.getHargaPakaian()));
                T.setID(db.LastidTransaksi());
                
                db.addTransaksi(T);
                if (loginadmin){
                    new ControllerAdmin_Transaksi();
                }else{
                    new ControllerHomePegawai(pegawai);
                }
            }else{
                selectedC = View.getjCCustomer().getSelectedItem().toString();
                selectedP = View.getjCPegawai().getSelectedItem().toString();
                System.out.println(selectedC+" "+selectedP);
                System.out.println(db.searchPegawai(selectedP).getNama()+" "+ db.searchCustomer(selectedC).getNama());
                TransaksiM T = new TransaksiM(db.searchPegawai(selectedP), db.searchCustomer(selectedC), Integer.parseInt(View.getPakaian()) ,Integer.parseInt(View.getSepatu()), Integer.parseInt(View.getHargaPakaian()));
                T.setTransaksiId(idTransaksi);
                T.setStatus(View.getButtonGroup1());
                System.out.println(T.getTransaksiId());
                db.updateTransaksi(T);
                View.setVisible(false);
                if (loginadmin){
                    new ControllerAdmin_Transaksi();
                }else{
                    new ControllerHomePegawai(pegawai);
                }
                
            }

        }
        
        }
        
    }
    
   
    
    

