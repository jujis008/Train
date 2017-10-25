package com.qf.dao;

public interface TransferDao {
	//减钱
	int min(String from,Double money);
	
	//加钱
	int add(String to,Double money);
}
