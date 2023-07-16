package com.app.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.springrest.Service.LoginService;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.User;
@RestController
@CrossOrigin
public class ValidationController {

	@Autowired
	public LoginService uservice;
	
	@PostMapping("/user/login")
	public User validateUser(@RequestBody User u) {
		
		return uservice.authenticateUser(u.getEmail(), u.getPassword());
	}
	
	@PostMapping("/center/login") //controller
	public Center validateUser(@RequestBody Center c) {
		System.out.println(c);
		
		return uservice.authenticateCenter(c.getId(), c.getPassword());
	}
	

}
