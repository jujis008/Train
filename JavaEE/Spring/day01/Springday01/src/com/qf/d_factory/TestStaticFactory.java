package com.qf.d_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	//原来的玩法，自己手动new
	//ivate UserService userService=new UserServiceImpl();
	/**
	 * 想要什么资源去找spring的bean工厂要
	 */
	@Test
	public void run1(){
		//获得bean
		String path="com/qf/c_static_factory/applicationContext.xml";
		//加载spring的配置文件
	//	ClassPathXmlApplicationContext  ac=new ClassPathXmlApplicationContext(path);
		ApplicationContext ac=new ClassPathXmlApplicationContext(path);
		
		//通过id获得bean
		UserService userService = (UserService) ac.getBean("userService");
		userService.sayHello();
		
	}

}
