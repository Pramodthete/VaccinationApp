package com.app.springrest.Service;

import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.User;

public interface LoginService {

	User authenticateUser(String em, String pass);
	
	Center authenticateCenter(long id, String pass); //service 

}
