package com.spring.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.dao.UserDao;
import com.spring.vo.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}
