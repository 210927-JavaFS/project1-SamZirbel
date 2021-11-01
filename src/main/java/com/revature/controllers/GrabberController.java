package com.revature.controllers;

import com.revature.models.Account;
import com.revature.models.Login;
import com.revature.services.LoginService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class GrabberController implements Controller {

	private LoginService loginservice = new LoginService();
	
	public Handler getAccount = (ctx) -> {
		
			
		Login pending = ctx.bodyAsClass(Login.class);
			
		String username = pending.getUsername();
		
		Account account = loginservice.findAccountFromUser(username);
		
		account.setLogin(null);
		
		ctx.json(account);
		ctx.status(200);
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {
		
		app.post("/grabber", this.getAccount);
		
	}

}
