package com.qf.theMap;

import java.util.LinkedHashMap;

public class Demo_5 {

	public static void main(String[] args) {
		LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
		lhm.put("����", 23);
		lhm.put("����", 24);
		lhm.put("����", 26);
		lhm.put("����", 21);
		lhm.put("����", 20);
		System.out.println(lhm);
	}

}
