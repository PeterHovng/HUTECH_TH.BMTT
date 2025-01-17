/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package week_03;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class frm_RSA_AES extends javax.swing.JFrame {
    private RSA_AES_Cipher rsaCipher;
    public frm_RSA_AES() {
        initComponents();
        try {
            rsaCipher = new RSA_AES_Cipher();
        } catch(Exception ex){
            Logger.getLogger(frm_RSA_AES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_privatekey = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_plaintext = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ciphertext = new javax.swing.JTextArea();
        btn_generatekeys = new javax.swing.JButton();
        btn_loadkeys = new javax.swing.JButton();
        btn_encrypt = new javax.swing.JButton();
        btn_decrypt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_publickey = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_plaintext.setColumns(20);
        txt_plaintext.setRows(5);
        jScrollPane1.setViewportView(txt_plaintext);

        txt_ciphertext.setColumns(20);
        txt_ciphertext.setRows(5);
        jScrollPane2.setViewportView(txt_ciphertext);

        btn_generatekeys.setText("Generate Keys");
        btn_generatekeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generatekeysActionPerformed(evt);
            }
        });

        btn_loadkeys.setText("Load Keys");
        btn_loadkeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadkeysActionPerformed(evt);
            }
        });

        btn_encrypt.setText("Encrypt");
        btn_encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_encryptActionPerformed(evt);
            }
        });

        btn_decrypt.setText("Decrypt");
        btn_decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_decryptActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Plaintext:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("RSA-AES Cipher Demo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Public Key:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("PrivateKey:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ciphertext:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_publickey, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_privatekey)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btn_generatekeys)
                                .addGap(41, 41, 41)
                                .addComponent(btn_loadkeys)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(btn_encrypt)
                                .addGap(47, 47, 47)
                                .addComponent(btn_decrypt)
                                .addGap(21, 21, 21)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_publickey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_privatekey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_generatekeys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_loadkeys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_encrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_decrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String readFile(File file) throws IOException{
        StringBuilder contentBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader ( new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString();
    }
    private void btn_generatekeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generatekeysActionPerformed
        try {
            rsaCipher = new RSA_AES_Cipher();
            txt_publickey.setText(rsaCipher.getPublicKey().toString());
            txt_privatekey.setText(rsaCipher.getPrivateKey().toString());

            JFileChooser publicKeyChooser = new JFileChooser();
            publicKeyChooser.setDialogTitle("Save Public Key File");
            int publicKeyChooserResult = publicKeyChooser.showSaveDialog(this);
            if(publicKeyChooserResult == JFileChooser.APPROVE_OPTION){
                File publicKeyFile = publicKeyChooser.getSelectedFile();
                try(FileWriter writer = new FileWriter(publicKeyFile.getAbsolutePath())){
                    writer.write(rsaCipher.getPublicKey().toString());
                    JOptionPane.showMessageDialog(this, "Public Key saved to file successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch(IOException ex){
                    JOptionPane.showMessageDialog(this, "Error saving Public Key file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            JFileChooser privateKeyChooser = new JFileChooser();
            privateKeyChooser.setDialogTitle("Save Private Key File");
            int privateKeyChooserResult = privateKeyChooser.showSaveDialog(this);
            if(privateKeyChooserResult == JFileChooser.APPROVE_OPTION){
                File privateKeyFile = privateKeyChooser.getSelectedFile();
                try(FileWriter writer = new FileWriter(privateKeyFile.getAbsolutePath())){
                    writer.write(rsaCipher.getPrivateKey().toString());
                    JOptionPane.showMessageDialog(this, "Private Key saved to file successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch(IOException ex){
                    JOptionPane.showMessageDialog(this, "Error saving Private Key file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch(Exception ex){
            Logger.getLogger(frm_RSA_AES.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error generating RSA key pair: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_generatekeysActionPerformed

    private void btn_loadkeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadkeysActionPerformed
        try {
            JFileChooser publicKeyChooser = new JFileChooser();
            publicKeyChooser.setDialogTitle("Load Public Key File");
            int publicKeyChooserResult = publicKeyChooser.showOpenDialog(this);
            if(publicKeyChooserResult == JFileChooser.APPROVE_OPTION){
                File publicKeyFile = publicKeyChooser.getSelectedFile();
                String publicKeyContent = readFile(publicKeyFile);
                txt_publickey.setText(publicKeyContent);
            }

            JFileChooser privateKeyChooser = new JFileChooser();
            privateKeyChooser.setDialogTitle("Load Private Key File");
            int privateKeyChooserResult = privateKeyChooser.showOpenDialog(this);
            if(privateKeyChooserResult == JFileChooser.APPROVE_OPTION){
                File privateKeyFile = privateKeyChooser.getSelectedFile();
                String privateKeyContent = readFile(privateKeyFile);
                txt_privatekey.setText(privateKeyContent);
            }
        } catch(HeadlessException | IOException ex){
            Logger.getLogger(frm_RSA_AES.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading keys: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_loadkeysActionPerformed

    private void btn_encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encryptActionPerformed
        try{
            String plaintext = txt_plaintext.getText();
            byte[] ciphertedBytes = rsaCipher.encrypt(plaintext);

            String encryptedText = new String(ciphertedBytes, StandardCharsets.ISO_8859_1);
            txt_ciphertext.setText(encryptedText);
        } catch(IllegalBlockSizeException | BadPaddingException ex){
            Logger.getLogger(frm_RSA_AES.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error encrypting: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch(Exception ex){
            Logger.getLogger(frm_RSA_AES.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error encrypting: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_encryptActionPerformed

    private void btn_decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_decryptActionPerformed
        try{
            byte[] combined = txt_ciphertext.getText().getBytes(StandardCharsets.ISO_8859_1);
            String decryptedText = rsaCipher.decrypt(combined);
            txt_plaintext.setText(decryptedText);
        } catch(IllegalBlockSizeException | BadPaddingException ex){
            Logger.getLogger(frm_RSA_AES.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error decrypting: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch(Exception ex){
            Logger.getLogger(frm_RSA_AES.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error decrypting: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_decryptActionPerformed

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
            java.util.logging.Logger.getLogger(frm_RSA_AES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_RSA_AES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_RSA_AES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_RSA_AES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_RSA_AES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_decrypt;
    private javax.swing.JButton btn_encrypt;
    private javax.swing.JButton btn_generatekeys;
    private javax.swing.JButton btn_loadkeys;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt_ciphertext;
    private javax.swing.JTextArea txt_plaintext;
    private javax.swing.JTextField txt_privatekey;
    private javax.swing.JTextField txt_publickey;
    // End of variables declaration//GEN-END:variables
}
