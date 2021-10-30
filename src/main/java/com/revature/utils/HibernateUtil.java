package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionfactory = 
			new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	// << Going To Use A Singleton Design Pattern For Session
	// << For What We Are Doing It Doesn't Make Sense To Have Multiple Sessions
	// << Multithreading May Require Multiple Sessions
	private static Session session;
	
	// VV Standard Singleton Design Pattern
	// VV Only Ever One Session At A Time
	public static Session getSession() {
		
		if (session == null) { session = sessionfactory.openSession(); }
		
		return session;
		
	}
	
	public static void closeSession() {
		
		if (session != null) { 
			
			//session.flush();
			session.close(); 
			
		}
		
		session = null;
		
	}
	
	

}
