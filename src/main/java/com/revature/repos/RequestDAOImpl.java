package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Request;
import com.revature.utils.HibernateUtil;

public class RequestDAOImpl implements RequestDAO{

	@Override
	public boolean postRequest(Request request) {
	
		Session session = HibernateUtil.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(request);
		
		transaction.commit();
		
		HibernateUtil.closeSession();
		
		return true;
		
	}

	@Override
	public List<Request> getAllRequests() {
		
		Session session = HibernateUtil.getSession();
		
		List<Request> requests = session.createQuery("FROM Request").list();
		
		HibernateUtil.closeSession();
		
		return requests;
		
	}

	
	
}
