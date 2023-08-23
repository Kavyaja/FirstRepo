package com.kavyaja.restapi.messenger3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.kavyaja.restapi.messenger3.models.Comment;
import com.kavyaja.restapi.messenger3.models.DatabaseClass;
import com.kavyaja.restapi.messenger3.models.ErrorMessage;
import com.kavyaja.restapi.messenger3.models.Message;

public class CommentService {
		
	
	private static  Map<Integer, Message> messages = DatabaseClass.getMessages();
	private static  Map<Integer, Comment> comments = DatabaseClass.getComments();
	
	Message message = new Message();
	
//	public CommentService()
//	{
//		comments.put(1,new Comment(1, "java is powerfull", "kavyaja"));
//		comments.put(2,new Comment(2, "Java is Simple", "kj"));
//		message.setComments(comments);
//	}
//	
	
	
	public List<Comment> getAllComments(long messageId) {
	  Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getcomment(long messageId, long commentId) {
		
		ErrorMessage errorMessage = new ErrorMessage("Not found",404, "http://DataNotFoundException");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}

	public Comment addcomment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;

	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId()<=0) {
		return null;
	}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removecomment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);

	}
	

}
