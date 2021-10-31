package com.revature.repos;

import java.util.List;

import com.revature.models.Request;

public interface RequestDAO {

	public List<Request> getAllRequests();
	
	public Request getRequestById(int requestId);
	
	public boolean postRequest(Request request);
	
	public boolean putRequest(Request request);
	
	public boolean deleteRequest(Request request);
	
}
