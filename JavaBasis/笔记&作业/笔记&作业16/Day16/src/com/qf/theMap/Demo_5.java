package com.qf.theMap;

import java.util.LinkedHashMap;

public class Demo_5 {

	public static void main(String[] args) {
		LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
		lhm.put("张三", 23);
		lhm.put("李四", 24);
		lhm.put("赵六", 26);
		lhm.put("王五", 21);
		lhm.put("张三", 20);
		System.out.println(lhm);
	}

}
