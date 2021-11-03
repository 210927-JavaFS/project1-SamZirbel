package com.revature.repos;

import com.revature.models.Account;

public interface AccountDAO {

	
	public boolean addAccount(Account account);
	
	public boolean updateAccount(Account account);
	
}
