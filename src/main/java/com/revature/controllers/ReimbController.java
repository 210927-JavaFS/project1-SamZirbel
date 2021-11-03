package com.revature.controllers;

import java.util.List;

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
	
	public Handler getAllMyRequests = (ctx) -> {
		
		String paramString = ctx.pathParam("who");
		
		int param = Integer.parseInt(paramString);
		
		System.err.println("Account : " + param);
		
		List<Request> requests = requestservice.getAllRequestsforAccount(param);
		
		System.err.println(requests);
		
		ctx.json(requests);
		ctx.status(200);

		
	};
	
	public Handler getAllRequests = (ctx) -> {
		
		List<Request> requests = requestservice.getAllRequests();
		
		ctx.json(requests);
		ctx.status(200);
		
	};
	
	public Handler updateRequest = (ctx) -> {
		
		Request request = ctx.bodyAsClass(Request.class);
		
		boolean updated = requestservice.updateRequest(request);
		
		ctx.json(updated);
		ctx.status(200);
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {
		
		app.get("/reimb/:who", this.getAllMyRequests);
		
		app.get("/reimb", this.getAllRequests);
		
		app.post("/reimb", this.postReimbursement);
		
		app.post("/reimb/:flag", this.updateRequest);
		
	}
	

}
