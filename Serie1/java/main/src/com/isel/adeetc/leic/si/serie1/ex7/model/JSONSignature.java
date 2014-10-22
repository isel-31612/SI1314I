package com.isel.adeetc.leic.si.serie1.ex7.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonPropertyOrder({"protectedHeader","header","signature"})
public class JSONSignature {
	@JsonProperty("protected")
	private String protectedHeader;
	@JsonProperty
	private String header;
	@JsonProperty
	private String signature;
	
	public void setProtected(String header){
		this.protectedHeader = header;
	}
	
	public void setSignature(String signature){
		this.signature = signature;
	}

	public String getSignature() {
		return signature;
	}

}
