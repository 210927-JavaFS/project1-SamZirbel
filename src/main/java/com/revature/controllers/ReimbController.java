package com.revature.controllers;

import com.revature.models.Request;
import com.revature.services.RequestService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbController implements Controller {
	
	private RequestService requestservice = new RequestService();
	
	public Handler postReimbursement = (ctx) -> {
		
		Request request = ctx.bodyAsClass(Request.class);
		
		System.out.println(request);
		
		boolean posted = requestservice.postRequest(request);
		
		ctx.json(posted);
		ctx.status(200);
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {
		
		app.post("/reimb", this.postReimbursement);
		
	}
	

}
