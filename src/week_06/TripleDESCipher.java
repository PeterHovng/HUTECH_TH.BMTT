/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_06;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Administrator
 */
public class TripleDESCipher {
    private static final String ALGORITHM = "DESede";
    public static String SECRET_KEY;
    public static String encrypt(String plaintext, String secretKey) 
            throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
            BadPaddingException, IllegalBlockSizeException{
        
        SECRET_KEY = secretKey;
        SecretKey key = generateKey(secretKey);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptBytes);
    }

    public static String decrypt(String ciphertext, String secretKey)
            throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
            BadPaddingException, IllegalBlockSizeException{
        
        SecretKey key = generateKey(secretKey);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptBytes = cipher.doFinal(decodedBytes);
        return new String(decryptBytes);
    }
    private static SecretKey generateKey(String secretKey) throws NoSuchAlgorithmException {
        byte[] keyBytes = secretKey.getBytes();
        byte[] validKeyBytes = new byte[24];
        
        for (int i =0 ;i < validKeyBytes.length; i++){
            if (i < keyBytes.length){
                validKeyBytes[i] = keyBytes[i];
            }else{
                validKeyBytes[i] = 0;
            }
        }
        SecretKeySpec keySpec = new SecretKeySpec(validKeyBytes, ALGORITHM);
        return keySpec;
    }
}
