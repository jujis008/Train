package com.qf.theMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Demo_2 {
	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<>();
		hm.put("����", 23);
		hm.put("����", 24);
		hm.put("����", 25);
		hm.put("����", 26);
		//Set<K> keySet()
		
		Set<String> keySet = hm.keySet(); //��ȡ���������еļ�
		Iterator<String> it = keySet.iterator();//��ȡ������
		while(it.hasNext()) {//�жϵ��м������Ƿ���Ԫ��
			String key = it.next();//��ȡ�����е�ÿһ��Ԫ�� ��ʵ����˫�м����еļ�
			Integer value = hm.get(key);//���ݼ���ȡֵ
			System.out.println(key+"...."+value);//��ӡ��ֵ��
		}
		//��ǿforѭ�� ����˫�м���
		for(String key:hm.keySet()) {
			System.out.println(key+"..."+hm.get(key));
		}
	}
}
