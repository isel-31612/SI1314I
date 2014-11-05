package com.isel.adeetc.leic.si.serie2.ex6.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GithubIssuePullRequest {
	@JsonProperty
	private String url;
	@JsonProperty
	private String html_url;
	@JsonProperty
	private String diff_url;
	@JsonProperty
	private String patch_url;
	
	public GithubIssuePullRequest(){}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getDiff_url() {
		return diff_url;
	}

	public void setDiff_url(String diff_url) {
		this.diff_url = diff_url;
	}

	public String getPatch_url() {
		return patch_url;
	}

	public void setPatch_url(String patch_url) {
		this.patch_url = patch_url;
	}
}