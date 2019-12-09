/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import View.HomePegawai;
import MODEL.Pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Maulidito
 */
public class ControllerHomePegawai implements ActionListener{
    private HomePegawai View;
    private Database db;
    private Pegawai pegawai;
    
    public ControllerHomePegawai(Pegawai P) {
        View = new HomePegawai();
        View.setVisible(true);
        View.addActionListener(this);
        View.setLabelUsername(P.getNama());
        pegawai = P;
    }
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        View.setVisible(false);
        if (View.getCucianPelanggan().equals(source)){
             new ControllerPakaian(pegawai,false);
          
        }else if (View.getTransaksiPegawai().equals(source)){            
             new ControllerTransaksi(pegawai);
        
        }else if (View.getjBLogout().equals(source)){
            new ControllerUIMain();
        }
    }
    
}
