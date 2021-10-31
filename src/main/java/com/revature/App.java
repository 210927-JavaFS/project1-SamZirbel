package com.revature;

import org.eclipse.jetty.util.log.Log;

import com.revature.controllers.AccountController;
import com.revature.controllers.Controller;
import com.revature.controllers.LoginController;
import com.revature.controllers.RequestController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {


	private static Javalin app;
	
	public static void main(String[] args) {
		
		app = Javalin.create((config)->{
		
			config.addStaticFiles("/static", Location.CLASSPATH);
				
		});
		
		configure(new RequestController(), new AccountController(), new LoginController());
		
		
		app.start(8081);
		
	}
	
	private static void configure(Controller ... controllers) {
	
		for (Controller c : controllers) {
		
			c.addRoutes(app);
			
		}
		
	}
	
}
