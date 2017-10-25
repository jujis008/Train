package com.qf.aspectJ;

import org.springframework.stereotype.Service;

@Service//UserServiceImpl  类名的首字母小写
public class UserServiceImpl implements UserSrvice{

	@Override
	public void add() {
		// TODO Auto-generated method stub
		//int x=10/0;
		System.out.println("add");
	}

	@Override
	public void delte() {
		// TODO Auto-generated method stub
		System.out.println("delete");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("update");
	}

	@Override
	public void query() {
		// TODO Auto-generated method stub
		System.out.println("query");
	}

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		System.out.println("hello"); 
		return "hello World";
	}

}
