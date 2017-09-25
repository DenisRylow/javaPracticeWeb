package denis.rylow.practice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import denis.rylow.practice.messenger.model.Message;
import denis.rylow.practice.messenger.model.Profile;
import denis.rylow.practice.messenger.service.PorfileService;


@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private PorfileService  profileService = new PorfileService();

	@GET
	public List<Profile> writeMessage() {
		return profileService.getAllProfiles(); 
	}
	
	@POST
	public String postMessage(Profile message) {
		return "Posted " + profileService.addProfile(message);
	}	
		
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName); 
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile profileUpdate(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void porfileRemove(@PathParam("profileName") String profileName) {
		profileService.removeProfile(profileName);
	}
}
