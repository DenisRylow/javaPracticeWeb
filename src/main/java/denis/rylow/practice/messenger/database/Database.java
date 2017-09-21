package denis.rylow.practice.messenger.database;

import java.util.HashMap;
import java.util.Map;

import denis.rylow.practice.messenger.model.Message;

public class Database {
	private static Map<Long, Message> profiles = new HashMap<>();
	private static Map<Long, Message> messages = new HashMap<>();

	public static Map<Long, Message> getProfiles() {
		return profiles;
	}
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
}
