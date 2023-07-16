package com.app.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.springrest.Service.UserService;
import com.app.springrest.dao.UAddressDao;
import com.app.springrest.dao.UserDao;
import com.app.springrest.pojos.Booking;
import com.app.springrest.pojos.Review;
import com.app.springrest.pojos.UAddress;
import com.app.springrest.pojos.User;
@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	public UserDao udao;
	
	@Autowired
	public UAddressDao uadao;
	
	@Autowired
	public UserService uService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return udao.findAll();
	}
	@PostMapping("/user")
	public User InsertUser(@RequestBody User u) {
		try {
	UAddress puad=	uadao.findByUpincode(u.getUaddress().getUpincode()).orElseThrow();
				u.setUaddress(puad);
			return udao.save(u);
		
		}catch (RuntimeException e) {
			UAddress puad=uadao.save(u.getUaddress());
			u.setUaddress(puad);
			return udao.save(u);
		}
		
	}
	
	@PutMapping("/userr/{uid}")
	public User saveUser(@RequestBody User u,@PathVariable long uid) {		
		User persistedusr=udao.findById(uid).orElseThrow();
		persistedusr.setFirstname(u.getFirstname());
		persistedusr.setLastname(u.getLastname());
		persistedusr.setAge(u.getAge());
		persistedusr.setEmail(u.getEmail());
		return udao.save(persistedusr);
	}
	
	@DeleteMapping("/user/{userId}")
	public void removeUser(@PathVariable long userId) {
		udao.deleteById(userId);
	}
	
	@GetMapping("/user/{uid}")
	public Optional<User> findUById(@PathVariable long uid) {
		return udao.findById(uid);
	}
	
	
	@GetMapping("/admin/getusers/{fid}/{lid}")                                 //for Admin
	public List<User> findUsers(@PathVariable short fid,@PathVariable short lid){
		
		return udao.findByAgeBetween(fid,lid);
	}
	
	
	
}
