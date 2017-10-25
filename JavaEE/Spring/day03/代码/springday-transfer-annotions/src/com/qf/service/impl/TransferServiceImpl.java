package com.qf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.qf.dao.TransferDao;
import com.qf.service.TransferService;

@Service("transferService")
public class TransferServiceImpl implements TransferService{

	@Autowired
	@Qualifier("transferDao")
	private TransferDao transferDao;	
	@Override
	public boolean transfer(String from, String to, Double money) {
		
		
		transferDao.min(from, money);

		transferDao.add(to, money);
		
		return true;
	}
	
	public void transfer(){
		//运行  transfer1该方法他本身需要事务
		
		
		
		
	}

}
