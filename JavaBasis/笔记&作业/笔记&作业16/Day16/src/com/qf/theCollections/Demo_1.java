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
		//获取集合中的最大值
		System.out.println(Collections.max(list));
		System.out.println(list);
		Collections.sort(list); //将集合进行排序
		System.out.println(list);
		//二分法 根据 值 找到角标
		System.out.println(Collections.binarySearch(list, "c"));
		System.out.println(Collections.binarySearch(list, "e"));
		//将集合中的元素顺序打乱 随机置换 可以用来洗牌
		Collections.shuffle(list);
		System.out.println(list);
		//将集合中按照指定位置的元素进行交换 第一个参数是 集合 第二个是第一个数的位置 第三个是第二个数的位置 
		Collections.swap(list, 0, list.size()-1);
		System.out.println(list);
	}
}
