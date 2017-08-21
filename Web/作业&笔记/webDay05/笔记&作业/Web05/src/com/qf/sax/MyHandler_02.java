package com.qf.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.qf.bean.Student;

public class MyHandler_02 extends DefaultHandler {
	//1 ����װStudent����ļ���
	private List<Student> list;
	//2 Student ����
	private Student stu;
	//3 ��־λ ������һ�� Element
	private String tag;
	
	public List<Student> getStudentList(){
		return list;
	}
	
	//�ĵ���ʼ ��ʼ����xml�ĵ� ִֻ��һ��
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		list = new ArrayList<Student>();
	}
	//��ǩ��ʼ ������ǩʱ�� ���� qName �Ǵ����ǩ��
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tag = qName; //����ʼ��ǩ
		//�����ǩ��student ����һ��Student ����
		if("student".equals(qName)){
			stu = new Student();
		}
	}
	//������ǩ�е����� 
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch,start,length); //��ȡ����
		//�ж��Ƿ����ӽڵ� ����Ƕ�Ӧ�Ľڵ�  �ͻ�ȡ���� ���뵽stu������
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
	//��ǩ����
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		tag = ""; //Ϊ�˱�������ٴν����֧����� ���һ��tag��־
		//��Ϊִ����endElement ��ص�characters������ȡ����
		//��������ǩΪstudent��ʱ�� ��һ��student���ݴ��뼯����
		if("student".equals(qName)){
			list.add(stu);
		}
	}
	//�ĵ����� �ɲ�д
	@Override
	public void endDocument() throws SAXException {
		System.out.println("��������");
	}


}
