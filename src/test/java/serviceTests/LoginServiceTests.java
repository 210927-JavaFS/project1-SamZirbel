package serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.models.Login;
import com.revature.services.LoginService;

public class LoginServiceTests {
	
	LoginService loginservice = new LoginService();
	
	@Test
	public void t001_newUserTest() {
		
		Login login = new Login("utu001", "utp001", null);
		
		assertEquals(true, loginservice.addNewUser(login));
		
		
	}

}
