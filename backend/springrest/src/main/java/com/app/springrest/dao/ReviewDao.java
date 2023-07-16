package com.app.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springrest.pojos.Review;

@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {

}
