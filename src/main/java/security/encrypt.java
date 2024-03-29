package security;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class encrypt {

	private static String SECRET_KEY = "sandhillskey";
	private static String SALT = "SANDHILLS";
	
	private encrypt() {}
	
	public static String ENCRYPT(String strToEncrypt){
		
		
		try {
			  
           
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
  
            
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            
           
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(),65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec( tmp.getEncoded(), "AES");
  
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            
            // Return encrypted string
            return Base64.getEncoder().encodeToString( cipher.doFinal(strToEncrypt.getBytes(
                    StandardCharsets.UTF_8)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
}
