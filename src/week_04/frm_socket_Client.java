package week_04;
    import java.io.*;
    import java.net.Socket;
    import java.security.*;
    import java.security.spec.InvalidKeySpecException;
    import java.security.spec.X509EncodedKeySpec;
    import javax.crypto.*;
    import javax.crypto.spec.SecretKeySpec;
public class frm_socket_Client extends javax.swing.JFrame {
    
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private KeyAgreement keyAgreement;
    private SecretKey secretKey;
    
    public frm_socket_Client() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_IP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_PORT = new javax.swing.JTextField();
        btn_connect = new javax.swing.JButton();
        label_status = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_send_text = new javax.swing.JTextArea();
        btn_send_to_server = new javax.swing.JButton();
        btn_disconnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Difiie-Hellman key exchange with Socket - CLIENT");

        jLabel2.setText("IP Address:");

        jLabel3.setText("Port:");

        btn_connect.setText("Connect");
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        label_status.setText("Status: Client is disconnected!");

        jLabel5.setText("Enter text:");

        txt_send_text.setColumns(20);
        txt_send_text.setRows(5);
        jScrollPane1.setViewportView(txt_send_text);

        btn_send_to_server.setText("Send to Server");
        btn_send_to_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_send_to_serverActionPerformed(evt);
            }
        });

        btn_disconnect.setText("Disconnect");
        btn_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disconnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(btn_connect)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label_status))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(123, 123, 123)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_PORT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btn_send_to_server)
                        .addGap(96, 96, 96)
                        .addComponent(btn_disconnect)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_PORT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_connect)
                    .addComponent(label_status))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_send_to_server)
                    .addComponent(btn_disconnect))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
         try{
            socket = new Socket(txt_IP.getText(), Integer.parseInt(txt_PORT.getText()));
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DiffieHellman");
            keyPairGen.initialize(1024);
            KeyPair clientKeyPair = keyPairGen.generateKeyPair();
            keyAgreement = KeyAgreement.getInstance("DiffieHellman");
            keyAgreement.init(clientKeyPair.getPrivate());
            
            out.writeObject(clientKeyPair.getPublic().getEncoded());
            
            byte[] serverPublicKeyBytes = (byte[]) in.readObject();
            KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(serverPublicKeyBytes);
            PublicKey serverPublicKey = keyFactory.generatePublic(x509KeySpec);
            
            keyAgreement.doPhase(serverPublicKey, true);
            
            byte[] sharedSecret = keyAgreement.generateSecret();
            secretKey = new SecretKeySpec(sharedSecret, 0, 16, "AES");
            
            label_status.setText("Status: Connect to server.");
        }catch(IOException | NoSuchAlgorithmException | InvalidKeyException | ClassNotFoundException | InvalidKeySpecException e){
            e.printStackTrace();
            label_status.setText("Status: Connection failed.");
        }
    }//GEN-LAST:event_btn_connectActionPerformed

    private void btn_send_to_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_send_to_serverActionPerformed
        try{
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(txt_send_text.getText().getBytes());
            
            out.writeObject(encryptedBytes);
        } catch(IOException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException e){
            e.printStackTrace();
            label_status.setText("Status: Error sending message.");
        }
    }//GEN-LAST:event_btn_send_to_serverActionPerformed

    private void btn_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disconnectActionPerformed
        try{
            if(socket != null && !socket.isClosed()){
                socket.close();
                label_status.setText("Status: Disconnected from server.");
            }
        } catch(IOException e){
             e.printStackTrace();
            label_status.setText("Status: Error disconnecting.");
        }
    }//GEN-LAST:event_btn_disconnectActionPerformed

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
            java.util.logging.Logger.getLogger(frm_socket_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_socket_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_socket_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_socket_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_socket_Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_disconnect;
    private javax.swing.JButton btn_send_to_server;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_status;
    private javax.swing.JTextField txt_IP;
    private javax.swing.JTextField txt_PORT;
    private javax.swing.JTextArea txt_send_text;
    // End of variables declaration//GEN-END:variables
}
