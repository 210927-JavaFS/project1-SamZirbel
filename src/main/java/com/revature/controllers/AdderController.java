package com.revature.controllers;

import com.revature.models.Login;
import com.revature.services.LoginService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AdderController implements Controller {
	
	private LoginService loginservice = new LoginService();
	
	public Handler additionMaker = (ctx) -> {
		
		String param = ctx.pathParam("type");
		
		boolean added = false;
		
		if (param.equals("user")) {
			
			Login pending = ctx.bodyAsClass(Login.class);
			
			System.out.println("adding User");
			
			added = loginservice.addNewUser(pending);
			
		}
		
		ctx.json(added);
		ctx.status(200);
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {
		
		app.post("/adder/:type", this.additionMaker);
		
	}

}
