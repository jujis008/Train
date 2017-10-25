package com.qf.pojo;

public class User {
	
	private Long uid;
	private String uname;
	private String upwd;
	private Double money;
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
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public User(Long uid, String uname, String upwd, Double money) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.money = money;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", money=" + money + "]";
	}
	
	

}
