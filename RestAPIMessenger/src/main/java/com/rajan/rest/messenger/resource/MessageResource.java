package com.rajan.rest.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rajan.rest.messenger.model.Message;
import com.rajan.rest.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService=new MessageService();
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@QueryParam("year") int yr,@QueryParam("start") int st,@QueryParam("size") int sz)
	{
		if(st>0 && sz>0)
			return messageService.getAllMessagesPaginated(st, sz);
		if(yr>0)
			return messageService.getAllMessagesForYear(yr);
		
		return messageService.getAllMessages();
	}
	*/
	/*
	 * re writing getMessage using BeanParam
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@BeanParam MessageFilterBean filterbean)
	{
		if(filterbean.getStart()>0 && filterbean.getSize()>0)
			return messageService.getAllMessagesPaginated(filterbean.getStart(), filterbean.getSize());
		if(filterbean.getYear()>0)
			return messageService.getAllMessagesForYear(filterbean.getYear());
		
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long msgId)
	{
		return messageService.getMessage(msgId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg)
	{
		return messageService.addMessage(msg);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
		
	}
}
