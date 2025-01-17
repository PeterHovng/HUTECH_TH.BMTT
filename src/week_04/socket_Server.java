package week_04;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
public class socket_Server {
    private static final int PORT = 12345;
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.printf("Server is running...");
            Socket socket = serverSocket.accept();
            System.out.printf("Client connected.");
            
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DiffieHellman");
            keyPairGen.initialize(1024);
            KeyPair serverKeyPair = keyPairGen.generateKeyPair();
            KeyAgreement serverKeyAgreement = KeyAgreement.getInstance("DiffieHellman");
            serverKeyAgreement.init(serverKeyPair.getPrivate());
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            
            out.writeObject(serverKeyPair.getPublic().getEncoded());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            byte[] clientPublicKeyByte = (byte[])in.readObject();
            KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(clientPublicKeyByte);
            PublicKey clientPublicKey = keyFactory.generatePublic(x509KeySpec);
            serverKeyAgreement.doPhase(clientPublicKey, true);
            
            byte[] sharedSecret = serverKeyAgreement.generateSecret();
            SecretKeySpec secretKeySpec = new SecretKeySpec(sharedSecret, 0, 16, "AES");
            byte[] encryptedBytes = (byte[]) in.readObject();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            String decryptedMessage = new String(cipher.doFinal(encryptedBytes));
            System.out.println("REceived message from client:" + new String(encryptedBytes));
            System.out.println("Decrypted message form client:" + decryptedMessage);
            
            socket.close();
            serverSocket.close();
        }catch( InvalidKeySpecException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException |
                IOException | NoSuchAlgorithmException | InvalidKeyException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
