package com.revature.controllers;

import java.util.List;

import com.revature.models.Account;
import com.revature.services.AccountService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AccountController implements Controller{
	

	private AccountService accountservice = new AccountService();
	
	
	public Handler getAllAccounts = (ctx) -> {
		
		List<Account> list = accountservice.getAllAccounts();
		
		ctx.json(list);
		ctx.status(200);
		
	};
	
	public Handler getAccountById = (ctx) -> {
		
		String idString = ctx.pathParam("accountId");
		
		int accountId = Integer.parseInt(idString);
		
		Account account = accountservice.getAccountById(accountId);
		
		ctx.json(account);
		ctx.status(200);
		
	};
	
	public Handler postAccount = (ctx) -> {
		
		Account account = ctx.bodyAsClass(Account.class);
		
		System.err.println("Posting Account");
		
		boolean posted = accountservice.postAccount(account);
		
		System.err.println("Posted Account");
		
		if (posted) { ctx.status(200); }
		else { ctx.status(400); }
		
	};
	
	public Handler putAccount = (ctx) -> {
		
		Account account = ctx.bodyAsClass(Account.class);
		
		boolean placed = accountservice.putAccount(account);
		
		if (placed) { ctx.status(202); }
		else { ctx.status(400); }
		
	};
	
	public Handler deleteAccountById = (ctx) -> {
		
		String idString = ctx.pathParam("accountId");
		
		int accountId = Integer.parseInt(idString);
		
		boolean deleted = accountservice.deleteAccountById(accountId);
		
		if (deleted) { ctx.status(200); }
		else { ctx.status(400); }
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {

		app.get("/account", this.getAllAccounts);
		app.get("/account/:accountId", this.getAccountById);
		
		app.post("/account", this.postAccount);
		
		app.put("/account", this.putAccount);
		
		app.delete("/account/:accountId", this.deleteAccountById);
		
	}

}