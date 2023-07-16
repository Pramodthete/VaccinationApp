package com.app.springrest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.User;

@Repository
public interface CenterDao extends JpaRepository<Center, Long>{

	Optional<Center> findByIdAndPassword(long id, String pass);//dao

	
}
