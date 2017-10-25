package com.qf.c_static_factory;

public class UserServiceFactory {
	/**
	 * 实例工厂
	 */

	public  UserService getUserService(){
		System.out.println("实例工厂UserServiceFactory");
		return new UserServiceImpl();
	}
}
