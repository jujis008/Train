package com.qf.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
//xml sax ����
public class Demo_02 {

	public static void main(String[] args) throws Exception {
		//1.����xml��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.����������
		SAXParser parser = factory.newSAXParser();
		//3.����xml�ļ� ��ȡ������ ���������ļ�
		MyHandler_02 my = new MyHandler_02();
		parser.parse("student.xml", my);
		System.out.println(my.getStudentList());
	}

}
