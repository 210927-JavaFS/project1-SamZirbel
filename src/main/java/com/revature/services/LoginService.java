package com.revature.services;

import java.util.Arrays;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Login;
import com.revature.models.Request;
import com.revature.repos.AccountDAO;
import com.revature.repos.AccountDAOImpl;
import com.revature.repos.LoginDAO;
import com.revature.repos.LoginDAOImpl;

public class LoginService {
	
	private LoginDAO logindao = new LoginDAOImpl();
	private AccountDAO accountdao = new AccountDAOImpl();
	

	public List<Login> getAllLogin() {
		
		List<Login> queryResult = logindao.getAllLogin();
		
		//return (queryResult != null) ? queryResult : new List<Login>;
		
		return queryResult;
		
	}
	
	public Login getLoginByUsername(String username) {
		
		Login login = logindao.getLoginByUsername(username);
		
		return (login != null) ? login : new Login();
		
	}

	public boolean postLogin(Login login) {
		
		List<Account> accounts = login.getAccounts();
		
		if (accounts == null) {
			
			List<Account> fixtry001 = Arrays.asList(new Account());
			
			login.setAccounts(fixtry001);
			
		}
		
		return logindao.postLogin(login);
		
	}
	
	public boolean postLogin2(Login login) {
		
		//List<Account> accounts = Arrays.asList(accountdao.postAccount(new Account()));
		
		return false;
		
	}
	
	public boolean putLogin(Login login) {
		
		return logindao.putLogin(login);
		
	}
	
	public boolean deleteLoginByUsername(String username) {
		
		Login login = logindao.getLoginByUsername(username);
		
		return logindao.deleteLogin(login);
		
	}
	
}
