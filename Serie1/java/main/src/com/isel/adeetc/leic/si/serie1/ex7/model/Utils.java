package com.isel.adeetc.leic.si.serie1.ex7.model;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Utils {
	private static final Charset cs = Charset.forName("UTF-8");
	
	public static String Base64Encode(String message){
		return new String(Base64.getUrlEncoder().encode(message.getBytes()),cs);
	}
	
	public static String Base64Decode(String message){
		return new String(Base64.getUrlDecoder().decode(message),cs);
	}
	
	public static PrivateKey getPrivateKey(String key, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException{
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key.getBytes("UTF-8"));
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		return keyFactory.generatePrivate(keySpec);
	}
	
	public static PublicKey getPublicKey(String key, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException{
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key.getBytes("UTF-8"));
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		return keyFactory.generatePublic(keySpec);
	}
}
