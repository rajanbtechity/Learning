package org.rajan.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	//Hibernate creates unique key by using nextval of hibernate PK hibernate_sequence.nextval.
	//This kind of key is known as surrogate key
	private int userId;
	//@Transient Table created without this column. 
	//Hibernate doesn't persist
	private String userName;
	//@Temporal(TemporalType.DATE)
	//Specify how date has to be saved, some of the  choices to consider are DATE, TIME, TIMESTAMP
	private Date joinedDate;
	private String Address;
	private Address address;
	//@Lob
	//To store large object. Choice will be made between CLOB,BLOB
	private String description;
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
