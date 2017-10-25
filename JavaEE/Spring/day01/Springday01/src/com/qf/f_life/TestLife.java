package com.qf.f_life;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLife {
	//原来的玩法，自己手动new
	//ivate UserService userService=new UserServiceImpl();
	/**
	 * 想要什么资源去找spring的bean工厂要
	 */
	@Test
	public void run1(){
		//获得bean
		String path="com/qf/f_life/applicationContext.xml";
		//加载spring的配置文件
	//	ClassPathXmlApplicationContext  ac=new ClassPathXmlApplicationContext(path);
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(path);
		
		//通过id获得bean
		UserService userService = (UserService) ac.getBean("userService");
		//UserService userService1 = (UserService) ac.getBean("userService");
		System.out.println(userService); 
		//System.out.println(userService1); 
		userService.sayHello();
		
		//手动吧容器关了
		ac.close();
		
		
	}

}
