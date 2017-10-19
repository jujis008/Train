package com.qf.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import com.qf.utils.HibernateUtils;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 8476910983041754614L;
	
	private User user=new User();
	private List<User> list=new ArrayList<>();
	private UserService userService=new UserServiceImpl();
	
	
	
	
	public List<User> getList() {
		return list;
	}


	public void setList(List<User> list) {
		this.list = list;
	}


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
