package com.kavyaja.restapi.messenger3.resources;

import java.util.List;

import javax.validation.constraints.Past;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.kavyaja.restapi.messenger3.models.Message;
import com.kavyaja.restapi.messenger3.models.Profile;
import com.kavyaja.restapi.messenger3.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	private ProfileService profileService = new ProfileService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles()
	{
		return profileService.getAllProfiles();
	}
	@POST
	public Profile addProfile(Profile profile)
	{
		 return profileService.addProfile(profile);
		}
	
	@GET
	@Path("/{profileName}")
	public Profile getprofilename(@PathParam("profileName")String profileName)
	{
		 return profileService.getProfile(profileName);
		}
	
	
	@PUT 
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")String profileName,Profile profile)
	{
		 return profileService.updateProfile(profile);
		}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName")String profileName)
	{
		  profileService.removeProfile(profileName);
		}
	
		}



