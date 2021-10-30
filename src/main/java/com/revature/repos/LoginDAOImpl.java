package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Login;
import com.revature.utils.HibernateUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public List<Login> getAllLogin() {

		Session session = HibernateUtil.getSession();
		
		return session.createQuery("FROM Login").list();
	
	}

	@Override
	public Login getLoginByUsername(String username) {

		Session session = HibernateUtil.getSession();
		
		return session.get(Login.class, username);
		
	}

	@Override
	public boolean postLogin(Login login) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.save(login);
			
			transaction.commit();
			
			return true;
			
		}
		catch (HibernateException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
	
	
	}

	@Override
	public boolean putLogin(Login login) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.merge(login);
			
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
	public boolean deleteLogin(Login login) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.delete(login);
			
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
