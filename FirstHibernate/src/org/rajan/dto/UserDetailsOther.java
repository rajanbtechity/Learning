package org.rajan.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS_OTHER")
public class UserDetailsOther {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	/*
	 * why did we use mappedBy here.
	 * if we don't use mappedBy then hibernate will create a separate table with userid and vehicleid mapping.
	 * A user can have multiple vehicle  therefore we can't have a reference to vehicle in user table. But yes
	 * we can have user reference (userid) in vehicle table. 
	 * So to achieve that we use mappedBy user where user is an object of UserDetailsOther class defined in vehicleOther class
	 * and in VehicleOther class we need to use @JoinColumn(name="USER_ID")
	 * If we don't use @joinColumn(name="USER_ID") in Vehicle class then no issue. 
	 * Hibernate will create table like this
	 * Hibernate: insert into VEHICLE_OTHER (user_userId, vehicleName, vehicleId) values (?, ?, ?)
	 */
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="user")
	Collection <VehicleOther> vehicle=new ArrayList();
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
	public Collection<VehicleOther> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleOther> vehicle) {
		this.vehicle = vehicle;
	}

}
