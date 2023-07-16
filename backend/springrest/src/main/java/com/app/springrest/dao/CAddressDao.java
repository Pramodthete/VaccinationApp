package com.app.springrest.dao;


import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.springrest.pojos.CAddress;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.UAddress;

public interface CAddressDao extends JpaRepository<CAddress, Long>{



	Optional<CAddress> findByCpincode(long cpincode);

	List<CAddress> findByCstate(String ustate);

	List<CAddress> findByCdistrict(String cstate);

}
