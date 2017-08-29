package com.qf.xpath;

import org.dom4j.io.SAXReader;
import org.dom4j.*;

//使用xpath 解析xml 文件  专门用来查询数据
//获取xml文件中的某个节点内容 -->葵花宝典 selectSingleNode
public class Demo_1 {

	public static void main(String[] args) throws Exception {
		//1.创建解析器
		SAXReader reader = new SAXReader();
		//2.引入xml文件
		Document doc = reader.read("Book.xml");
		//3.获取某一个指定的节点 书架/书[2]/书名 selectSingleNode 这个方法中传入的节点是从1开始的
		Node node = doc.selectSingleNode("/书架/书[2]/书名");
		//4.获取节点中的内容
		System.out.println(node.getText());
	}

}
