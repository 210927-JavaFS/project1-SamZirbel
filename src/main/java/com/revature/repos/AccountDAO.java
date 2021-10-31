package com.revature.repos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {
	
	public List<Account> getAllAccounts();
	
	public Account getAccountById(int accountId);
	
	public boolean postAccount(Account account);
	
	public boolean putAccount(Account account);
	
	public boolean deleteAccount(Account account);

}
