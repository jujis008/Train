package com.qf.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
//ͨ���ݹ�ķ�ʽ ��ȡxml�ļ��е���������
public class Demo_02 {

	public static void main(String[] args) throws Exception {
		// 1.����������
		SAXReader reader = new SAXReader();
		// 2.����xml�ļ�
		Document doc = reader.read("Book.xml");
		treeWalk(doc.getRootElement());
	}

	public static void treeWalk(Element element) {
		//�����ǩ��
		System.out.println(element.getName());
		for (int i = 0, size = element.nodeCount(); i < size; i++) {
			Node node = element.node(i);
			//����ӽڵ� �ӽڵ� �п����Ǳ�ǩ ���� ֵ
			if (node instanceof Element) {
				treeWalk((Element) node);
			} else {
				//��ȡֵ
				System.out.println(node.getText());
			}
		}
	}
	/*
	 * public void treeWalk(Document document) { treeWalk(
	 * document.getRootElement() ); } public void treeWalk(Element element) {
	 * for ( int i = 0, size = element.nodeCount(); i < size; i++ ) { Node node
	 * = element.node(i); if ( node instanceof Element ) { treeWalk( (Element)
	 * node ); } else { // do something.... } } }
	 */
}
