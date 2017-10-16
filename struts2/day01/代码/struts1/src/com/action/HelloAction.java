package com.action;
/**
 * 
 * @author tomcat
 *
 *Struts2是可以吧一个普通的java类当做一个动作类/控制器
 */
public class HelloAction {
	
	/**
	 * 想访问该方法
	 * 1.该方法只能被public修饰
	 * 2.该方法返回值必须是String
	 * 3.该方法没有形参
	 * @return
	 */
	public  String sayHello(){
		
		System.out.println("hello world~~~");
		return "success";
	}
	
	public  String execute(){
		
		System.out.println("execute~~");
		return "success";
	}
	

}
