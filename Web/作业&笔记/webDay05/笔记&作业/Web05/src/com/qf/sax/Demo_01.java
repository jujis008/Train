package com.qf.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Demo_01 {
//SAX����
	public static void main(String[] args) throws IOException {
		
		try {
			//1.������������
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//2.����������
			SAXParser parser = factory.newSAXParser();
			//3.����Ҫ������xml�ļ�
			parser.parse("student.xml", new MyHandler());
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
