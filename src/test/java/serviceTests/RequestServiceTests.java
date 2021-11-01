package serviceTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.models.Request;
import com.revature.services.RequestService;

public class RequestServiceTests {
	
	RequestService requestservice = new RequestService();
	
	
	@Test
	public void t001_postARequest() {
		
		Request request = new Request(700, "Stat", 12, "str", "str", "str", "str");
		
		assertTrue(requestservice.postRequest(request));
		
		
	}
	
	@Test
	public void t002_getAllRequests_RequestsPosting() {
		
		List<Request> requests = requestservice.getAllRequests();
		
		int size = requests.size();
		
		assertTrue(size > 0);
		
	}
	
	

}
