package com.in28minutes.login;

import org.springframework.stereotype.Service;

//new LoginService() Auto wiring
//checking user

@Service
public class UserValidationService {
	
	public boolean isUserValid(String user,String password) {
		if(user.equals("Golu")&& password.equals("12345"))
			return false;
		return false;
	}
}
