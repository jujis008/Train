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
import com.qf.vo.QueryVo;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	@Qualifier("itemMapper")
	private ItemMapper itemMapper;
	
	@Override
	public List<ItemsCustom> selectItems() {
		
		
		/**
		 * Son  extends  Father
		 * 
		 * Son  son=new Son();
		 * Father f1=new Father();
		 * 
		 * Father f=new SOn();
		 * 
		 * Son(f)可以的
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		List<ItemsCustom> itemsCustom= new ArrayList<ItemsCustom>();
		List<Items> selectItems = itemMapper.selectItems();
		for(Items i: selectItems){

			ItemsCustom s=new ItemsCustom();
			//copyProperties  spring给提供的工具类  copy相同的属性
			BeanUtils.copyProperties(i, s);
			itemsCustom.add(s);
			
		}
		
		
		return itemsCustom;
	}

	@Override
	public ItemsCustom selectById(Integer id) {
		// TODO Auto-generated method stub
		ItemsCustom s=new ItemsCustom();
		Items item = itemMapper.selectItemById(id);
		
		if(item!=null){
			
			BeanUtils.copyProperties(item, s);
		}
		return s;
	}

	@Override
	public List<Items> selectByPrice(QueryVo vo) {
		// TODO Auto-generated method stub
		
		
		List<Items> selectByPrice = itemMapper.selectByPrice(vo);
		return selectByPrice;
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		itemMapper.deletByIds(ids);
	}

}
