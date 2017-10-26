package edu.colostate.cs.cs414.project.utilities;

import java.util.Random;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SecurityUtility {

	public static byte[] getSalt(){
		byte[] salt = new byte[20];
		new Random().nextBytes(salt);
		return salt;
	}
	
	public static byte[] hashPassword( final char[] password, final byte[] salt, final int iterations, final int keyLength ) {
		 
	       try {
	           SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
	           PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
	           SecretKey key = skf.generateSecret( spec );
	           byte[] res = key.getEncoded( );
	           return res;
	 
	       } catch( Exception e ) {
	           throw new RuntimeException( e );
	       }
	   }
	
}
