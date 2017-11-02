package com.qf.dao;

import java.util.List;

import com.qf.pojo.Order;

public interface OrderMapper {
	
	List<Order>selectOneToOne(Order order);

}
