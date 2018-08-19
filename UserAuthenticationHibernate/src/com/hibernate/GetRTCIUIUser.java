package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GetRTCIUIUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String queryStr="from RtciUIUser where upper(vzid)='"+"v536131".toUpperCase()+"'";
		Query query=session.createQuery(queryStr);
		List user=query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(user.size());

	}
	
	public boolean validateUser(String vzid)
	{
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String queryStr="from RtciUIUser where upper(vzid)='"+vzid.toUpperCase()+"'";
		Query query=session.createQuery(queryStr);
		List user=query.list();
		session.getTransaction().commit();
		session.close();
		
		if(user.size()>=1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
