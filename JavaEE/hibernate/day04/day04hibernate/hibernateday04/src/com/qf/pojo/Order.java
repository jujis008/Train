package com.qf.pojo;

public class Order {
	private Long oid;
	private String oname;
	private Double oprice;
	
	//用户 多方中有一方的属性    hibernate会帮我们实例化
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

	public Double getOprice() {
		return oprice;
	}

	public void setOprice(Double oprice) {
		this.oprice = oprice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", oname=" + oname + ", oprice=" + oprice + " ";
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
