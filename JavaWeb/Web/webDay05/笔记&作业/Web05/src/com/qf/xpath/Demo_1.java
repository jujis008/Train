package com.qf.xpath;

import org.dom4j.io.SAXReader;
import org.dom4j.*;

//ʹ��xpath ����xml �ļ�  ר��������ѯ����
//��ȡxml�ļ��е�ĳ���ڵ����� -->�������� selectSingleNode
public class Demo_1 {

	public static void main(String[] args) throws Exception {
		//1.����������
		SAXReader reader = new SAXReader();
		//2.����xml�ļ�
		Document doc = reader.read("Book.xml");
		//3.��ȡĳһ��ָ���Ľڵ� ���/��[2]/���� selectSingleNode ��������д���Ľڵ��Ǵ�1��ʼ��
		Node node = doc.selectSingleNode("/���/��[2]/����");
		//4.��ȡ�ڵ��е�����
		System.out.println(node.getText());
	}

}
