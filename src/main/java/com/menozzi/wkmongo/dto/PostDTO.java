package com.menozzi.wkmongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.menozzi.wkmongo.domain.Post;

public class PostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	public PostDTO() {
		
		
	}

	public PostDTO(Post obj, Date date, AuthorDTO author) {
		id = obj.getId();
		title = obj.getTitle();
		body = obj.getBody();
		
		this.date = date;
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	
	

}


