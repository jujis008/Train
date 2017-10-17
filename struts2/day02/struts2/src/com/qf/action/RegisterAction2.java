package com.qf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qf.pojo.User;

/**
 * ognl表达式的方式
 * @author tomcat
 *
 */
public class RegisterAction2 extends ActionSupport{
	/**
	 * 如果user不初始化，
	 * 先去getUser
	 * 拦截器会帮你初始化，
	 * 
	 * 调用setter方法给你赋值
	 */
	private User user=new User();
	
	
	
	
	
	public User getUser() {
		System.out.println("getUser");
		return user;
	}

	public void setUser(User user) {
		System.out.println("setUser");
		this.user = user;
	}



	@Override
	public String execute() throws Exception {
	
		System.out.println(user);
		
		
		return super.execute();
	}

}
