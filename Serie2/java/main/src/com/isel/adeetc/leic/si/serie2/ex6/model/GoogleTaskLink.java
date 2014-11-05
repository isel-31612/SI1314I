package com.isel.adeetc.leic.si.serie2.ex6.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleTaskLink {
	@JsonProperty
	private String type;
	@JsonProperty
	private String description;
	@JsonProperty
	private String link;
	
	public GoogleTaskLink(){}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}