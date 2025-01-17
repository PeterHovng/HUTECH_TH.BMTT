/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package week_04;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author USER
 */
public class frm_Bob extends javax.swing.JFrame {

    /**
     * Creates new form frm_Bob
     */
    public frm_Bob() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_bob_key_generate = new javax.swing.JButton();
        btn_alice_key_display = new javax.swing.JButton();
        btn_make_secret_key = new javax.swing.JButton();
        btn_encrypt_secret_key = new javax.swing.JButton();
        btn_encrypt_decrypt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_encrypt_shared_secret = new javax.swing.JTextField();
        txt_shared_secret = new javax.swing.JTextField();
        txt_alice_key = new javax.swing.JTextField();
        txt_bob_key = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_bob_key_generate.setText("Bob's Key Generate");
        btn_bob_key_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bob_key_generateActionPerformed(evt);
            }
        });

        btn_alice_key_display.setText("Alice's Key Display");
        btn_alice_key_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alice_key_displayActionPerformed(evt);
            }
        });

        btn_make_secret_key.setText("Make Secret Key");
        btn_make_secret_key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_make_secret_keyActionPerformed(evt);
            }
        });

        btn_encrypt_secret_key.setText("Encrypt Secret Key");
        btn_encrypt_secret_key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_encrypt_secret_keyActionPerformed(evt);
            }
        });

        btn_encrypt_decrypt.setText("Run Encrypt/Decrypt Form");
        btn_encrypt_decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_encrypt_decryptActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Bob Form (D-H)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Bob's Key:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Alice's Key:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Shared Secret:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Encrypt Shared Secret:");

        txt_encrypt_shared_secret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_encrypt_shared_secretActionPerformed(evt);
            }
        });

        txt_alice_key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alice_keyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_encrypt_shared_secret)
                                    .addComponent(txt_shared_secret)
                                    .addComponent(txt_alice_key)
                                    .addComponent(txt_bob_key, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_bob_key_generate, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(btn_alice_key_display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_make_secret_key, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_encrypt_secret_key, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btn_encrypt_decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_bob_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bob_key_generate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_alice_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_alice_key_display))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_shared_secret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_make_secret_key))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_encrypt_shared_secret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_encrypt_secret_key))
                .addGap(18, 18, 18)
                .addComponent(btn_encrypt_decrypt)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    KeyAgreement bobKeyAgree;
    PublicKey alicePubKey;
    SecretKey bobDesKey;
    Cipher bobCipher;
    
    private void btn_bob_key_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bob_key_generateActionPerformed
        try{
            boolean read = false;
            java.nio.file.Path dirPath = Paths.get("src/week_05");
            if(!java.nio.file.Files.exists(dirPath)){
                java.nio.file.Files.createDirectories(dirPath);
            }
            while(!read){
                try(FileInputStream fis = new FileInputStream(dirPath.resolve("A.pub").toFile())){
                    read = true;
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            byte[] alicePubKeyEnc;
            try(FileInputStream fis = new FileInputStream(dirPath.resolve("A.pub").toFile())){
                    alicePubKeyEnc = new byte[fis.available()];
                    fis.read(alicePubKeyEnc);
                }
            KeyFactory bobKeyFac = KeyFactory.getInstance("DH");
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(alicePubKeyEnc);
            alicePubKey = bobKeyFac.generatePublic(x509KeySpec);
            DHParameterSpec dhParamSpec = ((DHPublicKey) alicePubKey).getParams();
            KeyPairGenerator bobKpairGen = KeyPairGenerator.getInstance("DH");
            bobKpairGen.initialize(dhParamSpec);
            KeyPair bobKpair = bobKpairGen.generateKeyPair();
            bobKeyAgree= KeyAgreement.getInstance("DH");
            bobKeyAgree.init(bobKpair.getPrivate());
            byte[] bobPubKeyEnc = bobKpair.getPublic().getEncoded();
            try(FileOutputStream fos = new FileOutputStream(dirPath.resolve("B.pub").toFile())){
                fos.write(bobPubKeyEnc);
            }
            txt_bob_key.setText(java.util.Base64.getEncoder().encodeToString(bobPubKeyEnc));
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_bob_key_generateActionPerformed

    private void btn_alice_key_displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alice_key_displayActionPerformed
        try{
            byte[] bkeyP;
            try(FileInputStream fis = new FileInputStream(Paths.get("src/week_05/A.pub").toFile())){
                bkeyP = new byte[fis.available()];
                fis.read(bkeyP);
            }
            txt_alice_key.setText(bkeyP.toString());
        } catch(Exception ex){
            ex.printStackTrace();
        }     
    }//GEN-LAST:event_btn_alice_key_displayActionPerformed

    private void btn_make_secret_keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_make_secret_keyActionPerformed
        try{
            bobKeyAgree.doPhase(alicePubKey, true);
            byte[] bobSharedSecret = bobKeyAgree.generateSecret();
            txt_shared_secret.setText(CryptoUtil.toHexString(bobSharedSecret));
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_make_secret_keyActionPerformed

    private void btn_encrypt_secret_keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encrypt_secret_keyActionPerformed
        try{
            bobKeyAgree.doPhase(alicePubKey, true);
            byte[] sharedSecret = bobKeyAgree.generateSecret();
            txt_encrypt_shared_secret.setText(CryptoUtil.toHexString(sharedSecret));
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] desKeyBytes = Arrays.copyOf(sha256.digest(sharedSecret), 8);
            SecretKeySpec desKeySpec = new SecretKeySpec(desKeyBytes, "DES");
            txt_encrypt_shared_secret.setText(Base64.getEncoder().encodeToString(desKeySpec.getEncoded()));
            String fileName = "src/week_05/B.txt";
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
                bw.write(Base64.getEncoder().encodeToString(desKeySpec.getEncoded()));
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_encrypt_secret_keyActionPerformed

    private void btn_encrypt_decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encrypt_decryptActionPerformed
        frm_DESCS des = new frm_DESCS();
        des.setVisible(true);
    }//GEN-LAST:event_btn_encrypt_decryptActionPerformed

    private void txt_encrypt_shared_secretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_encrypt_shared_secretActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_encrypt_shared_secretActionPerformed

    private void txt_alice_keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alice_keyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alice_keyActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Bob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Bob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Bob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Bob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Bob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alice_key_display;
    private javax.swing.JButton btn_bob_key_generate;
    private javax.swing.JButton btn_encrypt_decrypt;
    private javax.swing.JButton btn_encrypt_secret_key;
    private javax.swing.JButton btn_make_secret_key;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_alice_key;
    private javax.swing.JTextField txt_bob_key;
    private javax.swing.JTextField txt_encrypt_shared_secret;
    private javax.swing.JTextField txt_shared_secret;
    // End of variables declaration//GEN-END:variables
}
