package com.rajan.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rajan.rest.messenger.database.DatabaseClass;
import com.rajan.rest.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages=DatabaseClass.getMessages();
	/*
	 * This was used when DatabaseClass was not created.
	public List<Message> getAllMessages()
	{
		List<Message> list=new ArrayList();
		Message m1=new Message(1,"This is Rajan","Rajan");
		Message m2=new Message(2,"This is Sai","Rajan");
		list.add(m1);
		list.add(m2);
		return list;
	}
	*/
	
	public MessageService(){
		messages.put(1L, new Message(1,"This is Rajan","Rajan"));
		messages.put(2L, new Message(2,"This is Sai","Rajan"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}
