package com.qf.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.qf.dao.TransferDao;
import com.qf.service.TransferService;

public class TransferServiceImpl implements TransferService{



	private TransferDao transferDao;	
	public void setTransferDao(TransferDao transferDao) {
		this.transferDao = transferDao;
	}


	@Override
	public boolean transfer(String from, String to, Double money) {
		
			
			
		transferDao.min(from, money);
		int x=10/0;
		transferDao.add(to, money);
		
		
		
		return true;
	}

}
