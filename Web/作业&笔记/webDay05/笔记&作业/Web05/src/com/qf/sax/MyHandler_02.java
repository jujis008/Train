package com.qf.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.qf.bean.Student;

public class MyHandler_02 extends DefaultHandler {
	//1 用来装Student对象的集合
	private List<Student> list;
	//2 Student 对象
	private Student stu;
	//3 标志位 区分哪一个 Element
	private String tag;
	
	public List<Student> getStudentList(){
		return list;
	}
	
	//文档开始 开始解析xml文档 只执行一次
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		list = new ArrayList<Student>();
	}
	//标签开始 解析标签时候 调用 qName 是代表标签名
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tag = qName; //代表开始标签
		//如果标签是student 创建一个Student 对象
		if("student".equals(qName)){
			stu = new Student();
		}
	}
	//解析标签中的数据 
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch,start,length); //获取数据
		//判断是否是子节点 如果是对应的节点  就获取数据 存入到stu对象中
		if("id".equals(tag)){
			stu.setId(Integer.parseInt(value));
		}
		if("name".equals(tag)){
			stu.setName(value);
		}
		if("age".equals(tag)){
			stu.setAge(Integer.parseInt(value));
		}
	}
	//标签结束
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		tag = ""; //为了避免出现再次进入分支的情况 清空一下tag标志
		//因为执行完endElement 会回到characters继续获取数据
		//当结束标签为student的时候 将一条student数据存入集合中
		if("student".equals(qName)){
			list.add(stu);
		}
	}
	//文档结束 可不写
	@Override
	public void endDocument() throws SAXException {
		System.out.println("结束解析");
	}


}
