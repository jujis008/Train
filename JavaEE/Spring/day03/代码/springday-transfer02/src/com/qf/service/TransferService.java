package com.qf.service;

public interface TransferService {
	
	//转账的方法
	boolean transfer(String from,String to,Double money);

}
