package com.qf.theMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Demo_2 {
	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<>();
		hm.put("张三", 23);
		hm.put("李四", 24);
		hm.put("王五", 25);
		hm.put("赵六", 26);
		//Set<K> keySet()
		
		Set<String> keySet = hm.keySet(); //获取集合中所有的键
		Iterator<String> it = keySet.iterator();//获取迭代器
		while(it.hasNext()) {//判断单列集合中是否有元素
			String key = it.next();//获取集合中的每一个元素 其实就是双列集合中的键
			Integer value = hm.get(key);//根据键获取值
			System.out.println(key+"...."+value);//打印键值对
		}
		//增强for循环 迭代双列集合
		for(String key:hm.keySet()) {
			System.out.println(key+"..."+hm.get(key));
		}
	}
}
