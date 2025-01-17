package week_04;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.Socket;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;

public class socket_Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 12345;
    
    public static void main(String[] args) {
        try{
            Socket socket = new Socket(SERVER_IP, PORT);
            
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DiffieHellman");
            keyPairGen.initialize(1024);
            KeyPair clientKeyPair = keyPairGen.generateKeyPair();
            KeyAgreement clientKeyAgreement = KeyAgreement.getInstance("DiffieHellman");
            clientKeyAgreement.init(clientKeyPair.getPrivate());
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            byte[] serverPublicKeyByte = (byte[])in.readObject();
            KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(serverPublicKeyByte);
            PublicKey serverPublicKey = keyFactory.generatePublic(x509KeySpec);
            clientKeyAgreement.doPhase(serverPublicKey, true);
            
            out.writeObject(clientKeyPair.getPublic().getEncoded());
            
            byte[] sharedSecret = clientKeyAgreement.generateSecret();
            SecretKeySpec secretKeySpec = new SecretKeySpec(sharedSecret, 0, 16, "AES");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter text: ");
            String plainText = scanner.nextLine();
            
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            out.writeObject(encryptedBytes);
            
            socket.close();
        }catch(InvalidKeySpecException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException |
                IOException | NoSuchAlgorithmException | InvalidKeyException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
