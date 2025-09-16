<<<<<<< Updated upstream:Second-web-application/src/main/java/com/in28minutes/jee/UserValidationService.java
package com.in28minutes.jee;

=======
package com.in28minutes.login;

import org.springframework.stereotype.Service;

//new LoginService()
@Service
>>>>>>> Stashed changes:Second-web-application/src/main/java/com/in28minutes/login/UserValidationService.java
public class UserValidationService {
	
	public boolean isUserValid(String user,String password) {
		if(user.equals("Golu")&& password.equals("12345"))
			return true;
		return false;
	}
}
