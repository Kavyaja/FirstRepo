package com.kavyaja.restapi.messenger3.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.kavyaja.restapi.messenger3.service.MessageService;
import com.kavyaja.restapi.messenger3.models.*;
import com.kavyaja.restapi.messenger3.resources.beans.MessageFilterBean;

@Path("/messages")
public class MessageResource {
	
	
		MessageService messageService = new MessageService();
		
//		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
			System.out.println("JSON method called ");
			if(filterBean.getYear()>0) {
				return messageService.getAllMessagesForYear(filterBean.getSize());
			}
		
		if(filterBean.getStart()>=0 && filterBean.getSize()>0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
		
		
		
		@Path("/{messageId}/comments")
		public CommentResource getCommentResource() {
			return new CommentResource();
		}
	
		@POST
		public Response addMessage(Message message,@Context UriInfo uriInfo)throws URISyntaxException {
			System.out.print(uriInfo.getAbsolutePath());
			Message newMessage = messageService.addMessage(message);
			String newId = String.valueOf(newMessage.getId());
			URI uri= uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.status(Status.CREATED)
				.entity(newMessage).build();
//		return Response.status(Status.CREATED).entity(newMessage).build();

		}
		
		
		@PUT
		@Path("/{messageId}")
		public Message updateMessage(@PathParam("messageId")long id,Message message)
		{
			 message.setId(id);
			 return messageService.updateMessage(message);
			}
		
		@DELETE
		@Path("/{messageId}")
		@Produces(MediaType.APPLICATION_JSON)
		public void deleteMessage(@PathParam("messageId")long id)
		{
//			 message.setId(id);
			  messageService.removeMessage(id);
			}
		
		
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_XML)
	public Message getMessage(@PathParam("messageId")long id, @Context UriInfo uriInfo) {
	{
		System.out.println("xml method called");
	}
		Message message = messageService.getMessages(id);
		message.addLink(getUriforSelf(uriInfo,message), "self");
		message.addLink(getUriforProfile(uriInfo,message), "self");
		message.addLink(getUriforComments(uriInfo,message), "self");


		return message;
	}
	
//	private String getUriForComments(UriInfo uriInfo, Message message) {
//		
//		URI uri = uriInfo.getBaseUriBuilder()
//				.path((CommentResource.class)
//				.build();
//				return uri.toString();
//	}
//	
//	private UriBuilder CommentResourceUriBuilder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	private String getUriForProfile(UriInfo uriInfo, Message message) {
//		URI uri = uriInfo.getBaseUriBuilder()
//				.path(ProfileResourceUriBuilder()
//				.path(message.getAuthor())
//				.build();
//				return uri.toString();
////			
//		
		
//		----------------------
		
		
		
		
			
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Message> getMessages()
//	{
//		return messageService.getAllMessages();
//	}
//	
	
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	@POST
//	public Response addMessage(Message message, @Context UriInfo uriInfo) {
////		System.out.print(uriInfo.getAbsolutePath());
//		Message newMessage = messageService.addMessage(message);
//		String newId = String.valueOf(newMessage.getId());
//		URI uri= uriInfo.getAbsolutePathBuilder().path(newId).build();
//	return Response.created(uri)
//			.entity(newMessage).build();
////	return Response.status(Status.CREATED).entity(newMessage).build();
//	
//	}
//	
	
	
	
//		@POST
//		public Message addMessage(Message message) {
//			return messageService.addMessage(message);
//		}
			
			
			
			
//		@Consumes(MediaType.APPLICATION_JSON)
//		@Produces(MediaType.APPLICATION_JSON)
//		public Response addMessage(Message message) throws URISyntaxException
//		{
//			Object uriInfo;
//			System.out.println(uriInfo.getAbsolutePath());
//			Message newMessage = messageService.addMessage(message);
//			return Response.created(new URI("messenger/webapi/messages/"+ newMessage.getId())).entity(newMessage).build();
//
////			return messageService.addMessage(message);
//			}
		
//		@PUT 
//		@Path("/{messageId}")
////		@Consumes(MediaType.APPLICATION_JSON)
////		@Produces(MediaType.APPLICATION_JSON)
//		public Message updateMessage(@PathParam("messageId")long id,Message message)
//		{
//			 message.setId(id);
//			 return messageService.updateMessage(message);
//			}
//		
//		@DELETE
//		@Path("/{messageId}")
////		@Produces(MediaType.APPLICATION_JSON)
//		public void deleteMessage(@PathParam("messageId")long id,Message message)
//		{
////			 message.setId(id);
//			  messageService.removeMessage(id);
//			}
//		
//		@GET
//		@Path("/{messageId}/comments")
//		@Produces(MediaType.APPLICATION_JSON)
//		public Message getMessage(@PathParam("messageId")long id){
//		{
//			return messageService.getMessages(id);
//		}
//		public String test() {
//			return "test";
//		}
//		
		
		
		
	
}



	private UriBuilder ProfileResourceUriBuilder() {
		// TODO Auto-generated method stub
		return null;
	}



	private String getUriforComments(UriInfo uriInfo, Message message) {
		// TODO Auto-generated method stub
		return null;
	}



	private String getUriforProfile(UriInfo uriInfo, Message message) {
		// TODO Auto-generated method stub
		return null;
	}



	private String getUriforSelf(UriInfo uriInfo, Message message) {
		// TODO Auto-generated method stub
		return null;
	}}


