package com.spring.dao;

import org.springframework.stereotype.Repository;

import com.spring.vo.User;


@Repository
public class UserDao {

	public int save(User user) {
		// TODO Auto-generated method stub
		int money = 1000/user.getAge();
		System.out.println("save user ... "+user+"  , he has "+(1000/user.getAge())+" dollars");
		return money;
	}

}
