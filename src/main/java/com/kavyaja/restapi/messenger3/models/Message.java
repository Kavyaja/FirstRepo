package com.kavyaja.restapi.messenger3.models;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment>comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();
	
	public Message()
	{
		
	}
	
	public Message(long id, String message, String author)
	{
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date(id);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Map<Long, Comment> getComments() {
		return null;
	}
	
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	public List<Link> getLinks(){
		return links;
		
	}
	public void setLinks(List<Link>Links) {
		this.links=links;
		
	}
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
