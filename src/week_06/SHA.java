/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_06;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Administrator
 */
public class SHA {
    public static String HASH;
    public static String sha(String input)throws NoSuchAlgorithmException{
        return hashString(input,"SHA-1");
    }
    private static String hashString(String input, String algorithm)throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] hashedBytes = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b: hashedBytes){
            sb.append(String.format("%02x", b));
        }
        HASH = sb.toString();
        return sb.toString();
    }
}
