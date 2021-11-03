package com.revature.controllers;

import com.revature.models.Account;
import com.revature.models.Login;
import com.revature.services.AccountService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UpdaterController implements Controller {
	
	private AccountService accountservice = new AccountService();
	
	public Handler updateAccount = (ctx) -> {
		
		String param = ctx.pathParam("user");
		
		System.out.println(param);
		
		Account pending = ctx.bodyAsClass(Account.class);
		
		System.out.println(pending);
		
		System.out.println("adding User");
		
		boolean added = accountservice.updateAccount(pending, param);
		
		ctx.json(added);
		ctx.status(200);
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {
		
		app.post("/updater/:user", this.updateAccount);
		
	}

}
