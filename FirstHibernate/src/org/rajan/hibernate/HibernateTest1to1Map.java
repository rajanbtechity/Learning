package org.rajan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rajan.dto.UserDetails1to1;
import org.rajan.dto.Vehicle;

public class HibernateTest1to1Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//User # 1
		UserDetails1to1 user=new UserDetails1to1();
		//user.setUserId(4); This will be taken care by hibernate as we defined @GeneratedValue for userId variable
		user.setUserName("Santosh");
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		user.setVehicle(vehicle);
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		user=session.get(UserDetails1to1.class, 1);
		session.close();
		//This is to test eager loading. Even after closing the session data is stored in user object
		//But in case of Lazy loading data is fetched when we try to access it using user.getListOfAddress()
		//So if FetchType is LAZY then below line will generate error.
		//System.out.println(user.getListOfAddress().size());
		

	}

}
