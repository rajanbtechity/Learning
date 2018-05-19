package org.rajan.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	@Temporal(TemporalType.DATE)
	//Specify how date has to be saved, some of the  choices to consider are DATE, TIME, TIMESTAMP
	private Date joinedDate;
	private String Address;
	@Embedded
	//We can use @Embeddable in the Address class or we can use @Embedded while creating the object here
	private Address address;
	//@Lob
	//To store large object. Choice will be made between CLOB,BLOB
	private String description;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="OFC_STREET")),
	@AttributeOverride(name="city",column=@Column(name="OFC_CITY")),
	@AttributeOverride(name="state",column=@Column(name="OFC_STATE")),
	@AttributeOverride(name="pincode",column=@Column(name="OFC_PINCODE"))
	})
	private Address ofcAddress;
	/*
	//If we don't use @JoinTable Hibernate will create table as UserDetails_listOfAddress where listOfAddress is colection object name
	@ElementCollection
	@JoinTable(name="USER_ADDERESS",
			   joinColumns=@JoinColumn(name="USER_ID")
	)
	private Set<Address> listOfAddress=new HashSet();
	
	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	*/
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
	   joinColumns=@JoinColumn(name="USER_ID")
     )
	@GenericGenerator(name="sequence-gen",strategy="sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type="long"))
	private Collection<Address> listOfAddress=new ArrayList();
	
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public Address getOfcAddress() {
		return ofcAddress;
	}
	
	public void setOfcAddress(Address ofcAddress) {
		this.ofcAddress = ofcAddress;
	}
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
