package com.qf.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_stu")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sid;
	
	
	private String sname;
	
	private String sex;
	
	@ManyToMany(targetEntity=Teacher.class)
	//inverseJoinColumns配置另外一方在中间表中的外键名
	@JoinTable(name="tb_tea_stu",joinColumns={@JoinColumn(name="sid")},inverseJoinColumns={@JoinColumn(name="tid")})//name中间表名    joinColumns当前表在中间表中的外键
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
	
	
}
