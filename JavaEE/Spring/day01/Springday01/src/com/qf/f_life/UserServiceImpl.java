package com.qf.f_life;

public class UserServiceImpl  implements UserService{
	/**
	 * 原始方法，资质创建一个成员变量自己new
	 */
	//private UserDao userDao=new UserDaoImpl();
	
	/**
	 * spring的ioc玩法
	 * 	1.创建一个成员变量
	 * 	2.给他提供setter方法
	 */
	
	
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		System.out.println("setter方法注入userDao");
		this.userDao = userDao;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("say Hello~~~");
		userDao.sayHello();
	}
	
	public	void init(){
		 System.out.println("初始化");
		
	}

	public	void destory(){
	 System.out.println("销毁");
	
}

}
