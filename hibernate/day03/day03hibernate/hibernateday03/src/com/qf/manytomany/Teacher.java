package com.qf.manytomany;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private Long tid;
	private String tname;
	private String sex;
	
	//一个老师可以对应多个学生
	private Set<Student> studentSet=new HashSet<>();

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Student> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", sex=" + sex + "]";
	}
	
	
	
	

}
