package com.qf.pojo;

public class Person {
	private Long pid;
	private String pname;
	private String sex;
	
	private Card card;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", sex=" + sex + ", card=" + card + "]";
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
