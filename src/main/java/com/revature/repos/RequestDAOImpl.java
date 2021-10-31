package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Request;
import com.revature.utils.HibernateUtil;

public class RequestDAOImpl implements RequestDAO{

	@Override
	public List<Request> getAllRequests() {
		
		Session session = HibernateUtil.getSession();
		
		return session.createQuery("FROM Request").list();
		
	}

	@Override
	public Request getRequestById(int requestId) {
		
		Session session = HibernateUtil.getSession();
		
		return session.get(Request.class, requestId);
		
	}

	@Override
	public boolean postRequest(Request request) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			System.err.println(request);
			
			session.save(request);
			
			transaction.commit();
			
			return true;
			
		}
		catch (HibernateException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
	
		
	}

	@Override
	public boolean putRequest(Request request) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.merge(request);
			
			transaction.commit();
			
			HibernateUtil.closeSession();
			
			return true;
			
		}
		catch (HibernateException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}

	@Override
	public boolean deleteRequest(Request request) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.delete(request);
			
			transaction.commit();
			
			HibernateUtil.closeSession();
			
			return true;
			
		}
		catch (HibernateException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}

}
