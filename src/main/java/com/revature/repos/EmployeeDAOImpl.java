package com.revature.repos;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.utils.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {
		
		Session session = HibernateUtil.getSession();
		
		return session.createQuery("FROM Employee").list();
		
	}

	@Override
	public Employee getEmployeeByCerealID(int cereal) {
		
		Session session = HibernateUtil.getSession();
		
		return session.get(Employee.class, cereal);
		
	}

	// VV Post Is For Additions
	@Override
	public boolean postEmployee(Employee employee) {
		
		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.save(employee);
			
			transaction.commit();
			
			HibernateUtil.closeSession();
			
			return true;
			
		}
		catch (HibernateException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
	}

	// VV Put Is For Updates
	@Override
	public boolean putEmployee(Employee employee) {
		
		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.merge(employee);
			
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
	public boolean deleteEmployee(Employee employee) {
		
		try {
			
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.delete(employee);
			
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
