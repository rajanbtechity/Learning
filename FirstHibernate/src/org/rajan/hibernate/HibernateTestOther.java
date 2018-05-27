package org.rajan.hibernate;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rajan.dto.UserDetailsOther;
import org.rajan.dto.VehicleOther;

public class HibernateTestOther {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetailsOther user=new UserDetailsOther();
		VehicleOther vehicle1=new VehicleOther();
		VehicleOther vehicle2=new VehicleOther();
		user.setUserName("Rajan");
		vehicle1.setVehicleName("Bike");
		vehicle2.setVehicleName("Car");
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.persist(user);
		/*
		 * If we don't save vehicle* object then hibernate gives error. If vehicle was a value type object then
		 * it would have worked fine. But since vehicle is an entity type it needs to be saved. 
		 * One of saving vehicle object without using session.save is to use cascade((cascade=CascadeType.PERSIST))
		 * and use session.persist(user)
		 */
		/*
		session.save(vehicle1);
		session.save(vehicle2);
		*/
		session.getTransaction().commit();
		session.close();

	}

}
