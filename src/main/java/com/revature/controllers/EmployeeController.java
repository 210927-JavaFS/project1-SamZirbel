package com.revature.controllers;

import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController implements Controller {
	
	private EmployeeService employeeservice = new EmployeeService();
	
	public Handler getAllEmployees = (ctx) -> {
		
		ctx.req.getSession();
		
		if (ctx.req.getSession(false) != null) {
			
			List<Employee> employeelist = employeeservice.getAllEmployees();
			
			ctx.json(employeelist);
			ctx.status(200);
			
		}
		else {
			
			ctx.status(401);
			
		}
		
	};
	
	public Handler getEmployeeByCerealID = (ctx) -> {
		


		ctx.req.getSession();
		
		
		if (ctx.req.getSession(false) != null) {
			
			try {
				
				String readCereal = ctx.pathParam("cereal");
				
				int cerealID = Integer.parseInt(readCereal);
				
				Employee employee = employeeservice.getEmployeeByCerealID(cerealID);
				
				ctx.json(employee);
				ctx.status(200);
				
				
			}
			catch (NumberFormatException e) {
				
				e.printStackTrace();
				
				ctx.status(406);
				
			}
			
		}
		else {
			
			ctx.status(401);
			
		}
			
		
	};
	
	// VV Post Is For Additions
	public Handler postEmployee = (ctx) -> {
		

		ctx.req.getSession();
		
		
		if (ctx.req.getSession(false) != null) {
			
			Employee employee = ctx.bodyAsClass(Employee.class);
			
			if (employeeservice.postEmployee(employee)) {
				
				ctx.status(200);
				
			}
			else {
				
				ctx.status(400);
				
			}
			
		}
		else {
			
			ctx.status(401);
			
		}
		
	};
	
	// VV Put Is For Updates
	public Handler putEmployee = (ctx) -> {
		


		ctx.req.getSession();
		
		
		if (ctx.req.getSession(false) != null) {
			
			Employee employee = ctx.bodyAsClass(Employee.class);
			
			if (employeeservice.putEmployee(employee)) {
				
				ctx.status(200);
				
			}
			else {
				
				ctx.status(400);
				
			}
			
		}
		else {
			
			ctx.status(401);
			
		}
		
	};
	
	public Handler deleteEmployee = (ctx) -> {
		


		ctx.req.getSession();
		
		
		if (ctx.req.getSession(false) != null) {
			
			Employee employee = ctx.bodyAsClass(Employee.class);
			
			if (employeeservice.deleteEmployee(employee)) {
				
				ctx.status(200);
				
			}
			else {
				
				ctx.status(400);
				
			}
			
		}
		else {
			
			ctx.status(401);
			
		}
		
	};
	
	@Override
	public void addRoutes(Javalin app) {
		
		app.get("/employees", this.getAllEmployees);
		
		app.get("/employees/:employee", this.getEmployeeByCerealID);
		
		// VV Post Is For Additions
		app.post("/employees", this.postEmployee);
		
		// VV Put Is For Updates
		app.put("/employees", this.putEmployee);
		
		app.delete("/employees", this.deleteEmployee);
		
	}

}
