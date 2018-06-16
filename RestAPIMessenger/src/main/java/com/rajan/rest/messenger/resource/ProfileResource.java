package com.rajan.rest.messenger.resource;

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

import com.rajan.rest.messenger.model.Profile;
import com.rajan.rest.messenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService profileService=new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles()
	{
		return profileService.getAllProfile();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String pName)
	{
		return profileService.getProfile(pName);
	}
	
	@POST
	public Profile addProfile(Profile profile)
	{
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String pName,Profile profile)
	{
		profile.setProfileName(pName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile removeProfile(@PathParam("profileName")String pName)
	{
		return profileService.deleteProfile(pName);
	}
}
