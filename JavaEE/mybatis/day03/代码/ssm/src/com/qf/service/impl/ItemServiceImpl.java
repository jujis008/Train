package com.qf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.qf.dao.ItemMapper;
import com.qf.pojo.Items;
import com.qf.pojo.ItemsCustom;
import com.qf.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	@Qualifier("itemMapper")
	private ItemMapper itemMapper;
	
	@Override
	public List<ItemsCustom> selectItems() {
		
		List<ItemsCustom> itemsCustom= new ArrayList<ItemsCustom>();
		List<Items> selectItems = itemMapper.selectItems();
		for(Items i: selectItems){
			ItemsCustom s=new ItemsCustom();
			
			BeanUtils.copyProperties(i, s);
			itemsCustom.add(s);
			
		}
		
		
		return itemsCustom;
	}

}
