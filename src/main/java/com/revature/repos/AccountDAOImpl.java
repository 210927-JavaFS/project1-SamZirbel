package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Account;
import com.revature.models.Account;
import com.revature.utils.HibernateUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> getAllAccounts() {
		
		Session session = HibernateUtil.getSession();
		
		return session.createQuery("FROM Account").list();
		
	}

	@Override
	public Account getAccountById(int accountId) {
		
		Session session = HibernateUtil.getSession();
		
		return session.get(Account.class, accountId);
		
	}

	@Override
	public boolean postAccount(Account account) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			System.err.println(account);
			
			session.save(account);
			
			transaction.commit();
			
			return true;
			
		}
		catch (HibernateException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
	
		
	}

	@Override
	public boolean putAccount(Account account) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.merge(account);
			
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
	public boolean deleteAccount(Account account) {

		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.delete(account);
			
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
