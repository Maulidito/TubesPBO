/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Pegawai;
import View.Registrasi_Pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;


/**
 *
 * @author Maulidito
 */
public class ControllerRegis_Pegawai implements ActionListener{
    private Registrasi_Pegawai View;
    private Database db;
    private boolean idPegawai = false;
    private Pegawai P;
    
    public ControllerRegis_Pegawai() {
        View  = new Registrasi_Pegawai();
        View.setVisible(true);
        View.addActionListener(this);

        
    }

    public ControllerRegis_Pegawai(String Peg) {
        View  = new Registrasi_Pegawai();
        db = new Database();
        View.setVisible(true);
        View.addActionListener(this);
        idPegawai = true;
        P = db.searchidPegawai(Peg);
        View.setjTNama(P.getNama());
        View.setjPpass(P.getPassword());
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = LocalDate.parse(P.getTgl_lahir(), formatter).format(formatter2);
        View.setjFtgl_lahir(date);
        View.setjLIdpeg(Peg);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (View.getjBDone().equals(source)){
            db = new Database();
            if (idPegawai){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String date = LocalDate.parse(View.getjFtgl_lahir(), formatter).format(formatter2);
                    Pegawai a = new Pegawai(View.getjTNama(), View.getButtonGroup1(),date, "", View.getjPpass());
                    a.setIdpeg(View.getjLIdpeg());
                    db.updatePegawai(a);
                    View.setVisible(false);
                    new ControllerAdmin_Pegawai();
            }else{
                if(!db.cekDuplikatnamaPegawai(View.getjTNama())){
                    try{
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String date = LocalDate.parse(View.getjFtgl_lahir(), formatter).format(formatter2);
                    Pegawai a = new Pegawai(View.getjTNama(), View.getButtonGroup1(),date, "", View.getjPpass());
                    a.setID(db.LastidPegawai());
                    db.addPegawai(a);
                    View.setVisible(false);
                    new ControllerAdmin_Pegawai();
                    }catch (DateTimeParseException e){
                        JOptionPane.showMessageDialog(View, e);
                    }         


                }else{
                    JOptionPane.showMessageDialog(View, "Gunakan Nama Yang Lain");
            }
            }
            
        }else if (View.getjBCancel().equals(source)){
            View.setVisible(false);
            new ControllerAdmin();
        
        }
    }
    
}
