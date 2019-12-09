/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import View.UIMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Maulidito
 */
public class ControllerUIMain implements ActionListener{
    private UIMain View;

    public ControllerUIMain() {
        View = new UIMain();
        View.setVisible(true);
        View.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        View.setVisible(false);
        if (View.getCustomer().equals(source)){
          new ControllerTransaksi();
        }else if (View.getPegawaiKantor().equals(source)){
        
            new ControllerPegawai();
        }else if (View.getADMIN().equals(source)){
            new ControllerAdmin();
        }
           
        
    }
    
    
    
    
    
}
