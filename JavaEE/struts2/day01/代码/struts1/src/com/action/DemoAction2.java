package com.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 第三种：继承ActionSupport 类   推荐使用
 * @author tomcat
 *
 */
public class DemoAction2 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5792544077775659249L;
	
	
	
	public  String sayHello(){
		
		System.out.println("ActionSupport!!   ");
		return SUCCESS;
	}

}
