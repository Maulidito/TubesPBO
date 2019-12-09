/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import View.AksesAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Maulidito
 */
public class ControllerAdmin implements ActionListener{
    private AksesAdmin View;

    public ControllerAdmin() {
        View = new AksesAdmin();
        View.setVisible(true);
        View.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        View.setVisible(false);
        if (View.getjBCustomer().equals(source)){
            new ControllerAdmin_Customer();
        
        }else if (View.getjBPegawai().equals(source)){
            new ControllerAdmin_Pegawai();
        
        }else if (View.getjBTransaksi().equals(source)){
            new ControllerAdmin_Transaksi();
        }else if (View.getKembali().equals(source)){
            new ControllerUIMain();
        }
    }
    
    
}
