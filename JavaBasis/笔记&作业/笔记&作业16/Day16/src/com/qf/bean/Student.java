package com.qf.bean;
//�ڴ���Student���ʱ�� Ϊ����Ԫ�ؾ߱��Ƚ��� ���� ��д hashCode��equals����
public class Student implements Comparable<Student>{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	public int hashCode() {
		return this.name.hashCode() + this.age*31;
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) {
			return false;
		}
		Student stu = (Student)obj;
		return this.age == stu.age ? this.name.equals(stu.name):false;
	}
	@Override
	public int compareTo(Student o) {
		int num = this.age - o.age;
		return num == 0? this.name.compareTo(o.name):num;
	}
}





