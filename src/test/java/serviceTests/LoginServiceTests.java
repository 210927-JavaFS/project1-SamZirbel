package serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.models.Login;
import com.revature.services.LoginService;

public class LoginServiceTests {
	
	LoginService loginservice = new LoginService();
	
	// Should Set To Create For Testing This One
	/*
	@Test
	public void t001_newUserTest() {
		
		Login login = new Login("utu001", "utp001", null);
		
		assertEquals(true, loginservice.addNewUser(login));
		
		
	}
	*/
	
	
	@Test
	public void t002_FindUserByName() {
		
		String tusername = "utu001";
		
		assertEquals(true, loginservice.findAccountFromUser(tusername));
		
	}
	
	
	@Test
	public void t003_VerifyUser() {
		
		Login login = new Login("utu001", "utp001", null);
		
		assertEquals(true, loginservice.verifyUser(login));
		
	}
	
	@Test
	public void t004_NotVerifyUser() {
		
		Login login = new Login("utu002", "utp002", null);
		
		assertEquals(false, loginservice.verifyUser(login));
		
	}
	
	

}
