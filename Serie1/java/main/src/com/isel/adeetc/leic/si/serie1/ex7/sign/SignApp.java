package com.isel.adeetc.leic.si.serie1.ex7.sign;

import java.security.KeyPair;
import java.security.PrivateKey;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isel.adeetc.leic.si.serie1.ex7.model.JOSE_HeaderS;
import com.isel.adeetc.leic.si.serie1.ex7.model.JWS;
import com.isel.adeetc.leic.si.serie1.ex7.model.Utils;

public class SignApp {
	private final static String JOSE_HEADER_FORMAT = "{\"alg\":\"%s\",\"cty\":\"JWT\",\"jwk\":\"%s\"}";
	public static void main(String[] args) throws Exception {
		//Example of JWS Digital Signing. Uses JWS JSON Serialization and JWK

		String message = args[0];
		String algorithm = args[1];
		String key = args[2];
		String keyAlgorithm = args[3];
		
		JOSE_HeaderS header = new JOSE_HeaderS();
		header.alg = algorithm;
		header.cty = "JWT";
		header.jwk = Utils.Base64Encode(key);
		
		String tmp = String.format(JOSE_HEADER_FORMAT,algorithm,key);
		String protectedHeader = Utils.Base64Encode(tmp);
		String payload = Utils.Base64Encode(message);
		
		String signInput = protectedHeader + '.' + payload;
		
		KeyPair pKey = Utils.getKeyPair(key,keyAlgorithm);
		PrivateKey privKey = pKey.getPrivate();
		String signature = DigitalSigner.sign(signInput,algorithm,privKey);
		
		JWS jws = new JWS();
		
		jws.setSignature(Utils.Base64Encode(signature),protectedHeader);
		jws.setPayload(payload);
		
		ObjectMapper mapper = new ObjectMapper();
		String jwsSerialized = mapper.writeValueAsString(jws);
		
		String publicKey = new String(pKey.getPublic().getEncoded(), "UTF-8");
		System.out.println(jwsSerialized);
		System.out.println(publicKey);
	}
}