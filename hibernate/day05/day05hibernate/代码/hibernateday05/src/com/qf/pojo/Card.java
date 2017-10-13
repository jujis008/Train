package com.qf.pojo;

public class Card {
	private Long cid;
	private String cname;
	
	private Person person;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Card [cid=" + cid + ", cname=" + cname + "]";
	}

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
