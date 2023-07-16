package com.app.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springrest.pojos.Booking;
import com.app.springrest.pojos.Center;


@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {

	List<Booking> findByCenter(Center cid);

	
}
