package com.app.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springrest.pojos.Vaccine;

@Repository
public interface VaccineDao extends JpaRepository<Vaccine,Long> {
	
}
