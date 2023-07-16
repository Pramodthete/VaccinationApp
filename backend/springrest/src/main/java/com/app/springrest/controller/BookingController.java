package com.app.springrest.controller;

import java.time.LocalDate;
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

import com.app.springrest.Service.BookingService;
import com.app.springrest.dao.BookingDao;
import com.app.springrest.dao.CenterDao;
import com.app.springrest.dao.QtyDao;
import com.app.springrest.dto.CustomRequest;
import com.app.springrest.pojos.Booking;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.QtyVcc;

@RestController
@CrossOrigin
public class BookingController {

	@Autowired
	public BookingDao bdao;
	
	@Autowired
	public CenterDao cdao;
	
	@Autowired
	private QtyDao qtydao;
	
	@Autowired
	public BookingService bService;
	
	@GetMapping("/bookings")
	public List<Booking> findAllBookings(){
		return bdao.findAll();
	}
	
	@PutMapping("/booking/{bid}")
	public Booking updateBooking(@PathVariable long bid) {
		Booking pbook=bdao.findById(bid).orElseThrow();
		
		if(pbook.getUDoseCount()<1) {
		pbook.setVaccinationStatus("TAKEN");
		pbook.setUDoseCount(pbook.getUDoseCount()+1);
		QtyVcc pqv=qtydao.findByQtyCenterAndQtyVaccine(pbook.getCenter(),pbook.getVaccine()).orElseThrow();
		pqv.setQty(pqv.getQty()-1);
		qtydao.save(pqv);
		bdao.save(pbook);
		}
		return pbook;
	}
	
	@PostMapping("/booking/{uid}/{cid}/{vid}")

	public Booking upateBooking(@RequestBody CustomRequest request,
								@PathVariable long uid,@PathVariable long cid,@PathVariable long vid) {	
		System.out.println("idhar aya");
		Booking booking= bService.editBooking(request,uid,cid,vid);
		
		return booking;
	}
	
	@DeleteMapping("/booking/{id}")
	public void deleteBooking(@PathVariable long id) {
		bdao.deleteById(id);
	}
	
	@GetMapping("/bookingCenter/{cid}")
	public List<Booking> FindBookings(@PathVariable long cid) {
	Center c =cdao.findById(cid).orElseThrow();
		return bdao.findByCenter(c);
	}
	
}
