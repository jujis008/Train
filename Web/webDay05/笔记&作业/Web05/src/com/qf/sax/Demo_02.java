package com.qf.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
//xml sax 解析
public class Demo_02 {

	public static void main(String[] args) throws Exception {
		//1.创建xml解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.创建解析器
		SAXParser parser = factory.newSAXParser();
		//3.导入xml文件 获取解析类 来解析该文件
		MyHandler_02 my = new MyHandler_02();
		parser.parse("student.xml", my);
		System.out.println(my.getStudentList());
	}

}
