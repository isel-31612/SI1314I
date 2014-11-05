package com.isel.adeetc.leic.si.serie2.ex6.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GithubIssue {
	@JsonProperty
	private String url;
	@JsonProperty
	private String html_url;
	@JsonProperty
	private Long number;
	@JsonProperty
	private String state; //Maybe enum
	@JsonProperty
	private String title;
	@JsonProperty
	private String body;
	@JsonProperty
	private GithubIssueUser user;
	@JsonProperty
	private List<GithubIssueLabel> labels;
	@JsonProperty
	private GithubIssueAssignee assignee;
	@JsonProperty
	private GithubIssueMilestone milestone;
	@JsonProperty
	private Long comments;
	@JsonProperty
	private GithubIssuePullRequest pull_request;
	@JsonProperty
	private Date closed_at;
	@JsonProperty
	private Date created_at;
	@JsonProperty
	private Date updated_at;
	
	public GithubIssue(){}
	
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public GithubIssueUser getUser() {
		return user;
	}
	public void setUser(GithubIssueUser user) {
		this.user = user;
	}
	public List<GithubIssueLabel> getLabels() {
		return labels;
	}
	public void setLabels(List<GithubIssueLabel> labels) {
		this.labels = labels;
	}
	public GithubIssueAssignee getAssignee() {
		return assignee;
	}
	public void setAssignee(GithubIssueAssignee assignee) {
		this.assignee = assignee;
	}
	public GithubIssueMilestone getMilestone() {
		return milestone;
	}
	public void setMilestone(GithubIssueMilestone milestone) {
		this.milestone = milestone;
	}
	public Long getComments() {
		return comments;
	}
	public void setComments(Long comments) {
		this.comments = comments;
	}
	public GithubIssuePullRequest getPull_request() {
		return pull_request;
	}
	public void setPull_request(GithubIssuePullRequest pull_request) {
		this.pull_request = pull_request;
	}
	public Date getClosed_at() {
		return closed_at;
	}
	public void setClosed_at(Date closed_at) {
		this.closed_at = closed_at;
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
}