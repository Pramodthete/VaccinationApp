package com.app.springrest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.QtyVcc;
import com.app.springrest.pojos.Vaccine;

@Repository
public interface QtyDao extends JpaRepository<QtyVcc , Long> {

	Optional<QtyVcc> findByQtyCenterAndQtyVaccine(Center center,Vaccine vaccine);

}
