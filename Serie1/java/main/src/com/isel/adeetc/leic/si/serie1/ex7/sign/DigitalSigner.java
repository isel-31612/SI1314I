package com.isel.adeetc.leic.si.serie1.ex7.sign;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

public class DigitalSigner {

	public static String sign(String signInput, String algorithm,PrivateKey privKey) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
		Signature s =  Signature.getInstance(algorithm);
		s.initSign(privKey);
		s.sign(signInput.getBytes(), 0, signInput.length());
		return new String(s.sign(),"UTF-8");
	}
}
