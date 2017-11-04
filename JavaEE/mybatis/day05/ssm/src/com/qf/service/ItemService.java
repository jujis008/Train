package com.qf.service;

import java.util.List;

import com.qf.pojo.Items;
import com.qf.pojo.ItemsCustom;
import com.qf.vo.QueryVo;

public interface ItemService {
	
	List<ItemsCustom> selectItems();
	
	ItemsCustom selectById(Integer id);
	
	List<Items> selectByPrice(QueryVo vo);

	void deleteByIds(Integer[] ids);

}
