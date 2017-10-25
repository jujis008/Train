package com.qf.i_p;

public class User {
	private Long uid;
	private String uname;
	private String upwd;
	
	private Card card;

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

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", card=" + card + "]";
	}

	public User(Long uid, String uname, String upwd, Card card) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.card = card;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
