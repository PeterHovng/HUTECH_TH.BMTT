package week_01;

public class RailFenceCipher {
    public static String encrypt(String text, int key){
        if(key <= 1){
            return text;
        }
        char[] chars = text.toCharArray() ;
        char[] result = new char [chars.length];
        int cycle = 2 * key - 2;
        int idx = 0;
        for (int i = 0; i < key; i++){
            for (int j = 0; i + j< chars.length; j += cycle) {
                result [idx++] = chars[i + j];
                if(i != 0 && i != key - 1 && j + cycle - i < chars.length){
                    result[idx++] = chars[j + cycle - i];
                }
            }
        }
        return new String(result);
    }
        public static String decrypt(String text, int key){
        if (key <= 1){
            return text;
        }
        char[] chars = text.toCharArray();
        char[] result = new char[chars.length];
        int cycle = 2 * key - 2;
        int idx = 0;
        for (int i = 0; i < key; i++){
            for (int j = 0; i + j < chars.length; j += cycle){
                result[i + j] = chars[idx++];
                if (i != 0 && i != key - 1 && j+ cycle - i < chars.length){
                    result[j + cycle - i] = chars [idx++];
                }
            }
        }
        return new String(result);
    }
}
