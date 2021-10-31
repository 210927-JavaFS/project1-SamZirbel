package com.revature.controllers;

import java.util.List;

import com.revature.models.Request;
import com.revature.services.RequestService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class RequestController implements Controller{
	

	private RequestService requestservice = new RequestService();
	
	
	public Handler getAllRequests = (ctx) -> {
		
		List<Request> list = requestservice.getAllRequest();
		
		ctx.json(list);
		ctx.status(200);
		
	};
	
	public Handler getRequestById = (ctx) -> {
		
		String idString = ctx.pathParam("requestId");
		
		int requestId = Integer.parseInt(idString);
		
		Request request = requestservice.getRequestById(requestId);
		
		ctx.json(request);
		ctx.status(200);
		
	};
	
	public Handler postRequest = (ctx) -> {
		
		Request request = ctx.bodyAsClass(Request.class);
		
		System.err.println("Posting Request");
		
		boolean posted = requestservice.postRequest(request);
		
		System.err.println("Posted Request");
		
		if (posted) { ctx.status(200); }
		else { ctx.status(400); }
		
	};
	
	public Handler putRequest = (ctx) -> {
		
		Request request = ctx.bodyAsClass(Request.class);
		
		boolean placed = requestservice.putRequest(request);
		
		if (placed) { ctx.status(202); }
		else { ctx.status(400); }
		
	};
	
	public Handler deleteRequestById = (ctx) -> {
		
		String idString = ctx.pathParam("requestId");
		
		int requestId = Integer.parseInt(idString);
		
		boolean deleted = requestservice.deleteRequestById(requestId);
		
		if (deleted) { ctx.status(200); }
		else { ctx.status(400); }
		
	};
	
	
	@Override
	public void addRoutes(Javalin app) {

		app.get("/request", this.getAllRequests);
		app.get("/request/:requestId", this.getRequestById);
		
		app.post("/request", this.postRequest);
		
		app.put("/request", this.putRequest);
		
		app.delete("/request/:requestId", this.deleteRequestById);
		
	}

}
