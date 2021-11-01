package com.revature.services;

import com.revature.models.Account;
import com.revature.repos.AccountDAO;
import com.revature.repos.AccountDAOImpl;

public class AccountService {
	
	private AccountDAO accountdao = new AccountDAOImpl();
	
	private LoginService loginservice = new LoginService();
	
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
		
		return complete;
		
	}

}
