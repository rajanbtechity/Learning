package org.rajan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rajan.dto.UserDetailsManytoMany;
import org.rajan.dto.VehicleManytoMany;


public class HibernateTestManytoMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//User # 1
		UserDetailsManytoMany user=new UserDetailsManytoMany();
		//user.setUserId(4); This will be taken care by hibernate as we defined @GeneratedValue for userId variable
		user.setUserName("Santosh");
		VehicleManytoMany vehicle=new VehicleManytoMany();
		vehicle.setVehicleName("Car");
		
		VehicleManytoMany vehicle2=new VehicleManytoMany();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		vehicle.getUser().add(user);
		vehicle2.getUser().add(user);
		
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
		user=session.get(UserDetailsManytoMany.class, 1);
		session.close();
		//This is to test eager loading. Even after closing the session data is stored in user object
		//But in case of Lazy loading data is fetched when we try to access it using user.getListOfAddress()
		//So if FetchType is LAZY then below line will generate error.
		//System.out.println(user.getListOfAddress().size());
	}

}
