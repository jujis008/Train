package com.qf.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qf.pojo.User;
/**
 * 属性驱动:在action里面写属性名，提供相应的setter方法，然后他就会自动注入
 * @author tomcat
 *
 */
public class RegisterAction5 extends ActionSupport{
	
	private Map<String,User> map;
	

	public Map<String, User> getMap() {
		return map;
	}
	public void setMap(Map<String, User> map) {
		this.map = map;
	}

	@Override
	public String execute() throws Exception {
	
		System.out.println(map);
		
		
		return super.execute();
	}

	

}
