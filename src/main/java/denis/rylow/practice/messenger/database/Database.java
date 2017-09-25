package denis.rylow.practice.messenger.database;

import java.util.HashMap;
import java.util.Map;

import denis.rylow.practice.messenger.model.Message;
import denis.rylow.practice.messenger.model.Profile;

public class Database {
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<Long, Message> messages = new HashMap<>();

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
}
