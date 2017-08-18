package com.qf.theMap;
import java.util.*;

import com.qf.bean.*;

public class Demo_6 {

	public static void main(String[] args) {
		TreeMap<Student,String> tm = new TreeMap<>(new Comparator<Student>() {

			public int compare(Student o1, Student o2) {
				//������������
				int num = o1.getName().compareTo(o2.getName());
				return num == 0? o1.getAge() - o2.getAge() : num;
			}
		});
		tm.put(new Student("����",23), "����");
		tm.put(new Student("����",24), "����");
		tm.put(new Student("����",23), "����");
		tm.put(new Student("����",23), "chongqing");
		tm.put(new Student("����",21), "�ɶ�");
		System.out.println(tm);
	}

}
