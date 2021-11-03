package com.revature.repos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Account;
import com.revature.utils.HibernateUtil;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public boolean addAccount(Account account) {

		Session session = HibernateUtil.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(account);
		
		transaction.commit();
		
		return true;
	}

	@Override
	public boolean updateAccount(Account account) {
		
		Session session = HibernateUtil.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.merge(account);
		
		transaction.commit();
		
		return true;
		
	}
	
	

}
