package denis.rylow.practice.messenger.service;

import denis.rylow.practice.messenger.database.Database;

import denis.rylow.practice.messenger.model.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PorfileService {
	private static Map<String, Profile> Profiles = Database.getProfiles();
	
	public PorfileService() {
		Profiles.put("Denis", new Profile(1, "Denis", "Hello World", "Denis"));
		//Profiles.put(2L, new Profile(2, "Hello World!!!!", "Denis"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(Profiles.values());
	}
	
	public Profile getProfile(String profName) {
		Profile Profile = Profiles.get(profName);
		return Profile;
	}
	
	public long addProfile(Profile Profile) {
		if (Profile == null) {
			return -1;
		}
		Profile.setId(Profiles.size() + 1);
		Profiles.put(Profile.getProfileName(), Profile);	
		return Profiles.size();		 
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		Profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profName) {
		return Profiles.remove(profName);
	}
		
}
