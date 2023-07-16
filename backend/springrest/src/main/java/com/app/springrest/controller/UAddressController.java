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

import com.app.springrest.dao.UAddressDao;
import com.app.springrest.pojos.UAddress;
import com.app.springrest.pojos.User;

@RestController
@CrossOrigin
public class UAddressController {

	@Autowired
	public UAddressDao uadao;
	
	@GetMapping("/uaddresses")
	public List<UAddress> getAllUAddress(){
		return uadao.findAll();
	}
	
	@PostMapping("/uaddress")
	public UAddress InsertUAddress(@RequestBody UAddress a) {
		return uadao.save(a);
	}
	
	@PutMapping("/uaddress")
	public UAddress updateUAddress(@RequestBody UAddress a) {
		return uadao.save(a);
	}
	
	@DeleteMapping("/uaddress/{uaid}")
	public void removeUAddress(@PathVariable long uaid) {
		uadao.deleteById(uaid);
	}
	
	@GetMapping("/usersAdd/{ustate}")
	public List<UAddress> getAddressByState(@PathVariable String ustate) {
		List<UAddress> saddr=uadao.findByUstate(ustate);
		return saddr;
	}
	
	@GetMapping("/userAdd/{ucity}")
	public List<UAddress> getAddressByCity(@PathVariable String ucity) {
		List<UAddress> caddr=uadao.findByUdistrict(ucity);
		return caddr;
	}
	
	@GetMapping("/address/{id}")
	public UAddress getaddr(@PathVariable long id) {
		UAddress caddrUsers=uadao.findById(id).orElseThrow();
		return caddrUsers;
	}
	
}
