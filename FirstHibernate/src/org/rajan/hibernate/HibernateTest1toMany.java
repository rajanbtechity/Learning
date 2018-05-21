package org.rajan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rajan.dto.UserDetails1toMany;
import org.rajan.dto.Vehicle1toMany;

public class HibernateTest1toMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//User # 1
		UserDetails1toMany user=new UserDetails1toMany();
		//user.setUserId(4); This will be taken care by hibernate as we defined @GeneratedValue for userId variable
		user.setUserName("Santosh");
		Vehicle1toMany vehicle=new Vehicle1toMany();
		vehicle.setVehicleName("Car");
		
		Vehicle1toMany vehicle2=new Vehicle1toMany();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		user=session.get(UserDetails1toMany.class, 1);
		session.close();
		//This is to test eager loading. Even after closing the session data is stored in user object
		//But in case of Lazy loading data is fetched when we try to access it using user.getListOfAddress()
		//So if FetchType is LAZY then below line will generate error.
		//System.out.println(user.getListOfAddress().size());
	}

}
