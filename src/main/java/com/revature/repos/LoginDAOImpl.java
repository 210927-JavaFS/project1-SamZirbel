package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Login;
import com.revature.utils.HibernateUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public Login getLoginByName(String username) {
		
		Session session = HibernateUtil.getSession();
		
		Login login = session.get(Login.class, username);
		
		HibernateUtil.closeSession();
		
		return login;
		
	}
	
	@Override
	public List<Login> getAllLogins() {
		
		Session session = HibernateUtil.getSession();
		
		List<Login> logins = session.createQuery("FROM Login").list();
		
		HibernateUtil.closeSession();
		
		return logins;
		
	}

	@Override
	public boolean addUser(Login login) {
		
		Session session = HibernateUtil.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(login);
		
		transaction.commit();
		
		return true;
	}
	
	

}
