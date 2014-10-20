package com.isel.adeetc.leic.si.serie1.ex7.sign;

import java.security.PrivateKey;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isel.adeetc.leic.si.serie1.ex7.model.JOSE_HeaderS;
import com.isel.adeetc.leic.si.serie1.ex7.model.JWS;
import com.isel.adeetc.leic.si.serie1.ex7.model.Utils;

public class SignApp {
	private final static String JOSE_HEADER_FORMAT = "{\"alg\":\"%s\",\"cty\":\"JWT\",\"jwk\":\"%s\"}";
	public static void main(String[] args) throws Exception {
		//Example of JWS Digital Signing. Uses JWS JSON Serialization and JWK

		String message = /*args[0];*/"{\"iss\":\"joe\",\"exp\":1300819380,\"http://example.com/is_root\":true}";
		String algorithm = /*args[1];*/ "SHA256withRSA";//"RS256";
		String key = /*args[2];*/ "0vx7agoebGcQSuuPiLJXZptN9nndrQmbXEps2aiAFbWhM78LhWx"+
				     "4cbbfAAtVT86zwu1RK7aPFFxuhDR1L6tSoc_BJECPebWKRXjBZCiFV4n3oknjhMs"+
				     "tn64tZ_2W-5JsGY4Hc5n9yBXArwl93lqt7_RN5w6Cf0h4QyQ5v-65YGjQR0_FDW2"+
				     "QvzqY368QQMicAtaSqzs8KJZgnYb9c7d0zgdAZHzu6qMQvRL5hajrn1n91CbOpbI"+
				     "SD08qNLyrdkt-bFTWhAI4vMQFh6WeZu0fM4lFd2NcRwr3XPksINHaQ-G_xBniIqb"+
				     "w0Ls1jF44-csFCur-kEgU8awapJzKnqDKgw";
		String keyAlgorithm = /*args[3];*/ "RSA";
		
		JOSE_HeaderS header = new JOSE_HeaderS();
		header.alg = algorithm;
		header.cty = "JWT";
		header.jwk = Utils.Base64Encode(key);
		
		String tmp = String.format(JOSE_HEADER_FORMAT,algorithm,key);
		String protectedHeader = Utils.Base64Encode(tmp);
		String payload = Utils.Base64Encode(message);
		
		String signInput = protectedHeader + '.' + payload;
		
		PrivateKey pKey = Utils.getPrivateKey(key,keyAlgorithm);
		String signature = DigitalSigner.sign(signInput,algorithm,pKey);
		
		JWS jws = new JWS();
		
		jws.setSignature(Utils.Base64Encode(signature),protectedHeader);
		jws.setPayload(payload);
		
		ObjectMapper mapper = new ObjectMapper();
		String jwsSerialized = mapper.writeValueAsString(jws);
		
		System.out.println(jwsSerialized);
	}
}