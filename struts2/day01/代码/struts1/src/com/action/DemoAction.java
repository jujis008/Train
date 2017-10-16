package com.action;
/**
 * 第一种：普通的javabean
 * @author tomcat
 *
 */
public class DemoAction {
	
	public String sayHello(){
		System.out.println("hello~~~~");
		
		return "hello";
	}

}
