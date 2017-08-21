package com.qf.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//���� dom4j ����xml�ļ�
public class Demo_01 {
//���� �õ�ĳ������ڵ������ �ڶ���������� -->��������
	public static void main(String[] args) throws Exception {
		//1.����������
		SAXReader reader = new SAXReader();
		//2.����xml�ļ�
		Document document = reader.read("Book.xml");
		//3.��ø��ڵ� <���>
		Element root = document.getRootElement();
		//4.��ø��ڵ��µ������ӽڵ�<��> elements() ��ȡһ���洢Ԫ�صļ���
		List<Element> books = root.elements();
		//5.��ȡ�ڶ����� �� <����> list���� �Ǳ� ��0��ʼ
		Element book = books.get(1);
		Element bookName = book.element("����");//����Ԫ���� ��ȡĳһ��ָ����Ԫ��
		//6.��ȡ<����>��������</����> ��ȡ��ǩ֮����ı� getText()
		System.out.println(bookName.getText());
	}

}
