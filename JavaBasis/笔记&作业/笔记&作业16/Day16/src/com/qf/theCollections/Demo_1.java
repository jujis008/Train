package com.qf.theCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class Demo_1 {

	public static void main(String[] args) {
		//static <T> Comparator<T>  reverseOrder() 
		/*
		 TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());
		 ts.add("abcd");
		 ts.add("aaa");
		 ts.add("kkk");
		 ts.add("ccc");
		 Iterator<String> it = ts.iterator();
		 while(it.hasNext()) {
			 System.out.println(it.next());
		 }*/
		Demo_Collections();
	}
	public static void Demo_Collections(){
		ArrayList<String> list = new ArrayList<>();
		list.add("c");
		list.add("d");
		list.add("a");
		list.add("b");
		//��ȡ�����е����ֵ
		System.out.println(Collections.max(list));
		System.out.println(list);
		Collections.sort(list); //�����Ͻ�������
		System.out.println(list);
		//���ַ� ���� ֵ �ҵ��Ǳ�
		System.out.println(Collections.binarySearch(list, "c"));
		System.out.println(Collections.binarySearch(list, "e"));
		//�������е�Ԫ��˳����� ����û� ��������ϴ��
		Collections.shuffle(list);
		System.out.println(list);
		//�������а���ָ��λ�õ�Ԫ�ؽ��н��� ��һ�������� ���� �ڶ����ǵ�һ������λ�� �������ǵڶ�������λ�� 
		Collections.swap(list, 0, list.size()-1);
		System.out.println(list);
	}
}
