package com.revature.services;

import com.revature.models.Request;
import com.revature.repos.RequestDAO;
import com.revature.repos.RequestDAOImpl;

public class RequestService {
	
	private RequestDAO requestdao = new RequestDAOImpl();
	
	public boolean postRequest(Request request) {
		
		boolean posted = requestdao.postRequest(request);
		
		return posted;
		
	}

}
