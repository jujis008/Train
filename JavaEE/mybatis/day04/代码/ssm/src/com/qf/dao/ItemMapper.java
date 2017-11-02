package com.qf.dao;

import java.util.List;

import com.qf.pojo.Items;

public interface ItemMapper {
	
	List<Items> selectItems();
	
	Items selectItemById(Integer id);

}
