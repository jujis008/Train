package com.qf.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Expose
	private Long oid;
	@Expose
	private String oname;
	@Expose
	private Double money;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="uid")//@JoinColumn 外键的注解   name="uid" 外键名 
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@Expose
	private User user;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
