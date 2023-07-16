package com.app.springrest.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springrest.GlobleException.GlobleExceptionHandler;
import com.app.springrest.dao.CenterDao;
import com.app.springrest.dao.UserDao;
import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.User;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	public UserDao udao;
	
	@Autowired
	public CenterDao cdao;

	@Override
	public User authenticateUser(String em, String pass) {

		// currently no B.L
			User user = udao.findByEmailAndPassword(em, pass)
					.orElseThrow();
		
			return user;

	}

	@Override
	public Center authenticateCenter(long id, String pass) { //serviceImpl
		Center center = cdao.findByIdAndPassword(id, pass)
				.orElseThrow();		
		return center;
	}
}
