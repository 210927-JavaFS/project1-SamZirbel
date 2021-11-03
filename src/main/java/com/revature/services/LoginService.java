package com.revature.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;
import com.revature.models.Login;
import com.revature.repos.AccountDAO;
import com.revature.repos.AccountDAOImpl;
import com.revature.repos.LoginDAO;
import com.revature.repos.LoginDAOImpl;
import com.revature.utils.encryptDecryptUtil;

public class LoginService {
	
	private LoginDAO logindao = new LoginDAOImpl();
	private AccountDAO accountdao = new AccountDAOImpl();
	
	private static Logger Log = LoggerFactory.getLogger(LoginService.class);

	
	public boolean validateUniqueUsername(String username) {
		
		System.out.println("");
		
		List<Login> logins = logindao.getAllLogins();
		
		System.out.println(logins);
		
		int logincount = logins.size();
		
		boolean result = true;
		
		String activeUsername;
		
		for (int i = 0; i < logincount; ++ i) {
			
			activeUsername = logins.get(i).getUsername();
			
			if (username.equals(activeUsername)) {
				
				Log.info("Login Unsuccessful : Password Match");
				
				result = false;
				i = logincount;
				
			}
			
			
		}
		
		return result;
		
	}

	public boolean addNewUser(Login login) {
		
		Account account = new Account();
		
		boolean accountAdded = accountdao.addAccount(account);
		
		login.setAccount(account);
		
		String password = login.getPassword();
		
		password = encryptDecryptUtil.encryptDecrypt(password);
		
		login.setPassword(password);
		
		boolean loginAdded = logindao.addUser(login);
		
		account.setLogin(login);
		
		boolean accountUpdated = accountdao.updateAccount(account);
		
		boolean returning;
		
		if (accountAdded && accountUpdated && loginAdded) {
			
			returning = true;
			
		}
		else {
			
			Log.debug("Account Addition Status : " + accountAdded);
			Log.debug("Accout Update Status : " + accountUpdated);
			Log.debug("Login Addition Status : " + loginAdded);
			
			returning = false;
			
		}
		
		return returning;
		
	}

	public Login getLoginByName(String username) {
		
		Login login = logindao.getLoginByName(username);
		
		return login;
		
	}
	
	public Account findAccountFromUser(String username) {
		
		Login login = getLoginByName(username);
		
		Account account = login.getAccount();
		
		return account;
		
	}

	public boolean verifyUser(Login login) {
	
		String inputUsername = login.getUsername();
		String inputPassword = login.getPassword();
		
		inputPassword = encryptDecryptUtil.encryptDecrypt(inputPassword);
		
		// VV Check Matches Username To Table
		// VV It Checks For The Username By The Result
		Login check = getLoginByName(inputUsername);
		
		boolean aok = false;
		
		if (check != null && inputPassword.equals(check.getPassword())) {
			
			Log.info("Password Matching Successful");
			
			aok = true;
			
		}
		
		return aok;
		
	}
	
	
}
