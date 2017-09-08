package com.qf.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
//通过递归的方式 获取xml文件中的所有内容
public class Demo_02 {

	public static void main(String[] args) throws Exception {
		// 1.创建解析器
		SAXReader reader = new SAXReader();
		// 2.引入xml文件
		Document doc = reader.read("Book.xml");
		treeWalk(doc.getRootElement());
	}

	public static void treeWalk(Element element) {
		//输出标签名
		System.out.println(element.getName());
		for (int i = 0, size = element.nodeCount(); i < size; i++) {
			Node node = element.node(i);
			//获得子节点 子节点 有可能是标签 或者 值
			if (node instanceof Element) {
				treeWalk((Element) node);
			} else {
				//获取值
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
