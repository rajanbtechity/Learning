package org.rajan.dto;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends VehicleInheritance {
	private String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}

}
