package com.isel.adeetc.leic.si.serie2.ex6.business;

import com.isel.adeetc.leic.si.serie2.ex6.model.GithubIssue;
import com.isel.adeetc.leic.si.serie2.ex6.model.GoogleTask;

public class Converter {
	
	public static GoogleTask convert(GithubIssue issue){
		GoogleTask task = new GoogleTask();
		task.setId(null);
		task.seteTag(null);
		task.setTitle(issue.getTitle());
		task.setUpdated(issue.getUpdated_at());
		
		task.setSelfLink(null);
		task.setParent(null);
		task.setPosition(null);
		task.setNotes(issue.getBody());
		
		task.setStatus(issue.getState());
		task.setDue(null);
		task.setCompleted(issue.getClosed_at());
		task.setDeleted(null);
		
		task.setHidden(null);
		task.setLinks(null);
		
		return task;
	}
}