package com.qf.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qf.pojo.User;
/**
 * 属性驱动:在action里面写属性名，提供相应的setter方法，然后他就会自动注入
 * @author tomcat
 *
 */
public class RegisterAction4 extends ActionSupport{
	
	private List<User> list;
	
	
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	@Override
	public String execute() throws Exception {
	
		System.out.println(list);
		
		
		return super.execute();
	}

	

}
