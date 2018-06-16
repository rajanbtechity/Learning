package com.rajan.rest.messenger.model;

import java.util.Date;

public class Profile {
	private long id;
	private String profileName;
	private String firstName;
	private Date created;
	
	public Profile()
	{		
	}
	public Profile(long id,String profileName,String firstName)
	{
		this.id=id;
		this.firstName=firstName;
		this.profileName=profileName;
		this.created=new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

}
