package com.qf.onetomany.pojo;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private Long uid;
	private String uname;
	private String ugender;
	
	//应该有订单信息  set一定要初始化
	private Set<Order> orderSet=new HashSet<>();

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

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", ugender=" + ugender + ", orderSet=" + orderSet + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
