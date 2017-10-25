package com.qf.d_factory;

public class UserServiceFactory {
	/**
	 * 静态工厂
	 */

	public static UserService getUserService(){
		System.out.println("静态工厂UserServiceFactory");
		return new UserServiceImpl();
	}
}
