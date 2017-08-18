package com.qf.theMap;
import java.util.*;

import com.qf.bean.*;

public class Demo_6 {

	public static void main(String[] args) {
		TreeMap<Student,String> tm = new TreeMap<>(new Comparator<Student>() {

			public int compare(Student o1, Student o2) {
				//根据姓名排序
				int num = o1.getName().compareTo(o2.getName());
				return num == 0? o1.getAge() - o2.getAge() : num;
			}
		});
		tm.put(new Student("张三",23), "北京");
		tm.put(new Student("李四",24), "重庆");
		tm.put(new Student("王五",23), "北京");
		tm.put(new Student("张三",23), "chongqing");
		tm.put(new Student("赵六",21), "成都");
		System.out.println(tm);
	}

}
