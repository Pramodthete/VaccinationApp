package com.app.springrest.Service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springrest.dao.BookingDao;
import com.app.springrest.dao.CenterDao;
import com.app.springrest.dao.ReviewDao;
import com.app.springrest.dao.UAddressDao;
import com.app.springrest.dao.UserDao;
import com.app.springrest.dao.UserdateDao;
import com.app.springrest.dao.VaccineDao;
import com.app.springrest.pojos.Booking;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.Review;
import com.app.springrest.pojos.UAddress;
import com.app.springrest.pojos.Udosedate;
import com.app.springrest.pojos.User;
import com.app.springrest.pojos.Vaccine;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao udao;
	
	@Autowired
	public UAddressDao uadao;
	
	@Autowired
	public BookingDao bdao;
	
	@Autowired
	public ReviewDao rdao;

	
	

	
}
