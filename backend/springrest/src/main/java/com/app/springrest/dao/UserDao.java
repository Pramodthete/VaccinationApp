package com.app.springrest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springrest.pojos.User;

@Repository
 public interface UserDao extends JpaRepository<User, Long>{

	Optional<User> findByEmailAndPassword(String em,String pass);

	//List<User> getByPaystatus(String p);

	List<User> findByAgeBetween(short fid, short lid);


	Optional<User> findByIdAndPassword(long id, String pass);

	
}


