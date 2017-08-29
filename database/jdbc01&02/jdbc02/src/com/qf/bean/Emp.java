package com.qf.bean;
//约定大于配置

import java.util.Date;

public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	private Date biredate;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Date getBiredate() {
		return biredate;
	}
	public void setBiredate(Date biredate) {
		this.biredate = biredate;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", biredate=" + biredate
				+ "]";
	}
	
}
