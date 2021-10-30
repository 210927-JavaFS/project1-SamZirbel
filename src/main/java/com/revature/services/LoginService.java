package com.revature.services;

import java.util.List;

import com.revature.models.Login;
import com.revature.repos.LoginDAO;
import com.revature.repos.LoginDAOImpl;

public class LoginService {
	
	private LoginDAO logindao = new LoginDAOImpl();

	public List<Login> getAllLogin() {
		
		return logindao.getAllLogin();
		
	}
	
	public Login getLoginByUsername(String username) {
		
		Login login = logindao.getLoginByUsername(username);
		
		return (login != null) ? login : new Login();
		
	}

	public boolean postLogin(Login login) {
		
		return logindao.postLogin(login);
		
	}
	
	public boolean putLogin(Login login) {
		
		return logindao.putLogin(login);
		
	}
	
	public boolean deleteLoginByUsername(String username) {
		
		Login login = logindao.getLoginByUsername(username);
		
		return logindao.deleteLogin(login);
		
	}
	
}
