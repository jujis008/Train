package com.qf.theMap;

import java.util.*;

public class Demo_1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("李白", "唐朝人");
		map.put("荆轲", "楚国人");
		map.put("关羽", "三国人");
		map.put("寒冰", "LOL人");
	//	map.put(null, null); HashMap允许存入null键null值
	//	map.put("111", null);
		System.out.println(map.put("嬛嬛", "清朝人"));
		System.out.println(map.put("关羽", "蜀国"));
		System.out.println(map.get("寒冰"));
		System.out.println(map.get("111"));
		System.out.println(map.remove("嬛嬛"));
		System.out.println(map.containsKey("关羽"));
		System.out.println(map.containsValue("清朝人"));
		//map.clear();清空当前集合 元素被清空 集合还在
		System.out.println(map.size());
		//putAll 将集合中的每一个元素添加到当前集合的末尾
		Map<String,String> map2 = new HashMap<>();
		map2.put("希特勒", "德国");
		map2.put("斯大林", "苏联");
		map.putAll(map2);
		System.out.println(map);
		//values 将Map集合中所有的value 存储到Collection集合中
		Collection<String> coll = map.values();
		for(String s:coll) {
			System.out.println(s);
		}
	}

}
