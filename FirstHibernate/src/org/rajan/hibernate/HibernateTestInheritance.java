package org.rajan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rajan.dto.FourWheeler;
import org.rajan.dto.TwoWheeler;
import org.rajan.dto.UserDetailsInheritance;
import org.rajan.dto.VehicleInheritance;

public class HibernateTestInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetailsInheritance user=new UserDetailsInheritance();
		VehicleInheritance vehicle=new VehicleInheritance();
		vehicle.setVehicleName("car");
		
		TwoWheeler bike=new TwoWheeler();
		FourWheeler car=new FourWheeler();
		
		bike.setVehicleName("Pulsar");
		bike.setSteeringHandle("Pulsar Steering Handle");
		
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porshe steering Wheel");
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();

	}

}
