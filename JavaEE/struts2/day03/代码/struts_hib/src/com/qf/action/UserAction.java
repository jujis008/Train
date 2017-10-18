package com.qf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 8476910983041754614L;
	
	private User user=new User();
	private UserService userService=new UserServiceImpl();
	
	public String register(){
		
		boolean flag=userService.register(user);
		if(flag){
			return SUCCESS;
		}
		
		
		return "register";
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
	
	

}
