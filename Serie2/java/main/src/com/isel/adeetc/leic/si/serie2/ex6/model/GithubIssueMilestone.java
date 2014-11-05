package com.isel.adeetc.leic.si.serie2.ex6.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GithubIssueMilestone {
	@JsonProperty
	private String url;
	@JsonProperty
	private Long number;
	@JsonProperty
	private String state;
	@JsonProperty
	private String title;
	@JsonProperty
	private String description;
	@JsonProperty
	private GithubIssueUser creator;
	@JsonProperty
	private Long open_issues;
	@JsonProperty
	private String closed_issues;
	@JsonProperty
	private Date created_at;
	@JsonProperty
	private Date updated_at;
	@JsonProperty
	private Date due_on;
	
	public GithubIssueMilestone(){}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GithubIssueUser getCreator() {
		return creator;
	}
	public void setCreator(GithubIssueUser creator) {
		this.creator = creator;
	}
	public Long getOpen_issues() {
		return open_issues;
	}
	public void setOpen_issues(Long open_issues) {
		this.open_issues = open_issues;
	}
	public String getClosed_issues() {
		return closed_issues;
	}
	public void setClosed_issues(String closed_issues) {
		this.closed_issues = closed_issues;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getDue_on() {
		return due_on;
	}
	public void setDue_on(Date due_on) {
		this.due_on = due_on;
	}
}