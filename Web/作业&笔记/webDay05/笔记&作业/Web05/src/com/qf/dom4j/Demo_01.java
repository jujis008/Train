package com.qf.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//利用 dom4j 解析xml文件
public class Demo_01 {
//案例 得到某个具体节点的内容 第二本书的书名 -->葵花宝典
	public static void main(String[] args) throws Exception {
		//1.创建解析器
		SAXReader reader = new SAXReader();
		//2.引入xml文件
		Document document = reader.read("Book.xml");
		//3.获得根节点 <书架>
		Element root = document.getRootElement();
		//4.获得根节点下的所有子节点<书> elements() 获取一个存储元素的集合
		List<Element> books = root.elements();
		//5.获取第二本书 的 <书名> list集合 角标 从0开始
		Element book = books.get(1);
		Element bookName = book.element("书名");//根据元素名 获取某一个指定的元素
		//6.获取<书名>葵花宝典</书名> 获取标签之间的文本 getText()
		System.out.println(bookName.getText());
	}

}
