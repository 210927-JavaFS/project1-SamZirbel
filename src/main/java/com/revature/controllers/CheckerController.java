package com.revature.controllers;

import java.util.ArrayList;

import com.revature.models.Login;
import com.revature.services.LoginService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CheckerController implements Controller {

	private LoginService loginservice = new LoginService();
	
	public Handler usernameCheck = (ctx) -> {
		
		Login pending = ctx.bodyAsClass(Login.class);
		
		System.out.println(pending);
		
		String username = pending.getUsername();
		
		boolean unique = loginservice.validateUniqueUsername(username);
		
		ctx.json(unique);
		ctx.status(200);
		
	};
	
	public Handler userLoginCheck = (ctx) -> {
		
		Login pending = ctx.bodyAsClass(Login.class);
		
		System.err.println(pending);
		
		boolean verified = loginservice.verifyUser(pending);
		
		ctx.json(verified);
		ctx.status(200);
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {
		
		app.post("/checker", this.usernameCheck);
		
		app.post("/checker/:type", this.userLoginCheck);
		
	}

}
