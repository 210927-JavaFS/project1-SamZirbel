package com.revature.repos;

import java.util.List;

import com.revature.models.Login;

public interface LoginDAO {
	
	public Login getLoginByName(String username);
	
	public List<Login> getAllLogins();
	
	public boolean addUser(Login login);

}
