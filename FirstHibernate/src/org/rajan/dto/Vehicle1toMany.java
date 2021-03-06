package org.rajan.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle1toMany {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	@NotFound(action=NotFoundAction.IGNORE)
	//If a vehicle doesn't have a user associated with it then it will generate exception. So to handle it 
	//We use @NotFound annotation which is a hibernate implementation.
	UserDetails1toMany user=new UserDetails1toMany();
	public UserDetails1toMany getUser() {
		return user;
	}
	public void setUser(UserDetails1toMany user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
}
