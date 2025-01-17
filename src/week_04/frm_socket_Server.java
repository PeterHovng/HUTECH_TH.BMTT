/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package week_04;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
public class frm_socket_Server extends javax.swing.JFrame {

    public frm_socket_Server() {
        initComponents();
        btn_connect.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Thread(() -> startServer()).start();
            }
        });
    }
    private void startServer(){
        try{
            int port = Integer.parseInt(txt_PORT.getText());
            try(ServerSocket serverSocket = new ServerSocket(port)){
                SwingUtilities.invokeLater(() -> label_status.setText("Status: Waiting for client..."));
                Socket socket = serverSocket.accept();
                SwingUtilities.invokeLater(() -> label_status.setText("Status: Client connected."));
                
                KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DiffieHellman");
                keyPairGen.initialize(1024);
                KeyPair serverKeyPair = keyPairGen.generateKeyPair();
                KeyAgreement serverKeyAgreement = KeyAgreement.getInstance("DiffieHellman");
                serverKeyAgreement.init(serverKeyPair.getPrivate());
                
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(serverKeyPair.getPublic().getEncoded());
                
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                byte[] clientPublicKeyBytes = (byte[]) in.readObject();
                KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
                X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(clientPublicKeyBytes);
                PublicKey clientPublicKey = keyFactory.generatePublic(x509KeySpec);
                
                serverKeyAgreement.doPhase(clientPublicKey, true);
                
                byte[] sharedSecret = serverKeyAgreement.generateSecret();
                SecretKeySpec secretKeySpec = new SecretKeySpec(sharedSecret, 0, 16, "AES");
                
                
                byte[] encryptedBytes = (byte[]) in.readObject();
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                String decryptedMessage = new String(cipher.doFinal(encryptedBytes));
                SwingUtilities.invokeLater(() -> {
                    txt_msg_from_client.setText(new String(encryptedBytes));
                    txt_decrypt.setText(decryptedMessage);
                });
                
                socket.close();
                SwingUtilities.invokeLater(() -> label_status.setText("Status: Client is disconnected!"));
            }
        } catch(IOException | NoSuchAlgorithmException | InvalidKeyException | ClassNotFoundException | 
            NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException e){
            e.printStackTrace();
            SwingUtilities.invokeLater(() -> label_status.setText("Status: Error occurred!"));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_PORT = new javax.swing.JTextField();
        btn_connect = new javax.swing.JButton();
        label_status = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_msg_from_client = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_decrypt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Diffie-Hellman key exchange with Socket - SERVER");

        jLabel2.setText("IP Address:");

        jLabel3.setText("Post:");

        btn_connect.setText("Connect");

        label_status.setText("Status: Client is disconnected!");

        jLabel5.setText("Received message from client:");

        jLabel6.setText("Decrypted message from client:");

        txt_msg_from_client.setColumns(20);
        txt_msg_from_client.setRows(5);
        jScrollPane1.setViewportView(txt_msg_from_client);

        txt_decrypt.setColumns(20);
        txt_decrypt.setRows(5);
        jScrollPane2.setViewportView(txt_decrypt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_connect)
                                        .addGap(18, 18, 18)
                                        .addComponent(label_status))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_PORT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_PORT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_connect)
                    .addComponent(label_status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frm_socket_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_socket_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_socket_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_socket_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_socket_Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_status;
    private javax.swing.JTextField txt_PORT;
    private javax.swing.JTextArea txt_decrypt;
    private javax.swing.JTextArea txt_msg_from_client;
    // End of variables declaration//GEN-END:variables
}
