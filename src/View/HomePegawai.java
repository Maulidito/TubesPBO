/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ASUS
 */
public class HomePegawai extends javax.swing.JFrame {

    /**
     * Creates new form HomePegawai
     */
    public HomePegawai() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        cucianPelanggan = new javax.swing.JButton();
        transaksiPegawai = new javax.swing.JButton();
        jBLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
        jLabel1.setText("WELCOME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 13, -1, -1));

        labelUsername.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
        labelUsername.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 13, 300, 41));

        cucianPelanggan.setText("Cucian Pelanggan");
        getContentPane().add(cucianPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 130, 200, 228));

        transaksiPegawai.setText("Transaksi");
        transaksiPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiPegawaiActionPerformed(evt);
            }
        });
        getContentPane().add(transaksiPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 130, 200, 230));

        jBLogout.setText("Log Out");
        jBLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jBLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2);
        jPanel2.setBounds(100, 10, 510, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Desktop\\pic\\LAUNDROMATTTT.jpg")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 700, 410);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transaksiPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiPegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transaksiPegawaiActionPerformed

    private void jBLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBLogoutActionPerformed

    
    public JButton getCucianPelanggan() {
        return cucianPelanggan;
    }

    public JButton getTransaksiPegawai() {
        return transaksiPegawai;
    }

    public JButton getjBLogout() {
        return jBLogout;
    }

  
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cucianPelanggan;
    private javax.swing.JButton jBLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JButton transaksiPegawai;
    // End of variables declaration//GEN-END:variables

    public void setLabelUsername(String labelUsername) {
        this.labelUsername.setText(labelUsername);
    }
    
    public void addActionListener(ActionListener e){
        cucianPelanggan.addActionListener(e);
        transaksiPegawai.addActionListener(e);
        jBLogout.addActionListener(e);
    }
}
