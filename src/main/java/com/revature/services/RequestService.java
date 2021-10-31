package com.revature.services;

import java.util.Arrays;
import java.util.List;

import com.revature.models.Request;
import com.revature.repos.RequestDAO;
import com.revature.repos.RequestDAOImpl;

public class RequestService {
	
	private RequestDAO requestdao = new RequestDAOImpl();
	

	public List<Request> getAllRequest() {
		
		List<Request> queryResult = requestdao.getAllRequests();
		
		return queryResult;
		
	}
	
	public Request getRequestById(int requestId) {
		
		Request request = requestdao.getRequestById(requestId);
		
		return (request != null) ? request : new Request();
		
	}

	public boolean postRequest(Request request) {
		
		return requestdao.postRequest(request);
		
	}
	
	
	public boolean putRequest(Request request) {
		
		return requestdao.putRequest(request);
		
	}
	
	public boolean deleteRequestById(int requestId) {
		
		Request request = requestdao.getRequestById(requestId);
		
		return requestdao.deleteRequest(request);
		
	}

}
