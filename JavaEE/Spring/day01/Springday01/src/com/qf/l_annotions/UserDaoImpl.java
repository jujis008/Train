package com.qf.l_annotions;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("annotion dao~~");
	}

}
