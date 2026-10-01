package util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {

    public static String getHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] hash = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {

            sb.append(String.format("%02x", hash[i] & 0xff));
        }

        return sb.toString();
    }
}
