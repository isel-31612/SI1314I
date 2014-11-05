package com.isel.adeetc.leic.si.serie2.ex6.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleTask {
	private final String KIND = "tasks#task";
	@JsonProperty
	private final String kind;
	@JsonProperty
	private String id;
	@JsonProperty
	private String eTag;
	@JsonProperty
	private String title;
	@JsonProperty
	private Date updated;
	@JsonProperty
	private String selfLink;
	@JsonProperty
	private String parent;
	@JsonProperty
	private String position;
	@JsonProperty
	private String notes;
	@JsonProperty
	private String status;
	@JsonProperty
	private Date due;
	@JsonProperty
	private Date completed;
	@JsonProperty
	private Boolean deleted;
	@JsonProperty
	private Boolean hidden;
	@JsonProperty
	private List<GoogleTaskLink> links;
	
	public GoogleTask(){
		kind = KIND;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String geteTag() {
		return eTag;
	}
	public void seteTag(String eTag) {
		this.eTag = eTag;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getSelfLink() {
		return selfLink;
	}
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDue() {
		return due;
	}
	public void setDue(Date due) {
		this.due = due;
	}
	public Date getCompleted() {
		return completed;
	}
	public void setCompleted(Date completed) {
		this.completed = completed;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Boolean getHidden() {
		return hidden;
	}
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}
	public List<GoogleTaskLink> getLinks() {
		return links;
	}
	public void setLinks(List<GoogleTaskLink> links) {
		this.links = links;
	}
	public String getKIND() {
		return KIND;
	}
}