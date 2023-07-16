package com.app.springrest.Service;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.springrest.pojos.Review;

public interface ReviewService {
	public Review persistReview(Review  r,long uid,long cid);
}
