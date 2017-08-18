package com.qf.theMap;

import java.util.*;

import com.qf.bean.Student;

/*每一个学生都有对应的归属地
 * 学生 Student 地址 String
 * 学生属性: 姓名 年龄
 * 注意:姓名和年龄相同的视为同一个学生
 * 保证学生唯一性
 * 
 * */
public class Demo_4 {

	public static void main(String[] args) {
		Map<Student,String> map = new HashMap<>();
		map.put(new Student("张三",23), "北京");
		map.put(new Student("李四",24), "重庆");
		map.put(new Student("王五",23), "北京");
		map.put(new Student("张三",23), "chongqing");
		map.put(new Student("赵六",21), "成都");
		//遍历Map集合 方式一
		Set<Student> set = map.keySet();
		Iterator<Student> it = set.iterator();
		while(it.hasNext()) {
			Student key = it.next();
			String value = map.get(key);
			System.out.println(key.getName()+"..."+key.getAge()+"..."+value);
		}
		//遍历Map集合 方式二
		Set<Map.Entry<Student, String>> set2 = map.entrySet();
		Iterator<Map.Entry<Student, String>> it2 = set2.iterator();
		while(it2.hasNext()) {
			Map.Entry<Student, String> entry = it2.next();
			Student stu = entry.getKey();
			String address = entry.getValue();
			System.out.println(stu.getAge()+"..."+stu.getName()+"Address:::"+address);
		}
	}

}









