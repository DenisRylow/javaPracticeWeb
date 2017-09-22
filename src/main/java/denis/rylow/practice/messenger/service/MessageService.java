package denis.rylow.practice.messenger.service;

import denis.rylow.practice.messenger.database.Database;

import denis.rylow.practice.messenger.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService {
	private static Map<Long, Message> messages = Database.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Denis"));
		messages.put(2L, new Message(2, "Hello World!!!!", "Denis"));
	}
	
	public List<Message> getAllMessages() {
		//Message m1 = new Message(1L, "Hello", "Denis");
		//Message m2 = new Message(2L, "Hi", "Denis");
		
		//List<Message> l1 = new ArrayList<>();
		//l1.add(m1);
		//l1.add(m2);		
		//return l1;
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		return message;
	}
	
	public long addMessage(Message message) {
		return messages.put((long) messages.size(), message).getId();
		 
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
		
}
