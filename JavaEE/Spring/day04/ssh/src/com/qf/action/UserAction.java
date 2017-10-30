package com.qf.action;

import org.springframework.ui.Model;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qf.pojo.User;
import com.qf.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 8476910983041754614L;
	
	private User user=new User();
	/**
	 * 提供一个成员变量    提供setter方法
	 * 
	 * 注入过来了
	 * 
	 * spring整合Struts2的第一种方式，会自动注入  根据名字自动注入
	 */
	private UserService userService;
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public String register(){
		
		System.out.println(user);
		userService.register(user);
		return "index";
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
