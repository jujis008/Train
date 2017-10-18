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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
@Table(name="tb_tea")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tid;
	
	
	private String tname;
	
	private String sex;
	
	
	@ManyToMany(targetEntity=Student.class)//,mappedBy="teacherSet"
	@JoinTable(name="tb_tea_stu",joinColumns={@JoinColumn(name="tid")},inverseJoinColumns={@JoinColumn(name="sid")})//name中间表名    joinColumns当前表在中间表中的外键
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
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

	public Set<Student> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
