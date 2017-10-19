package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import com.qf.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao =new UserDaoImpl();
	
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			userDao.save(user);
			flag=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		finally {
			return flag;
		}
		
	}

}
