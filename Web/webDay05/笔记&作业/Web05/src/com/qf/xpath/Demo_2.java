package com.qf.xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

//ʹ��xpath ����xml �ļ�  ר��������ѯ���� ��ѯ���еĽڵ�����
public class Demo_2 {

	public static void main(String[] args) throws Exception{
		//1.����������
		SAXReader reader = new SAXReader();
		//2.����xml�ļ�
		Document document = reader.read("Book.xml");
		//3.��ȡ���нڵ� selectNodes
		// ��һ��/ ��ת���ַ� �ڶ���/*�Ǹ�Ŀ¼�����е�
		List<Node> list = document.selectNodes("//*");
		for(int i=0;i<list.size();i++){
			//��ȡÿ���ڵ�
			Node node = list.get(i);
			//��ȡ�ڵ��� �� ֵ
			System.out.println(node.getName()+",,,"+node.getText());
		}
	}

}




