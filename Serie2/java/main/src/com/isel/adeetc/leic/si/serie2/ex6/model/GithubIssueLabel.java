package com.isel.adeetc.leic.si.serie2.ex6.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GithubIssueLabel {
	@JsonProperty
	private String url;
	@JsonProperty
	private String name;
	@JsonProperty
	private String color;
	
	public GithubIssueLabel(){}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}