/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryansPC
 */
import javax.swing.*;

public class transactions extends javax.swing.JFrame {

    /**
     * Creates new form T
     */
    public transactions() {
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

        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        TextFieldAccountNumber3 = new javax.swing.JTextField();

        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Print Previous Deposits/Income");

        jButton5.setText("print Transactions");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        TextFieldAccountNumber3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldAccountNumber3.setText("Enter Account Number");
        TextFieldAccountNumber3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldAccountNumber3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldAccountNumber3FocusLost(evt);
            }
        });
        TextFieldAccountNumber3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldAccountNumber3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(TextFieldAccountNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(TextFieldAccountNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        if (AccountListApp.Accounts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no Accounts on the system", "INVALID ACCOUNT NUMBER", JOptionPane.WARNING_MESSAGE);
        } else if (AccountListApp.checkAccount(TextFieldAccountNumber3.getText())) {
            String titleBar = TextFieldAccountNumber3.getText() + " Incoming Payments ";
            String infoMessage = AccountListApp.printAllTransactions2(TextFieldAccountNumber3.getText());

            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "There are no Accounts matching the Account number you have entered\n Try Again. ", "INVALID ACCOUNT NUMBER", JOptionPane.WARNING_MESSAGE);
        }
        resetAllTextFields();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TextFieldAccountNumber3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldAccountNumber3FocusGained
        // TODO add your handling code here:
        if (TextFieldAccountNumber3.getText().equals("Enter Account Number")) {
            TextFieldAccountNumber3.setText("");
        }
    }//GEN-LAST:event_TextFieldAccountNumber3FocusGained

    private void TextFieldAccountNumber3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldAccountNumber3FocusLost
        // TODO add your handling code here:
        if (TextFieldAccountNumber3.getText().equals("")) {
            TextFieldAccountNumber3.setText("Enter Account Number");
        }
    }//GEN-LAST:event_TextFieldAccountNumber3FocusLost

    private void TextFieldAccountNumber3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldAccountNumber3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldAccountNumber3ActionPerformed

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
            java.util.logging.Logger.getLogger(transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transactions().setVisible(true);
            }
        });
    }

    //resets the text fields so later use
    public void resetAllTextFields() {

        TextFieldAccountNumber3.setText("Enter Account Number");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFieldAccountNumber3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
