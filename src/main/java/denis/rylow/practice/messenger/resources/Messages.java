package denis.rylow.practice.messenger.resources;

import java.util.List;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import denis.rylow.practice.messenger.model.Message;
import denis.rylow.practice.messenger.service.MessageService;

@Path("/messages")
public class Messages {

	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> writeMessage() {
		return messageService.getAllMessages();
	}
}
