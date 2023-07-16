package com.app.springrest.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springrest.pojos.Udosedate;
import com.app.springrest.pojos.User;

@Repository
public interface UserdateDao extends JpaRepository<Udosedate, Long>{


	Optional<Udosedate> findById(long id);

	Optional<Udosedate> findByUserdosedate(LocalDate d);

	
}
