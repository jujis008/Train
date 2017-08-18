package com.qf.theMap;

import java.util.*;

import com.qf.bean.Student;

/*ÿһ��ѧ�����ж�Ӧ�Ĺ�����
 * ѧ�� Student ��ַ String
 * ѧ������: ���� ����
 * ע��:������������ͬ����Ϊͬһ��ѧ��
 * ��֤ѧ��Ψһ��
 * 
 * */
public class Demo_4 {

	public static void main(String[] args) {
		Map<Student,String> map = new HashMap<>();
		map.put(new Student("����",23), "����");
		map.put(new Student("����",24), "����");
		map.put(new Student("����",23), "����");
		map.put(new Student("����",23), "chongqing");
		map.put(new Student("����",21), "�ɶ�");
		//����Map���� ��ʽһ
		Set<Student> set = map.keySet();
		Iterator<Student> it = set.iterator();
		while(it.hasNext()) {
			Student key = it.next();
			String value = map.get(key);
			System.out.println(key.getName()+"..."+key.getAge()+"..."+value);
		}
		//����Map���� ��ʽ��
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









