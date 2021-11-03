package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Request;
import com.revature.repos.RequestDAO;
import com.revature.repos.RequestDAOImpl;

public class RequestService {
	
	private RequestDAO requestdao = new RequestDAOImpl();
	
	private static Logger Log = LoggerFactory.getLogger(LoginService.class);
	
	
	public boolean postRequest(Request request) {
		
		boolean posted = requestdao.postRequest(request);
		
		Log.info("New Request Posted " + request);
		
		return posted;
		
	}
	
	public List<Request> getAllRequests() {
		
		List<Request> requests = requestdao.getAllRequests();
		
		return requests;
		
	}
	
	public List<Request> getAllRequestsforAccount(int forAccount) {
		
		List<Request> requests = getAllRequests();
		
		List<Request> goodRequests = new ArrayList<Request>();
		
		int activeAccount;
		
		for (int i = 0; i < requests.size(); ++ i) {
		
			activeAccount = requests.get(i).getAccountNumber();
			
			if (activeAccount == forAccount) {
				
				goodRequests.add(requests.get(i));
				
			}
			
		}
		
		return goodRequests;
		
	}
	
	public Request getRequestByID(int ID) {
		
		Request request = requestdao.getRequestByID(ID);
		
		return request;
		
	}
	
	public boolean updateRequest(Request request) {
		
		int id = request.getRequestID();
		
		Request updating = getRequestByID(id);
		
		String updatingStatus = request.getStatus();
		
		String updatingAnswer = request.getAnsweredDate();
		
		updating.setStatus(updatingStatus);
		
		updating.setAnsweredDate(updatingAnswer);
		
		boolean updated = requestdao.updateRequest(updating);
		
		
		Log.info("Request " + request + " Updated");
		
		return updated;
		
		
	}

}
