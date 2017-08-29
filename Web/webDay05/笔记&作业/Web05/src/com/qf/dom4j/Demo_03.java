package com.qf.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

import org.dom4j.*;
import org.dom4j.io.*;

//dom4j ����xml�ļ� ��� ��ɾ�Ĳ����
public class Demo_03 {

	public static void main(String[] args) throws Exception {
		//1.����������
		SAXReader reader = new SAXReader();
		//2.����xml�ļ�
		Document doc = reader.read(new File("Teacher.xml"));
		//3.��ȡ��Ԫ��
		Element root = doc.getRootElement();
		System.out.println("root::::::"+root.getName());
		//ѭ���������нڵ�
		for(Iterator iter = root.elementIterator();iter.hasNext();){
			Element e = (Element)iter.next();
			System.out.println(e.getText());
		}
		//��ȡĳ����Ҫ�Ľڵ�
		Element ec = root.element("score");
		System.out.println("��ȡĳ���ڵ��ֵ:::::"+ec.getText());
		//���ڵ���Ϣ�޸�Ϊ 50
		ec.setText("50");
		System.out.println("�޸ĺ�Ľڵ��ֵ:::::"+ec.getText());
		//��ĳ�ڵ��������ӽڵ�
		Element sex = root.addElement("sex");
		sex.setText("female");
		//ɾ��ĳ�ڵ�
		root.remove(ec);
		
		//��� Ҫ������д����xml�ļ��� ��Ȼû������
		//dom4j�ṩ��ר�ŵ�д���ļ��Ķ��� XMLWriter
		XMLWriter xmlWriter = new XMLWriter(new FileWriter("Teacher.xml"));
		xmlWriter.write(doc);
		xmlWriter.close();
	}

}
