/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import View.Pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
/**
 *
 * @author Maulidito
 */
public class ControllerPegawai implements ActionListener{
    private Pegawai View;
    private Database db;

    public ControllerPegawai() {
        View = new Pegawai();
        View.setVisible(true);
        View.addActionListener(this); // untuk bisa memakai addactionlistener 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(View.getLogin())){
            jBLoginActionPerformed(ae);
        }else if (source.equals(View.getKembali())){
            View.setVisible(false);
            new ControllerUIMain();
        }
    }
   
    private void jBLoginActionPerformed(java.awt.event.ActionEvent evt) { 
            db = new Database();
            String username = View.getUsername();
            String Pass = View.getPassword().toString();  
            
            if ((username.equals("ADMIN"))&&(Pass.equals("ADMIN"))){
                View.setVisible(false);
                new ControllerAdmin();
            }
            else if (db.LoginPegawai(username, Pass)){  
                View.setVisible(false);
                new ControllerHomePegawai(db.searchPegawai(username));
            }else {
                JOptionPane.showMessageDialog(View, "SALAH USENAME ATAU PASSWORD");
                View.setPassword("");
                View.setUsername("");
            }
    }
    
            
        
        
    }                           

    

    
    
    
    

