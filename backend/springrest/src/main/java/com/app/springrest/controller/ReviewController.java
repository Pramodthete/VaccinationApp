package com.app.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springrest.Service.ReviewService;
import com.app.springrest.dao.CenterDao;
import com.app.springrest.dao.ReviewDao;
import com.app.springrest.dao.UserDao;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.QtyVcc;
import com.app.springrest.pojos.User;
import com.app.springrest.pojos.Review;
@RestController
@RequestMapping("/")
@CrossOrigin
public class ReviewController {
	
	@Autowired
	public CenterDao cdao;
	
	@Autowired
	public UserDao udao;
	
	@Autowired
	public ReviewDao rdao;
	
	@Autowired
	public ReviewService rservice;


	@GetMapping("/reviews")
	public List<Review> getAllReview(){
		System.out.println(rdao.findAll());
		return rdao.findAll();
	}
	
	@PutMapping("/review/{uid}/{cid}")
	public Review InsertReview(@RequestBody Review r,@PathVariable long uid,@PathVariable long cid) {
		return rservice.persistReview(r,uid,cid);
	}
	
	@PostMapping("/review")
	public Review saveReview(@RequestBody Review r,@PathVariable long uid,@PathVariable long cid) {
		
		return rservice.persistReview(r,uid,cid);

	}
	
	@DeleteMapping("/review/{reviewId}")
	public void removeReview(@PathVariable long reviewId) {
		rdao.deleteById(reviewId);
	}
}
