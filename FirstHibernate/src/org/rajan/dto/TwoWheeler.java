package org.rajan.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends VehicleInheritance {
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}

}
