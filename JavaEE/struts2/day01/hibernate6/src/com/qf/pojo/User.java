package com.qf.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.google.gson.annotations.Expose;
@Entity
@Table(name="tb_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Expose
	private Long uid;
	@Column
	@Expose
	private String uname;
	@Expose
	private String sex;
	
	@Column(columnDefinition="date")
	@Expose
	private Date birthday;//datetime
	//mappedBy  多方中一方的属性名
	@OneToMany(targetEntity=Order.class)//,mappedBy="user"
	@JoinColumn(name="uid")//@JoinColumn 外键的注解   name="uid" 外键名     表示维护外键
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	private Set<Order> orderSet=new HashSet<>();

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
