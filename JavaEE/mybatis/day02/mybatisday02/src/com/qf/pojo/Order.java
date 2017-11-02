package com.qf.pojo;

import java.util.Date;

public class Order {
	private Long oid;
	
	private Double oprice;
	
	private String flag;
	
	private Date createtime;
	
	private User user;//一方
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Double getOprice() {
		return oprice;
	}

	public void setOprice(Double oprice) {
		this.oprice = oprice;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", oprice=" + oprice + ", flag=" + flag + ", createtime=" + createtime + "]";
			
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
