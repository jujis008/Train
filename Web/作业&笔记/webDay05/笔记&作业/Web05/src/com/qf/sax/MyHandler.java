package com.qf.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	//文档开始 :开始解析xml的时候 调用该方法
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("startDocument");
	}
	//文档结束 : 解析之后调用 可以不写
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("endDocument");
	}
	//标签开始 解析标签 qName代表标签名
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("\tstartElement---"+qName);
	}
	//标签结束 解析标签 qName代表标签名
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("\tendElement---"+qName);
	}
	//解析标签之间的内容
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("\t\tcharacters---"+new String(ch,start,length));
	}

}
