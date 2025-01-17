package week_01;

public class AutokeyCipher {
    public String encrypt(String plaintext, String key) {
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();
        
        StringBuilder ciphertext = new StringBuilder();
        int keyIndex = 0;
        
        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            
            if(Character.isLetter(plainChar)) {
                char keyChar;
                
                if (keyIndex < key.length()) {
                    keyChar = key.charAt(keyIndex);
                    keyIndex++;
                } else {
                    keyChar = plaintext.charAt(i - key.length());
                }
                
                int shift = keyChar - 'A';
                char encryptedChar = (char) ((plainChar - 'A' + shift ) % 26 + 'A');
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(plainChar);               
            }
        }
        
        return ciphertext.toString();
                
    }
    public String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();
        
        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            
            if(Character.isLetter(cipherChar)) {
                char keyChar;
                
                if (keyIndex < key.length()) {
                    keyChar = key.charAt(keyIndex);
                    keyIndex++;
                } else {
                    keyChar = plaintext.charAt(i - key.length());
                }
                
                int shift = keyChar - 'A';
                char decryptedChar = (char) ((cipherChar - 'A' - shift +  26 ) % 26 + 'A');
               plaintext.append(decryptedChar);
            } else {
                plaintext.append(cipherChar);               
            }
        }
        
        return plaintext.toString();
                
    }
}
