package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		System.out.println("service~~~~~~~");
		userDao.add(user);
		return true;
	}

}
