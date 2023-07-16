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
//import com.app.springrest.dao.CenterDao;
//import com.app.springrest.dao.UserDao;
//import com.app.springrest.dao.UserTimeSlotDao;
//import com.app.springrest.dao.UserdateDao;
//import com.app.springrest.pojos.Center;
//import com.app.springrest.pojos.Udosedate;
//import com.app.springrest.pojos.User;
//import com.app.springrest.pojos.Utimeslot;
//
//@RestController
//public class UtimeslotController {
//
//	@Autowired
//	public UserDao usrdao;
//	
//	@Autowired
//	public UserdateDao udtdao;
//	
//	@Autowired
//	public UserTimeSlotDao utimedao;
//	
//	@GetMapping("/utimeslots")
//	public List<Utimeslot> getAllUtimeslot() {
//		return utimedao.findAll();
//	}
//	@PostMapping("/utimeslot")
//	public Utimeslot insertUTimeSlot(@RequestBody  Utimeslot u) {
//		
////		Udosedate d=udtdao.findById(u.getUdosedate().getId()).orElseThrow();
////		User ur=usrdao.findById(u.getTuser().getId()).orElseThrow();
////		
//		Utimeslot persistedslot=utimedao.findById(u.getId()).orElseThrow();
//		u.setTuser(persistedslot.getTuser());
//		u.setUdosedate(persistedslot.getUdosedate());
//	
//		return utimedao.save(u);	
//	}
//	@PutMapping("/utimeslot")
//	public Utimeslot saveUTimeSlot(@RequestBody  Utimeslot u) {
//
//		
//		Utimeslot persistedslot=utimedao.findById(u.getId()).orElseThrow();
//		u.setTuser(persistedslot.getTuser());
//		u.setUdosedate(persistedslot.getUdosedate());
//		
//		
//		return utimedao.save(u);	
//	}
//	@DeleteMapping("/utimeslot/{utimeslotId}")
//	public void removeUtimeSlot(@PathVariable long utimeslotId) {
//		utimedao.deleteById(utimeslotId);
//	}
//	@GetMapping("/utimeslot/{id}")
//	public Utimeslot findByTime(@PathVariable long id ) {
//		
//		//Udosedate l=udatedao.findByUserdosedate(d.getUserdosedate()).orElseThrow();
//		Utimeslot l=utimedao.findById(id).orElseThrow();
//		return l;
//		
//	}
//}
