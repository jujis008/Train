package com.qf.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	private Long uid;
	private String uname;
	private String upwd;
	private String sex;
	private Date birthday;
	
	//List  set
	// 多方的属性  要实例化
	private List<Order> orderList=new ArrayList<>(); 
	
	
	
	
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", sex=" + sex + ", birthday=" + birthday
				+ ",  \norderList=" +orderList + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
