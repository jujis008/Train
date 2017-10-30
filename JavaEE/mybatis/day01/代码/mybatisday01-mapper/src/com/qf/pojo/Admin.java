package com.qf.pojo;

public class Admin {
	private String aid;
	private String apwd;
	private String aname;
	private String sex;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", apwd=" + apwd + ", aname=" + aname + ", sex=" + sex + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
