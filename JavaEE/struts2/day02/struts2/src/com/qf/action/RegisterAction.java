package com.qf.action;

import java.util.Arrays;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 属性驱动:在action里面写属性名，提供相应的setter方法，然后他就会自动注入
 * @author tomcat
 *
 */
public class RegisterAction extends ActionSupport{
	
	private String uname;
	private String upwd;
	private String ugender;
	
	//private String[] hobby;
	private String hobby;
	private Date birthday;
	
	
	
	
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setUname(String uname) {
		System.out.println("setUname");
		this.uname = uname;
	}

	public void setUpwd(String upwd) {
		System.out.println("setUpwd");
		this.upwd = upwd;
	}

	public void setUgender(String ugender) {
		System.out.println("setUgender");
		this.ugender = ugender;
	}

	@Override
	public String execute() throws Exception {
	
		System.out.println(uname);
		System.out.println(upwd);
		System.out.println(ugender);
		System.out.println(hobby);
		System.out.println(birthday);
		System.out.println(ugender);
		
		
		return super.execute();
	}

	

}
