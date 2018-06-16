package com.rajan.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rajan.rest.messenger.database.DatabaseClass;
import com.rajan.rest.messenger.model.Profile;

public class ProfileService {
	Map<String,Profile> profiles=DatabaseClass.getProfiles();

	public ProfileService()
	{
		profiles.put("Rajan", new Profile(1L,"Rajan","Rajan"));
		profiles.put("Sai", new Profile(2L,"Sai","Sai"));
	}
	
	public List<Profile> getAllProfile()
	{
		return new ArrayList<Profile> (profiles.values());
	}
	
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}
	
	public Profile updateProfile(Profile profile)
	{
		{
			if(profile.getProfileName().isEmpty())
				return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile deleteProfile(String profileName)
	{
		return profiles.remove(profileName);
	}
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

}
