package com.qf.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.*;

//ʹ��DOM����xml �� student.xml�ļ������һ��ѧ����Ϣ
public class Demo_02 {

	public static void main(String[] args) throws Exception{
		//1������������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2����������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3����xml
		Document document = builder.parse("student.xml");
		//�����µ�Ԫ��
		Element StuElement = document.createElement("student");
		Element idElement = document.createElement("id");
		Element nameElement = document.createElement("name");
		Element ageElement = document.createElement("age");
		//��Ԫ�����ֵ
		idElement.setTextContent("33");
		nameElement.setTextContent("����");
		ageElement.setTextContent("56");
		//ȷ��Ԫ��֮��Ĺ�ϵ
		StuElement.appendChild(idElement);
		StuElement.appendChild(nameElement);
		StuElement.appendChild(ageElement);
		document.getElementsByTagName("students").item(0).appendChild(StuElement);
	
		//���ڴ��е�Dom��д��xml�ļ���
		//���ڰѴ���xml�ļ���Document���� ת��Ϊĳ�ָ�ʽ�� �������
		//�� Document ���� ����д�뵽xml�ļ���
		// Transformer ͨ�� transform�������ת���Ĳ��� �÷�������һ��Դ��һ��Ŀ�ĵ�
		TransformerFactory factory1 = TransformerFactory.newInstance();
		Transformer transformer = factory1.newTransformer();
		//ָ�������xml�ļ������� -->���뼯 
		//Transformer Ӧ�ô˱��뼯���ַ����б��� ��Ϊ �ֽ����б��봫��
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		//abstract  void transform(Source xmlSource, Result outputTarget) 
		Source xmlSource = new DOMSource(document);//Դͷ
		Result outputTarget = new StreamResult("student.xml");//Ŀ�ĵ�
		//��Դд�뵽Ŀ�ĵ���
		transformer.transform(xmlSource, outputTarget);
	}
}







