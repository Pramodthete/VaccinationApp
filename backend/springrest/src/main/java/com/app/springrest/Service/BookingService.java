package com.app.springrest.Service;

import java.time.LocalDate;

import com.app.springrest.dto.CustomRequest;
import com.app.springrest.pojos.Booking;
import com.app.springrest.pojos.Udosedate;
import com.app.springrest.pojos.User;

public interface BookingService {

	

	Booking editBooking(CustomRequest request, long uid, long cid, long vid);


}
