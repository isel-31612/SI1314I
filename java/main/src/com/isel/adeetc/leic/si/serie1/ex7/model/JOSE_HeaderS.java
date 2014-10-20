package com.isel.adeetc.leic.si.serie1.ex7.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class JOSE_HeaderS {
	@JsonProperty
	public String alg;
	@JsonProperty
	public String cty;
	@JsonProperty
	public String typ;
	@JsonProperty
	public String jwk;
	
	public String getAlgorithm(){
		if("HS256".equals(alg))
			return "HmacSHA256";
		if("RS256".equals(alg))
			return "SHA256withRSA";
		throw new UnsupportedAlgorithmException(alg);
	}
	
	public boolean isNested(){
		return cty!=null && !cty.isEmpty() && "JWT".equals(cty);
	}
	
	public boolean isValid(){
		return alg!=null && !alg.isEmpty() && "JWT".equals(typ);
	}
}
