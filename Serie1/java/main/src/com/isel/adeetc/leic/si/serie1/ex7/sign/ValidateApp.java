package com.isel.adeetc.leic.si.serie1.ex7.sign;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isel.adeetc.leic.si.serie1.ex7.model.JSONSignature;
import com.isel.adeetc.leic.si.serie1.ex7.model.JWS;
import com.isel.adeetc.leic.si.serie1.ex7.model.Utils;

public class ValidateApp {
	//Example of JWS Digital Signing. Uses JWS JSON Serialization and JWK
	public static void main(String[] args) throws Exception {
		String jwsSerialized = args[0];
		String algorithm = args[1];
		String pKey = args[2];
		String keyAlgorithm = args[3];
		
		ObjectMapper mapper = new ObjectMapper();
		JWS jws = mapper.readValue(jwsSerialized, JWS.class);
		
		X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(pKey.getBytes("UTF-8"));
		KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
		PublicKey publicKey = keyFactory.generatePublic(pubKeySpec);
		
		List<JSONSignature> list = jws.getSignatures();
		List<Boolean> verifies = new ArrayList<>(list.size());
		
		for(JSONSignature sign : list){
			String signature = Utils.Base64Decode(sign.getSignature());
			boolean verified = DigitalSigner.verify(signature, algorithm, publicKey);
			verifies.add(verified);
		}
		for(Boolean b : verifies)
			System.out.println(b);
	}
}
