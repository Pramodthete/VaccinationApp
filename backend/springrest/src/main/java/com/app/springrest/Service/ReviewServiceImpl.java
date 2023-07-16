package com.app.springrest.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.springrest.dao.CenterDao;
import com.app.springrest.dao.ReviewDao;
import com.app.springrest.dao.UserDao;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.Review;
import com.app.springrest.pojos.User;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao rdao;
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private CenterDao cdao;

@Override
public Review persistReview(Review r,long uid,long cid) {
	User pu=udao.findById(uid).orElseThrow();
	Center pcenter=cdao.findById(cid).orElseThrow();

	r.setCenter(pcenter);
	r.setUser(pu);		
	return rdao.save(r);
}

}
