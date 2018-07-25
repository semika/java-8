/**
 * 
 */
package java8.md5;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author semikasiriwardana
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println(digest("test@123"));  
		System.out.println(getHash("test@123")); 
		System.out.println("ceb6c970658f31504a901b89dcd3e461"); 
	}
	
	
	public static String digest(String pwd) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] pwdByte = pwd.getBytes(Charset.defaultCharset());
        md.update(pwdByte, 0, pwdByte.length);

        return toHexString(md.digest());
    }

    public static String toHexString(byte[] buf) {
        char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F' };

        StringBuffer strBuf = new StringBuffer(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            strBuf.append(hexChar[(buf[i] & 0xf0) >>> 4]); // fill left with
            strBuf.append(hexChar[buf[i] & 0x0f]);
        }
        return strBuf.toString();
    }
    
    public static String getHash(String x) {

		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(x.getBytes());
			byte[] digest = md.digest();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}


}
