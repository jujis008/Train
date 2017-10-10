package com.qf.pojo;

import java.util.Date;

public class User2 {
	private String uid;//oid
	private String uname;
	private String upwd;
	private String ugender;
	private Date birthday;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
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
	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
