package com.qf.dom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;
import org.w3c.dom.Element;

import com.qf.bean.Student;

//DOM���� xml�ļ� �� student.xml�е����ݽ������� ��ŵ�student������ ������ ���뼯����
public class Demo_01 {

	public static void main(String[] args) throws Exception{
		//1.��������������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.����������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.����xml ��ȡdocument����
		Document document = builder.parse("student.xml");
		//��ȡ��Ԫ��
		Element root = document.getDocumentElement();
		//����Ԫ������ ��ø�Ԫ���µ������ӽڵ�(�ڵ㼯��)
		NodeList stuNodes = root.getElementsByTagName("student");
		
		//�������� ���Student ����
		List<Student> list = new ArrayList<Student>();
		
		//���� ѧ��xml�ļ���
		for(int i = 0;i<stuNodes.getLength();i++){
			//��ȡÿ��ѧ����ǩ(�ڵ�)
			Node stuNode = stuNodes.item(i);
			//��� ѧ����ǩ �� �ӱ�ǩ id name age
			NodeList stuChildNodes = stuNode.getChildNodes();
			//System.out.println(stuChildNodes);
			//����ѧ������ ׼���洢��Ϣ
			Student stu = new Student();
			//���� student��ǩ�µ��ӱ�ǩ
			for(int j=0;j<stuChildNodes.getLength();j++){
				Node node = stuChildNodes.item(j);
				//�жϽڵ���Ԫ�� �ýڵ�Ϊ Element��
				if(node.getNodeType() == Node.ELEMENT_NODE){
					//��ȡ�ڵ���� �� ֵ 
					String name = node.getNodeName();
					//��ע�⣬���ﻹʹ����һ��getFirstChild()���������message����ĵ�һ����Node����
					//��Ȼ�ڱ�ǩ��������ı��� ��û�������ӱ�ǩ�������ԣ�
					//�������Ǽ��������ʹ��getFirseChild()����������Ҫ��W3C��DOM�Ķ����йء�
					//W3C�ѱ�ǩ�ڵ��ı�����Ҳ �����һ��Node��������Ҫ�õ������ı����Ǹ�Node��
					//���ǲ��ܹ�ʹ��getNodeValue()����ȡ�ı������ݡ�
					String value = node.getFirstChild().getNodeValue();
					//System.out.println(name+",,,"+value);
					//�жϱ�ǩ�� �������� �洢ֵ
					if("id".equals(name)){
						stu.setId(Integer.parseInt(value));
					}else if("name".equals(name))
						stu.setName(value);
					 else if("age".equals(name))
						stu.setAge(Integer.parseInt(value));
				}
			}
			list.add(stu);
		}
		System.out.println(list);
	}
}






