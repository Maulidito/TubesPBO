package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class UIMain extends javax.swing.JFrame {

    /**
     * Creates new form UIMain
     */
    public UIMain() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ADMIN = new javax.swing.JButton();
        pegawaiKantor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Customer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
        jLabel1.setText("LAUNDRY ANDIVA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 15, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 13, 350, 80));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ADMIN.setBackground(new java.awt.Color(0, 240, 0));
        ADMIN.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        ADMIN.setText("ADMIN");
        ADMIN.setPreferredSize(new java.awt.Dimension(100, 200));
        ADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMINActionPerformed(evt);
            }
        });
        jPanel2.add(ADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 230));

        pegawaiKantor.setBackground(new java.awt.Color(240, 0, 0));
        pegawaiKantor.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        pegawaiKantor.setText("PEGAWAI");
        pegawaiKantor.setPreferredSize(new java.awt.Dimension(100, 200));
        pegawaiKantor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegawaiKantorActionPerformed(evt);
            }
        });
        jPanel2.add(pegawaiKantor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 320, 230));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 157, 700, 250));

        jLabel2.setText("Kalian tidak boleh mencuci, karena itu adalah kewajiban kami!!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 134, -1, -1));

        Customer.setBackground(new java.awt.Color(0, 0, 240));
        Customer.setText("CUSTOMER");
        getContentPane().add(Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 13, 150, 71));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Jika anda seorang Customer, tekan CUSTOMER");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 134, -1, -1));

        jPanel4.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel3);
        jPanel3.setBounds(0, 130, 700, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Desktop\\pic\\LAUNDROMATTTT.jpg")); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(0, 0, 700, 410);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pegawaiKantorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegawaiKantorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pegawaiKantorActionPerformed

    private void ADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMINActionPerformed

    
    public JButton getADMIN() {
        return ADMIN;
    }

    public JButton getCustomer() {
        return Customer;
    }

    /**
     * @param args the command line arguments
     */
    public JButton getPegawaiKantor() {    
        return pegawaiKantor;
    }

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
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIMain().setVisible(true);
            }
        });
    }
    public void addActionListener(ActionListener e){
        ADMIN.addActionListener(e);
        Customer.addActionListener(e);
        pegawaiKantor.addActionListener(e);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADMIN;
    private javax.swing.JButton Customer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton pegawaiKantor;
    // End of variables declaration//GEN-END:variables
}
