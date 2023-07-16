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

import com.app.springrest.dao.CenterDao;
import com.app.springrest.dao.QtyDao;
import com.app.springrest.dao.VaccineDao;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.QtyVcc;
import com.app.springrest.pojos.User;
import com.app.springrest.pojos.Vaccine;
@RestController
@CrossOrigin
public class QtyController {
	@Autowired
	public QtyDao qtydao;
	
	@Autowired
	public CenterDao cdao;
	

	@Autowired
	public VaccineDao vdao;
	
	@GetMapping("/quantities")


	public List<QtyVcc> getAllQty(){
		return qtydao.findAll();
	}
	
	@PostMapping("/quantity/{cid}/{vid}")
	public QtyVcc InsertQty(@RequestBody QtyVcc q,@PathVariable long cid,@PathVariable long vid) {
		Center persistedcenter =cdao.findById(cid).orElseThrow();
		Vaccine persidtedvaccine =vdao.findById(vid).orElseThrow();
		q.setQtyCenter(persistedcenter);
		q.setQtyVaccine(persidtedvaccine);
		
		return qtydao.save(q);
	}
	
	@PutMapping("/quantity/{qtyvccid}")
	public QtyVcc updateQty(@RequestBody QtyVcc q,@PathVariable long qtyvccid) {

		
		QtyVcc persistedqty=qtydao.findById(qtyvccid).orElseThrow();
		
		//Vaccine persistedvcc=vdao.findById(q.getQtyVaccine().getId()).orElseThrow();
			
			persistedqty.setQty(q.getQty());
		
		return qtydao.save(persistedqty);
		
	}
	
	@DeleteMapping("/quantity/{qid}")
	public  void deleteQty(@PathVariable long qid) {
		qtydao.deleteById(qid);
	}
}
