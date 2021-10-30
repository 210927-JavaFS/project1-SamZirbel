package com.revature.controllers;

import java.util.List;

import com.revature.models.Login;
import com.revature.services.LoginService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class LoginController implements Controller{
	
	private LoginService loginservice = new LoginService();
	
	
	public Handler getAllLogins = (ctx) -> {
		
		List<Login> list = loginservice.getAllLogin();
		
		ctx.json(list);
		ctx.status(200);
		
	};
	
	public Handler getLoginByUsername = (ctx) -> {
		
		String username = ctx.pathParam("username");
		
		Login login = loginservice.getLoginByUsername(username);
		
		ctx.json(login);
		ctx.status(200);
		
	};
	
	public Handler postLogin = (ctx) -> {
		
		Login login = ctx.bodyAsClass(Login.class);
		
		boolean posted = loginservice.postLogin(login);
		
		if (posted) { ctx.status(200); }
		else { ctx.status(400); }
		
	};
	
	public Handler putLogin = (ctx) -> {
		
		Login login = ctx.bodyAsClass(Login.class);
		
		boolean placed = loginservice.putLogin(login);
		
		if (placed) { ctx.status(202); }
		else { ctx.status(400); }
		
	};
	
	public Handler deleteLoginByUsername = (ctx) -> {
		
		String username = ctx.pathParam("username");
		
		boolean deleted = loginservice.deleteLoginByUsername(username);
		
		if (deleted) { ctx.status(200); }
		else { ctx.status(400); }
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {

		app.get("/login", this.getAllLogins);
		app.get("/login/:username", this.getLoginByUsername);
		
		app.post("/login", this.postLogin);
		
		app.put("/login", this.putLogin);
		
		app.delete("/login/:username", this.deleteLoginByUsername);
		
	}

}
