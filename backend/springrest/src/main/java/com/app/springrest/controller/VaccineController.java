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

import com.app.springrest.dao.VaccineDao;
import com.app.springrest.pojos.Vaccine;
@RestController
@CrossOrigin
public class VaccineController {
	
	@Autowired
	public VaccineDao vdao;
	
	@GetMapping("/vaccines")
	public List<Vaccine> getAllVaccines(){
		return vdao.findAll();
	}
	
	@PostMapping("/vaccines")
	public Vaccine InsertVaccine(@RequestBody Vaccine v) {
		return vdao.save(v);
	}
	
	@PutMapping("/vaccines")
	public Vaccine updateVaccine(@RequestBody Vaccine v) {
		return vdao.save(v);
	}
	
	@DeleteMapping("/vaccines/{vId}")
	public void removeVaccine(@PathVariable long vId) {
		vdao.deleteById(vId);
	}
}
