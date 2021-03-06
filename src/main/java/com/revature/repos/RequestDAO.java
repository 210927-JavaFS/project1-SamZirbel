package com.revature.repos;

import java.util.List;

import com.revature.models.Request;

public interface RequestDAO {
	
	public boolean postRequest(Request request);
	
	public List<Request> getAllRequests();
	
	public Request getRequestByID(int ID);
	
	public boolean updateRequest(Request request);

}
