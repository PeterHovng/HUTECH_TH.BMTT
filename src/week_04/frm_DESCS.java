/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package week_04;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import week_02.DESCipher;
public class frm_DESCS extends javax.swing.JFrame {
    public frm_DESCS() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_plaintext = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_key = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ciphertext = new javax.swing.JTextArea();
        btn_open_alice_key = new javax.swing.JButton();
        btn_open_bob_key = new javax.swing.JButton();
        btn_encrypt = new javax.swing.JButton();
        btn_decrypt = new javax.swing.JButton();
        btn_saveFile = new javax.swing.JButton();
        btn_openFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DES Cipher Demo (D-H)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Plaintext:");

        txt_plaintext.setColumns(20);
        txt_plaintext.setRows(5);
        jScrollPane1.setViewportView(txt_plaintext);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Key:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ciphertext:");

        txt_ciphertext.setColumns(20);
        txt_ciphertext.setRows(5);
        jScrollPane2.setViewportView(txt_ciphertext);

        btn_open_alice_key.setText("Open Alice's Key");
        btn_open_alice_key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_open_alice_keyActionPerformed(evt);
            }
        });

        btn_open_bob_key.setText("Open Bob's Key");
        btn_open_bob_key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_open_bob_keyActionPerformed(evt);
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

        btn_saveFile.setText("Save to File");
        btn_saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveFileActionPerformed(evt);
            }
        });

        btn_openFile.setText("Open File");
        btn_openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_encrypt)
                                .addGap(175, 175, 175)
                                .addComponent(btn_saveFile)
                                .addGap(56, 56, 56)
                                .addComponent(btn_openFile))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addComponent(txt_key))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(btn_decrypt)
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_open_alice_key)
                                .addGap(107, 107, 107)))
                        .addComponent(btn_open_bob_key)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_open_alice_key, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_open_bob_key))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_encrypt)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_saveFile)
                            .addComponent(btn_decrypt)
                            .addComponent(btn_openFile))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_open_alice_keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_open_alice_keyActionPerformed
        try {
            BufferedReader br = null;
            String fileName = "src/week_05/A.txt";
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();
            
            JOptionPane.showMessageDialog(null, "File Opened Successfully.");
            char[] ca = new char[5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            String chuoi = sb.toString();
            txt_key.setText(chuoi);
        } catch (IOException ex) {
            Logger.getLogger(frm_DESCS.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }//GEN-LAST:event_btn_open_alice_keyActionPerformed

    private void btn_open_bob_keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_open_bob_keyActionPerformed
        try {
           BufferedReader br = null;
           String fileName = "src/week_05/B.txt";
           br = new BufferedReader(new FileReader(fileName));
           StringBuffer sb = new StringBuffer();
           JOptionPane.showMessageDialog(null, "File Opened Successfully.");
           char[] ca = new char[5];
           while (br.ready()) {
               int len = br.read(ca);
               sb.append(ca, 0, len);
           }
           br.close();
           String chuoi = sb.toString();
           txt_key.setText(chuoi);
        } catch (IOException ex) {
            Logger.getLogger(frm_DESCS.class.getName()).log(Level.SEVERE, null, ex);          
        }
    }//GEN-LAST:event_btn_open_bob_keyActionPerformed

    private void btn_encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encryptActionPerformed
        try {
            String plaintext = txt_plaintext.getText();
            String secretKey = txt_key.getText();
            String encryptedText = DESCipher.encrypt(plaintext, secretKey);
            txt_ciphertext.setText(encryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String filePath = "D:\\2280602270_ToVanNien_buoi1\\TH_BMTT\\src\\week_05\\file.txt"; 
        String content = txt_ciphertext.getText();
        try (FileWriter writer = new FileWriter(filePath, false)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_encryptActionPerformed

    private void btn_decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_decryptActionPerformed
        String filePath = "D:\\2280602270_ToVanNien_buoi1\\TH_BMTT\\src\\week_05\\file.txt"; 
        File file = new File(filePath);
        if (file.exists()) {
            try {
                String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
                txt_ciphertext.setText(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
           String ciphertext = txt_ciphertext.getText();
           String secretKey = txt_key.getText();
           String decryptedText = DESCipher.decrypt(ciphertext, secretKey);
           txt_ciphertext.setText(decryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_decryptActionPerformed

    private void btn_saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveFileActionPerformed
        String ciphertext = txt_ciphertext.getText();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Ciphertext to File");
           int userSelection = fileChooser.showSaveDialog(this);
           if (userSelection == JFileChooser.APPROVE_OPTION){
                File fileToSave = fileChooser.getSelectedFile();
                try (FileWriter writer =
                        new FileWriter(fileToSave.getAbsolutePath() + ".txt")) {
                    writer.write(ciphertext);
                    JOptionPane.showMessageDialog(this,
                            "Ciphertext saved to file successfully.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this,
                            "Error saving file: " + e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);               
            }
        }
    }//GEN-LAST:event_btn_saveFileActionPerformed

    private void btn_openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open File containing Ciphertext");
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileToOpen))) {
                StringBuilder ciphertextBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    ciphertextBuilder.append(line);           
                }
                String ciphertext = ciphertextBuilder.toString().trim();
                txt_ciphertext.setText(ciphertext);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Error saving file: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);     
            }
        }
    }//GEN-LAST:event_btn_openFileActionPerformed

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
            java.util.logging.Logger.getLogger(frm_DESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_DESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_DESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_DESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_DESCS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_decrypt;
    private javax.swing.JButton btn_encrypt;
    private javax.swing.JButton btn_openFile;
    private javax.swing.JButton btn_open_alice_key;
    private javax.swing.JButton btn_open_bob_key;
    private javax.swing.JButton btn_saveFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt_ciphertext;
    private javax.swing.JTextField txt_key;
    private javax.swing.JTextArea txt_plaintext;
    // End of variables declaration//GEN-END:variables
}
