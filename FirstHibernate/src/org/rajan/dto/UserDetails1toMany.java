package org.rajan.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS3")
public class UserDetails1toMany {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@OneToMany
	/*
	 * when we use @JoinTable then Hibernate creates another table which has user_id and vehicle_id reference.
	 * Another way of using OneToMany relation is to use@JoinColumn in Vehicle1toMany class above UserDetails1toMany object
	 * so that Vehicle1toMany table itself has a user_id column
	 */
	/*
	@JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"),
	           inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
			)
	*/
	private Collection<Vehicle1toMany> vehicle=new ArrayList();
	
	public Collection<Vehicle1toMany> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle1toMany> vehicle) {
		this.vehicle = vehicle;
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
