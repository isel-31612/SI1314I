package com.isel.adeetc.leic.si.serie1.ex7.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonIgnoreProperties(ignoreUnknown=true)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({"payload","signatures"})
public class JWS {
	@JsonPropertyDescription
	private final List<JSONSignature> signatures = new ArrayList<>();
	@JsonProperty
	private String payload;

	public void setSignature(String signInput,String header) {
		JSONSignature sign = new JSONSignature();
		sign.setSignature(signInput);
		sign.setProtected(header);
		this.signatures.add(sign);
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
