package com.app.springrest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springrest.pojos.CAddress;
import com.app.springrest.pojos.UAddress;
import com.app.springrest.pojos.User;

@Repository
public interface UAddressDao extends JpaRepository<UAddress, Long >{

	List<UAddress> findByUstate(String id);

	List<UAddress> findByUdistrict(String ucity);

	Optional<UAddress> findByUpincode(long upincode);


}
