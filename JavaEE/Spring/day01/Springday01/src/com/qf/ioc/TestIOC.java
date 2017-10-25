package com.qf.ioc;

import org.junit.Test;

public class TestIOC {
	//原来的玩法，自己手动new
	private UserService userService=new UserServiceImpl();
	
	@Test
	public void run1(){
		userService.sayHello();
		
	}

}
