package com.in28minutes.jee;
//user30
public class UserValidationService {
	
	public boolean isUserValid(String user,String password) {
		if(user.equals("Golu")&& password.equals("12345"))
			return true;
		return false;
	}
}
