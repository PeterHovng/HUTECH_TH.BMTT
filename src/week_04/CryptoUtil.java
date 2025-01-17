package week_04;

public class CryptoUtil {
    public static String toHexString(byte[] bytes){
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes){
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static final void byte2hex(byte b, StringBuffer buf){
        char[] hexChars = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F'};
        int high = ((b & 0xf0) >> 4);
        int low = (b & 0x0f);
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
        }
    }
