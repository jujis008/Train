package com.qf.k_collections;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollections {
	//原来的玩法，自己手动new
	//ivate UserService userService=new UserServiceImpl();
	/**
	 * 想要什么资源去找spring的bean工厂要
	 */
	@Test
	public void run1(){
		//获得bean
		String path="com/qf/k_collections/applicationContext.xml";
		//加载spring的配置文件
	//	ClassPathXmlApplicationContext  ac=new ClassPathXmlApplicationContext(path);
		ApplicationContext ac=new ClassPathXmlApplicationContext(path);
		
		//通过id获得bean
		User bean =  ac.getBean("user",User.class);
		
		System.out.println(bean);
	}

}
