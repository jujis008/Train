package com.qf.b_di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
	//原来的玩法，自己手动new
	//ivate UserService userService=new UserServiceImpl();
	/**
	 * 想要什么资源去找spring的bean工厂要
	 */
	@Test
	public void run1(){
		//获得bean
		String path="com/qf/b_di/applicationContext.xml";
		//加载spring的配置文件
	//	ClassPathXmlApplicationContext  ac=new ClassPathXmlApplicationContext(path);
		ApplicationContext ac=new ClassPathXmlApplicationContext(path);
		
		//通过id获得bean
		UserService userService = (UserService) ac.getBean("userService");
		UserService userService1 = (UserService) ac.getBean("userService");
		System.out.println(userService); 
		System.out.println(userService1); 
		userService.sayHello();
		
	}

}
