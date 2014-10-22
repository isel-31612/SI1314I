package com.isel.adeetc.leic.si.serie1.ex7.model;

import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Utils {
	private static final Charset cs = Charset.forName("UTF-8");
	
	public static String Base64Encode(String message){
		return new String(Base64.getUrlEncoder().encode(message.getBytes()),cs);
	}
	
	public static String Base64Decode(String message){
		return new String(Base64.getUrlDecoder().decode(message),cs);
	}
	
	public static KeyPair getKeyPair(String key, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException{
		KeyPairGenerator keyGen = KeyPairGenerator .getInstance(algorithm);
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		keyGen.initialize(1024, random);
		return keyGen.generateKeyPair();
	}
}
