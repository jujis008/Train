package com.qf.vo;

import java.util.ArrayList;
import java.util.List;

import com.qf.pojo.Items;


public class QueryVo {
	//items
	private Items item;
	
	private List<Integer> ids=new ArrayList<>();

	//批量修改/增加
	private List<Items> itemList=new ArrayList<>();
	
	
 	
	
	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}
	
	

}
