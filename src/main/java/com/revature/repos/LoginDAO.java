package com.revature.repos;

import java.util.List;

import com.revature.models.Login;

public interface LoginDAO {
	
	public List<Login> getAllLogin();
	
	public Login getLoginByUsername(String username);

	public boolean postLogin(Login login);
	
	public boolean putLogin(Login login);
	
	public boolean deleteLogin(Login login);
	
}
