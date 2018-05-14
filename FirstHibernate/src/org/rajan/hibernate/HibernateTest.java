package org.rajan.hibernate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rajan.dto.Address;
import org.rajan.dto.UserDetails;

public class HibernateTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//User # 1
		UserDetails user=new UserDetails();
		Address addr=new Address();
		//user.setUserId(4); This will be taken care by hibernate as we defined @GeneratedValue for userId variable
		user.setUserName("Santosh");
		user.setAddress("Opposite RTO office");
		user.setJoinedDate(new Date());
		user.setDescription("Entering Santosh's details");
		addr.setCity("Hyderabad");
		addr.setStreet("Lane Opp RTO Ofc");
		
		user.setAddress(addr);
		//User # 2
		UserDetails user2=new UserDetails();
		user2.setUserName("Rajan");
		user2.setDescription("Entering Rajan's details");
		user2.setAddress("Flat no 301,Raghvendra colony");
		user2.setJoinedDate(new Date());
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		/*
		user=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		user=session.get(UserDetails.class, 2);
		System.out.println("UserName returned is : "+user.getUserName());
		*/

	}

}
