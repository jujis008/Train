package com.qf.manytomany;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private  Long sid;
	private String sname;
	private String sex;
	
	//一个学生可以对电影多个老师
	private Set<Teacher> teacherSet=new HashSet<>();

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Set<Teacher> getTeacherSet() {
		return teacherSet;
	}

	public void setTeacherSet(Set<Teacher> teacherSet) {
		this.teacherSet = teacherSet;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", teacherSet=" + teacherSet + "]";
	}

	
}
