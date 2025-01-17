package week_05;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5Util {
    public static String md5 (String input) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            md.update (input.getBytes());
            byte[] digest = md.digest ();
            BigInteger bigInt = new BigInteger (1, digest);
            String md5Hex = bigInt.toString(16);
            while (md5Hex.length() < 32) {
                md5Hex="0" + md5Hex;
            }        
            return md5Hex;
            }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
           }
    }
}