package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;
import com.revature.repos.AccountDAO;
import com.revature.repos.AccountDAOImpl;

public class AccountService {
	
	private AccountDAO accountdao = new AccountDAOImpl();
	
	private LoginService loginservice = new LoginService();
	
	private static Logger Log = LoggerFactory.getLogger(LoginService.class);
	
	
	public boolean updateAccount(Account account, String username) {
		
		Account oldAccount = loginservice.findAccountFromUser(username);
		
		String newFirstName = account.getFirstName();
		String newLastName = account.getLastName();
		String newAccountType = account.getAccountType();
		
		oldAccount.setFirstName(newFirstName);
		oldAccount.setLastName(newLastName);
		oldAccount.setAccountType(newAccountType);
		
		boolean complete = false;
		
		complete = accountdao.updateAccount(oldAccount);
		
		Log.info("Account Associated With " + username + " Updated");
		
		return complete;
		
	}

}
