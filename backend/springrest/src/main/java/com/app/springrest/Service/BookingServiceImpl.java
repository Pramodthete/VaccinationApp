package com.app.springrest.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springrest.customexception.ResourceNotFoundException;
import com.app.springrest.dao.BookingDao;
import com.app.springrest.dao.CenterDao;
import com.app.springrest.dao.UserDao;
import com.app.springrest.dao.UserdateDao;
import com.app.springrest.dao.VaccineDao;
import com.app.springrest.dto.CustomRequest;
import com.app.springrest.pojos.Booking;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.Review;
import com.app.springrest.pojos.UAddress;
import com.app.springrest.pojos.Udosedate;
import com.app.springrest.pojos.User;
import com.app.springrest.pojos.Vaccine;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	public UserDao udao;
	
	@Autowired
	public CenterDao cdao;
	
	@Autowired
	public VaccineDao vdao;
	
	@Autowired
	public UserdateDao uddao;
	
	@Autowired
	public BookingDao bdao;
	
	@Override
	public Booking editBooking(CustomRequest request, long uid, long cid, long vid) {
		
		
		Booking b =new Booking();
		try {
			//System.out.println("idhar aya tha");
		Udosedate udd= uddao.findByUserdosedate(request.getDate()).orElseThrow();
		b.setUDoseDate(udd);
		}catch (RuntimeException e) {
			//System.out.println("idhar bhi aya");
			Udosedate ud=new Udosedate();
			ud.setUserdosedate(request.getDate());
			// TODO: handle exception
			Udosedate udd=uddao.save(ud);
			b.setUDoseDate(udd);
		}
		//System.out.println("1");
		User u= udao.findById(uid).orElseThrow();
		Center c= cdao.findById(cid).orElseThrow();
		Vaccine v=vdao.findById(vid).orElseThrow();
		//System.out.println("2");
		int var=0;

		if(u.getBooking().isEmpty()) {
			
			
			b.setUTimeSlot(request.getSlot());
			b.setUser(u);
			b.setCenter(c);
			b.setVaccine(v);
			b.setUDoseCount(1);
			b.setVaccinationStatus("NOT_TAKEN");
			return bdao.save(b);
			}
			else {
				//System.out.println("3");
				for(Booking p :u.getBooking()) {
					var++;
				}
					if(var>3) {
						throw new ResourceNotFoundException("Cannot Book more than three vaccine");
					}
				
				b.setUTimeSlot(request.getSlot());
				b.setUser(u);
				b.setCenter(c);
				b.setVaccine(v);
				b.setUDoseCount(var);
				b.setVaccinationStatus("NOT_TAKEN");
				return bdao.save(b);
				
			}

		
//		Review persistedrev=rdao.findById(r.getId()).orElseThrow();
//		
//		r.setCenter(persistedrev.getCenter());
//		r.setUser(persistedrev.getUser());		
//		return rdao.save(r);
	}

	
}
