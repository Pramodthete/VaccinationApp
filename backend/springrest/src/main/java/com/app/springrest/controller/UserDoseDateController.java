package com.app.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.springrest.dao.UserdateDao;
import com.app.springrest.pojos.Udosedate;

@RestController
@CrossOrigin
public class UserDoseDateController {

	@Autowired
	public UserdateDao udatedao;


	@GetMapping("/udosedates")
	public List<Udosedate>getAllUdoseDate(){
		return udatedao.findAll();
	}
	@PostMapping("/udosedate")
	public Udosedate InsertUDoseDate(@RequestBody Udosedate u) {
		return udatedao.save(u);
	}
	@PutMapping("/udosedate")
	public Udosedate saveUDoseDate(@RequestBody Udosedate  u) {
		return udatedao.save(u);	
	}
	
	@DeleteMapping("/udosedate/{udosedateId}")
	public void removeUDoseDate(@PathVariable long udosedateId) {
		udatedao.deleteById(udosedateId);
	}
	@GetMapping("/xyz/{idc}")
	public Udosedate findByDate(@PathVariable long id ) {
		
		//Udosedate l=udatedao.findByUserdosedate(d.getUserdosedate()).orElseThrow();
		Udosedate l=udatedao.findById(id).orElseThrow();
		return l;
		
	}
	
    }
