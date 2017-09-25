package denis.rylow.practice.messenger.resources;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import denis.rylow.practice.messenger.model.Message;
import denis.rylow.practice.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON) // You can annotate the whole class.
public class Messages {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> writeMessage() {
		return messageService.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String postMessage(Message message) {
		
		return "Posted " + messageService.addMessage(message);
	}	
		
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Message messageUpdate(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message messageRemove(@PathParam("messageId") long messageId) {
		return messageService.removeMessage(messageId);
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message test(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}//
	
}
