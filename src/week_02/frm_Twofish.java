package week_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class frm_Twofish extends javax.swing.JFrame {

    TwofishCipher twofish = new TwofishCipher();
    public frm_Twofish() {
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

        jLabel2 = new javax.swing.JLabel();
        btn_openFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_plaintext = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txt_key = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ciphertext = new javax.swing.JTextArea();
        btn_encrypt = new javax.swing.JButton();
        btn_decrypt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_saveFile = new javax.swing.JButton();
        txt_iv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Plaintext:");

        btn_openFile.setText("Open File");
        btn_openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openFileActionPerformed(evt);
            }
        });

        txt_plaintext.setColumns(20);
        txt_plaintext.setRows(5);
        jScrollPane1.setViewportView(txt_plaintext);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Key:");

        txt_key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_keyActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ciphertext:");

        txt_ciphertext.setColumns(20);
        txt_ciphertext.setRows(5);
        jScrollPane2.setViewportView(txt_ciphertext);

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("RC4 Cipher Demo");

        btn_saveFile.setText("Save to File");
        btn_saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveFileActionPerformed(evt);
            }
        });

        txt_iv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ivActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("IV:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(btn_encrypt)
                                        .addGap(68, 68, 68)
                                        .addComponent(btn_decrypt)
                                        .addGap(54, 54, 54)
                                        .addComponent(btn_saveFile)
                                        .addGap(49, 49, 49)
                                        .addComponent(btn_openFile))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_iv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(txt_key))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_iv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_encrypt)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_saveFile)
                        .addComponent(btn_decrypt))
                    .addComponent(btn_openFile))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open File containing Ciphertext");
        int userSelection = fileChooser.showOpenDialog(this);
        if(userSelection == JFileChooser.APPROVE_OPTION){
            File fileToOpen = fileChooser.getSelectedFile();
            try(BufferedReader reader = new BufferedReader(new FileReader(fileToOpen))){
                StringBuilder ciphertextBuilder = new StringBuilder();
                String line;
                while((line= reader.readLine()) !=null){
                    ciphertextBuilder.append(line);
                } 
                String ciphertext = ciphertextBuilder.toString().trim();
                txt_ciphertext.setText(ciphertext);
            }catch(IOException e){
                    JOptionPane.showMessageDialog(this,"Error opending file:"+
                            e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
        }
    }//GEN-LAST:event_btn_openFileActionPerformed

    private void txt_keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_keyActionPerformed

    private void btn_encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encryptActionPerformed
        try{
          String plaintext = txt_plaintext.getText();
          byte[] key= txt_key.getText().getBytes(StandardCharsets.UTF_8);
          byte[] iv=txt_iv.getText().getBytes(StandardCharsets.UTF_8);
          
          byte[] ciphertext = twofish.encrypt(plaintext, key, iv);
          String encryptedText = Base64.getEncoder().encodeToString(ciphertext);
          txt_ciphertext.setText(encryptedText);
     
      } catch(UnsupportedEncodingException e){
          JOptionPane.showMessageDialog(this,"Unspported encoding:"+e.getMessage(),"Error",
                  JOptionPane.ERROR_MESSAGE);
      }catch(Exception ex){
          Logger.getLogger(frm_Twofish.class.getName()).log(Level.SEVERE,null,ex);
          JOptionPane.showMessageDialog(this,"Error encrypting"+ex.getMessage(),
                  "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_encryptActionPerformed

    private void btn_decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_decryptActionPerformed
        try{
           String ciphertext = txt_ciphertext.getText();
           byte[] key = txt_key.getText().getBytes(StandardCharsets.UTF_8);
           byte[] iv=txt_iv.getText().getBytes(StandardCharsets.UTF_8);
           byte[] decodedCiphertext = Base64.getDecoder().decode(ciphertext);
           String decryptedText = twofish.decrypt(decodedCiphertext, key, iv);
           txt_plaintext.setText(decryptedText);
       }catch(Exception ex){
           Logger.getLogger(frm_Twofish.class.getName()).log(Level.SEVERE,null,ex);
           JOptionPane.showMessageDialog(this,"Error decrypting:"+ex.getMessage(),"Error",
                   JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btn_decryptActionPerformed

    private void btn_saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveFileActionPerformed
        String ciphertext = txt_ciphertext.getText();
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.setDialogTitle("Save Ciphertext to File");
       int userSelection = fileChooser.showSaveDialog(this);
       if(userSelection == JFileChooser.APPROVE_OPTION){
           File fileToSave = fileChooser.getSelectedFile();
           try(FileWriter writer=
                   new FileWriter(fileToSave.getAbsolutePath()+".txt")){
               writer.write(ciphertext);
               JOptionPane.showMessageDialog(this,
                       "ciphertext save to file successfully.","Success",
                       JOptionPane.INFORMATION_MESSAGE);
           }catch(IOException e){
               JOptionPane.showMessageDialog(this, "Error saving file"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           }
       }
    }//GEN-LAST:event_btn_saveFileActionPerformed

    private void txt_ivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ivActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Twofish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Twofish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Twofish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Twofish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Twofish().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_decrypt;
    private javax.swing.JButton btn_encrypt;
    private javax.swing.JButton btn_openFile;
    private javax.swing.JButton btn_saveFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt_ciphertext;
    private javax.swing.JTextField txt_iv;
    private javax.swing.JTextField txt_key;
    private javax.swing.JTextArea txt_plaintext;
    // End of variables declaration//GEN-END:variables
}
