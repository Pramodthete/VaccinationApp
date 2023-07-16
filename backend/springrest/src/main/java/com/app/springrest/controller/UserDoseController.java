//package com.app.springrest.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.springrest.dao.UserDoseDao;
//import com.app.springrest.pojos.Dose;
//import com.app.springrest.pojos.User;
//
//@RestController
//public class UserDoseController {
//
//	@Autowired
//	public UserDoseDao udosedao;
//	
//	@GetMapping("/doses")
//	public List<Dose> getallDosetype(){
//		return udosedao.findAll();
//	}
//	
//	@PostMapping("/dose")
//	public Dose insertDose(@RequestBody Dose d) {
//		return udosedao.save(d);
//	}
//	
//	@PutMapping("/dose")
//	public Dose saveDose(@RequestBody Dose  d) {	
//		return udosedao.save(d);
//	}
//	
//	
//	@DeleteMapping("/dose/{doseId}")
//	public void removeDose(@PathVariable long doseId) {
//		udosedao.deleteById(doseId);
//	}
//	
//	
//}
