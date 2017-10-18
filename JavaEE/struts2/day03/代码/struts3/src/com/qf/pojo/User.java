package com.qf.pojo;

public class User {
	
	private Long uid;
	
	private String uname;
	
	private String upwd;
	
	private String sex;

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

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", sex=" + sex + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
