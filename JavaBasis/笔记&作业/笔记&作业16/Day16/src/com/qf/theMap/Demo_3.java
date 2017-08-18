package com.qf.theMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> hm = new HashMap<>();
		hm.put("张三", 23);
		hm.put("李四", 24);
		hm.put("王五", 25);
		hm.put("赵六", 26);
		//Set<Map.Entry<K,V>> entrySet() 
		//获取 Map集合的键值对关系 存入到Set集合中
		Set<Map.Entry<String,Integer>> entrySet = hm.entrySet();
		Iterator<Map.Entry<String,Integer>> it = entrySet.iterator();//获取迭代器
		while(it.hasNext()) {
			Map.Entry<String,Integer> en =  it.next(); //获取关系
			String key = en.getKey();//根据关系 获取 键
			Integer value = en.getValue();//根据关系 获取值
			System.out.println(key+"...."+value);
		}
		//增强for循环
		for(Entry<String,Integer> en : hm.entrySet()) {
			System.out.println(en.getKey()+"...."+en.getValue());
		}
	}
}
