package com.qf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qf.pojo.User;

/**
 * 模型驱动的方式注入
 * @author tomcat
 *
 */
public class RegisterAction3 extends ActionSupport implements ModelDriven<User>{
	
	//初始化
	private User user=new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}


	@Override
	public String execute() throws Exception {
	
		System.out.println(user);
		
		
		return super.execute();
	}



}
