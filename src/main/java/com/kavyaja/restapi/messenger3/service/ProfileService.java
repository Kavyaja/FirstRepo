package com.kavyaja.restapi.messenger3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kavyaja.restapi.messenger3.models.DatabaseClass;
import com.kavyaja.restapi.messenger3.models.Message;
import com.kavyaja.restapi.messenger3.models.Profile;

public class ProfileService {
	
	public ProfileService()
	{
		profiles.put("Kj", new Profile(1L,"kavyaja","yyy","zii"));
	}
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public List<Profile> getAllProfiles()
	{
		
		return new ArrayList<Profile>(profiles.values());
			
	}
		public Profile getProfile (String profileName) {
			return profiles.get(profileName);
		}
		public Profile addProfile(Profile profile) {
			profile.setId(profiles.size()+1);
			profiles.put(profile.getprofilename(), profile);
			return profile;
		}
		public Profile updateProfile(Profile profile) {
			if(profile.getId()<=0)
				{
				return null;
				}
			profiles.put(profile.getprofilename(), profile);
			return profile;
		}	
			
		public Profile removeProfile(String profileName) {
			return profiles.remove(profileName);
 		}
		
		
		
	}


