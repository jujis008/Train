package com.qf.theMap;

import java.util.*;

public class Demo_1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("���", "�Ƴ���");
		map.put("����", "������");
		map.put("����", "������");
		map.put("����", "LOL��");
	//	map.put(null, null); HashMap�������null��nullֵ
	//	map.put("111", null);
		System.out.println(map.put("�֋�", "�峯��"));
		System.out.println(map.put("����", "���"));
		System.out.println(map.get("����"));
		System.out.println(map.get("111"));
		System.out.println(map.remove("�֋�"));
		System.out.println(map.containsKey("����"));
		System.out.println(map.containsValue("�峯��"));
		//map.clear();��յ�ǰ���� Ԫ�ر���� ���ϻ���
		System.out.println(map.size());
		//putAll �������е�ÿһ��Ԫ����ӵ���ǰ���ϵ�ĩβ
		Map<String,String> map2 = new HashMap<>();
		map2.put("ϣ����", "�¹�");
		map2.put("˹����", "����");
		map.putAll(map2);
		System.out.println(map);
		//values ��Map���������е�value �洢��Collection������
		Collection<String> coll = map.values();
		for(String s:coll) {
			System.out.println(s);
		}
	}

}
