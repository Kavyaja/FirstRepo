package com.kavyaja.restapi.messenger3.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.kavyaja.restapi.messenger3.models.Comment;
import com.kavyaja.restapi.messenger3.models.Message;
import com.kavyaja.restapi.messenger3.service.CommentService;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService = new CommentService();
	private Object comment;
	
//	
//	@GET
//		public String test()
//		{
//			return "new sub resource";
//		
//	}
	
	@GET
//	@Path("/{commentId}")
	public List <Comment> getAllComments(@PathParam("messageId") long messageId){
		return commentService.getAllComments(messageId);
	}
	
	
	@POST
	public Comment addComment (@PathParam("messageId")long messageId, Comment comment) {	
	return commentService.addcomment(messageId, comment);	
	}

	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId")long messageId,@PathParam("CommentId") long commentId) {
		commentService.removecomment(messageId, commentId);
			
	}
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId")long messageId,@PathParam("commentId")long id, Comment comment) {
		comment.setId(id); 
		return commentService.updateComment(messageId, comment);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId")long messageId, @PathParam("commentId")long commentId) {
		return commentService.getcomment(messageId, commentId);
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	

