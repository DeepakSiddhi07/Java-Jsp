
package com.in28minutes.login;

import org.springframework.stereotype.Service;

//new LoginService()
@Service
public class UserValidationService {
	
	public boolean isUserValid(String user,String password) {
		if(user.equals("Golu")&& password.equals("12345"))
			return true;
		return false;
	}
}
