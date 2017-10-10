package com.qf.pojo;

import java.util.Date;

public class User {
	private Long uid;//oid
	private String uname;
	private String upwd;
	private String ugender;
	private Date birthday;
	
	private Double money;
	
	
	
	
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
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
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", ugender=" + ugender + ", birthday="
				+ birthday + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
