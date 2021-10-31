package com.revature.services;

import java.util.Arrays;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Request;
import com.revature.repos.AccountDAO;
import com.revature.repos.AccountDAOImpl;
import com.revature.repos.RequestDAO;
import com.revature.repos.RequestDAOImpl;

public class AccountService {


	private AccountDAO accountdao = new AccountDAOImpl();
	private RequestDAO requestdao = new RequestDAOImpl();
	

	public List<Account> getAllAccounts() {
		
		List<Account> queryResult = accountdao.getAllAccounts();
		
		return queryResult;
		
	}
	
	public Account getAccountById(int accountId) {
		
		Account account = accountdao.getAccountById(accountId);
		
		return (account != null) ? account : new Account();
		
	}

	public boolean postAccount(Account account) {
		
		List<Request> requests = account.getRequests();
		
		if (requests == null) {
			
			List<Request> fixtry001 = Arrays.asList(new Request());
			
			//requests = fixtry001;
			
			account.setRequests(fixtry001);
			
		}
		
		return accountdao.postAccount(account);
		
	}
	
	
	public boolean putAccount(Account account) {
		
		return accountdao.putAccount(account);
		
	}
	
	public boolean deleteAccountById(int accountId) {
		
		Account account = accountdao.getAccountById(accountId);
		
		List<Request> requests = account.getRequests();
		
		/*
		for (int i = 0; i < requests.size(); ++ i) {
			
			Request activerequest = requests.get(i);

			requests.remove(i);
			
			requestdao.deleteRequest(activerequest);
			
		}
		
		requests = null;
		*/
		
		
		System.err.println("Deleted Requests");
		
		return accountdao.deleteAccount(account);
		
	}
	
	
}
