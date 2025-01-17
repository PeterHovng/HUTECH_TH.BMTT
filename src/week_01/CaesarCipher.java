package week_01;

public class CaesarCipher {
    public static String encrypt(String text, int key){
        return caesarCipher(text, key, true);
    }
    public static String decrypt(String text, int key){
        return caesarCipher(text, key, false);
    }
    private static String caesarCipher(String text, int key, boolean encrypt){
        StringBuilder result = new StringBuilder();
        int shift = encrypt ? key : -key;
        for(char character : text.toCharArray()){
            if(Character.isLetter(character)){                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int offset = (character - base + shift) % 26;
                if(offset < 0){
                    offset += 26;
                }
                result.append((char) (base + offset));
            } else{
                result.append(character);
            }
        }
        return result.toString();
    }
}
