package com.qf.pojo;

public class Users {
	/**
	 * uid BIGINT primary key auto_increment,
		uname varchar(30),
		ugender varchar(5),
		upwd varchar(30)
	 */
	//ctrl+alt +下箭头
	//alt+上下的箭头
	private Long uid;
	private String uname;
	private String ugender;
	private String upwd;
	
	
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
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", ugender=" + ugender + ", upwd=" + upwd + "]";
	}
	public Users() {
		
	}
	
	
	
	
	
	

}
