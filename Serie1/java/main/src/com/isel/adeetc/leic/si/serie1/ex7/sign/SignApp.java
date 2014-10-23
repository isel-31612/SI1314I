package com.isel.adeetc.leic.si.serie1.ex7.sign;

import java.security.PrivateKey;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isel.adeetc.leic.si.serie1.ex7.model.JOSE_HeaderS;
import com.isel.adeetc.leic.si.serie1.ex7.model.JWS;
import com.isel.adeetc.leic.si.serie1.ex7.model.Utils;

public class SignApp {
	public static void main(String[] args) throws Exception {
		//Example of JWS Digital Signing. Uses JWS JSON Serialization and JWK

		String message = args[0];
		String algorithm = args[1];
		String key = args[2];
		String keyAlgorithm = args[3];
		
		ObjectMapper mapper = new ObjectMapper();
		
		JOSE_HeaderS header = new JOSE_HeaderS();
		header.alg = algorithm;
		header.cty = "JWT";
		header.jwk = key;
		
		String joseHeader = mapper.writeValueAsString(header);
		String protectedHeader = Utils.Base64Encode(joseHeader);
		String payload = Utils.Base64Encode(message);
		
		String signInput = protectedHeader + '.' + payload;
		
		PrivateKey privKey = Utils.getPrivateKey(key,keyAlgorithm);
		String signature = DigitalSigner.sign(signInput,algorithm,privKey);
		
		JWS jws = new JWS();
		
		jws.setSignature(Utils.Base64Encode(signature),protectedHeader);
		jws.setPayload(payload);
		
		String jwsSerialized = mapper.writeValueAsString(jws);
		
		System.out.println(jwsSerialized);
	}
}