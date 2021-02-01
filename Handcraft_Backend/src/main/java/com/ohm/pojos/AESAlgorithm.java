package com.ohm.pojos;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class AESAlgorithm {
	public static final String KEY = "enfldsgbnlsngdlksdsgmjz";
    private static final char[] KEYA = KEY.toCharArray();
    private static final byte[] SALT = { (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33,
            (byte) 0x10, (byte) 0x12, };

    public static String dt(String strToDecrypt) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(KEYA));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        // return new
        // String(pbeCipher.doFinal(DatatypeConverter.parseBase64Binary(property)),
        // "UTF-8");
        return new String(pbeCipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }

    public static String en(String strToEncrypt) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(KEYA));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        // return new
        // String(pbeCipher.doFinal(DatatypeConverter.parseBase64Binary(property)),
        // "UTF-8");
        return Base64.getEncoder().encodeToString(pbeCipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    }

    /*public static void main(String[] args) throws GeneralSecurityException, IOException {
        AESAlgorithm o = new AESAlgorithm();
        String en = AESAlgorithm.en("Qaz12345");
        String de = AESAlgorithm.dt(en);

        System.out.println("Encrypted:::" + "  " + en);
        System.out.println("Decrypted:::" + "  " + de);
    }*/

}
