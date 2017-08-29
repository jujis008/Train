package com.qf.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	//�ĵ���ʼ :��ʼ����xml��ʱ�� ���ø÷���
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("startDocument");
	}
	//�ĵ����� : ����֮����� ���Բ�д
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("endDocument");
	}
	//��ǩ��ʼ ������ǩ qName�����ǩ��
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("\tstartElement---"+qName);
	}
	//��ǩ���� ������ǩ qName�����ǩ��
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("\tendElement---"+qName);
	}
	//������ǩ֮�������
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("\t\tcharacters---"+new String(ch,start,length));
	}

}
