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
		hm.put("����", 23);
		hm.put("����", 24);
		hm.put("����", 25);
		hm.put("����", 26);
		//Set<Map.Entry<K,V>> entrySet() 
		//��ȡ Map���ϵļ�ֵ�Թ�ϵ ���뵽Set������
		Set<Map.Entry<String,Integer>> entrySet = hm.entrySet();
		Iterator<Map.Entry<String,Integer>> it = entrySet.iterator();//��ȡ������
		while(it.hasNext()) {
			Map.Entry<String,Integer> en =  it.next(); //��ȡ��ϵ
			String key = en.getKey();//���ݹ�ϵ ��ȡ ��
			Integer value = en.getValue();//���ݹ�ϵ ��ȡֵ
			System.out.println(key+"...."+value);
		}
		//��ǿforѭ��
		for(Entry<String,Integer> en : hm.entrySet()) {
			System.out.println(en.getKey()+"...."+en.getValue());
		}
	}
}
