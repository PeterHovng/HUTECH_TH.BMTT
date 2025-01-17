package week_02;

import java.nio.charset.StandardCharsets;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.engines.TwofishEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;


public class TwofishCipher {
    private static final int BLOCK_SIZE = 16;
    private BlockCipher cipher = new CBCBlockCipher(new TwofishEngine());
    public byte[] encrypt(String plaintext, byte[] key, byte[] iv) throws Exception{
        PaddedBufferedBlockCipher paddedCipher = new PaddedBufferedBlockCipher(cipher);
        ParametersWithIV parameters = new ParametersWithIV(new KeyParameter(key), iv);
        paddedCipher.init(true, parameters);
        byte[] plaintextBytes = plaintext.getBytes(StandardCharsets.UTF_8);
        int minSize = paddedCipher.getOutputSize(plaintextBytes.length);
        byte[] outBuf = new byte[minSize];
        int length1 = paddedCipher.processBytes(plaintextBytes, 0, plaintextBytes.length, outBuf, 0);
        int length2 = paddedCipher.doFinal(outBuf, length1);
        
        byte[] ciphertext = new byte[length1 + length2];
        System.arraycopy(outBuf, 0, ciphertext, 0 , ciphertext.length);
        return ciphertext;
    }
    
    public String decrypt(byte[] ciphertext, byte[] key, byte[] iv) throws Exception{
        PaddedBufferedBlockCipher paddedCipher = new PaddedBufferedBlockCipher(cipher);
        ParametersWithIV parameters = new ParametersWithIV(new KeyParameter(key), iv);
        paddedCipher.init(false, parameters);
        
        int minSize = paddedCipher.getOutputSize(ciphertext.length);
        byte[] outBuf = new byte[minSize];
        int length1 = paddedCipher.processBytes(ciphertext, 0, ciphertext.length, outBuf, 0);
        int length2 = paddedCipher.doFinal(outBuf, length1);
        
        byte[] plaintextBytes = new byte[length1 + length2];
        System.arraycopy(outBuf, 0, plaintextBytes, 0 , plaintextBytes.length);
        return new String(plaintextBytes, StandardCharsets.UTF_8);
    }
    public static void main(String[] args) {
           System.out.println("Hello World!");
       }
}
