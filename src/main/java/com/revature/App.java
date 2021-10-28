package com.revature;

import com.revature.controllers.Controller;
import com.revature.controllers.EmployeeController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
	
	public static Javalin app;
	
	public static void main(String[] args) {
		
		app = Javalin.create((config) -> {
			
			config.addStaticFiles("/Static", Location.CLASSPATH);
			
		});
				
		configure(new EmployeeController());
		
		app.start(5432);
		
	}
	
	private static void configure(Controller ... controllers) {
		
		for (Controller activecontroller : controllers) {
			
			activecontroller.addRoutes(app);
			
		}
		
	}

}
