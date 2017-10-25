package com.qf.g_const;

public class Card {
	private Long cid;
	
	private String cname;

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

	public Card(Long cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Card [cid=" + cid + ", cname=" + cname + "]";
	}
	
	

}
