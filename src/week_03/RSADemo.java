package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class RSADemo {
    public static void main(String[] args) throws IOException {
        int primeSize = 1024;
        RSACipher rsa = new RSACipher(primeSize);
        System.out.println("Key size: [" + primeSize + "]");
        System.out.println();
        System.out.println("Generated prime numbers p and q");
        System.out.println("p: [" + rsa.getP().toString(16).toUpperCase() + "]");
        System.out.println("q: [" + rsa.getQ().toString(16).toUpperCase() + "]");
        System.out.println();
        System.out.println("The public key is the pair (N, E) which will be published.");
        System.out.println("N: [" + rsa.getN().toString(16).toUpperCase() + "]");
        System.out.println("E: [" + rsa.getE().toString(16).toUpperCase() + "]");
        System.out.println();
        System.out.println("N: [" + rsa.getN().toString(16).toUpperCase() + "]");
        System.out.println("D: [" + rsa.getD().toString(16).toUpperCase() + "]");
        System.out.println();
        
        System.out.println();
        System.out.print("Please enter message (plaintext): ");
        String plaintext = new BufferedReader(new InputStreamReader(System.in)).readLine();
        
        BigInteger[] ciphertext = rsa.encrypt(plaintext);
        System.out.print("Ciphertext: ");
        for (BigInteger ciphertextPart : ciphertext){
            System.out.print(ciphertextPart.toString(16).toUpperCase());
            System.out.print("  ");
        }
        System.out.println("");
        String recoveredPlaintext = rsa.decrypt(ciphertext, rsa.getD(), rsa.getN());
        System.out.println("Recovered plaintext: " + recoveredPlaintext);
    }
}
