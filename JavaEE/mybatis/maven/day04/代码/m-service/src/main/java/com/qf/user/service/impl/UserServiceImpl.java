package com.qf.user.service.impl;

import org.springframework.stereotype.Service;

import com.qf.user.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("service~~~~~~~");
	}

}
