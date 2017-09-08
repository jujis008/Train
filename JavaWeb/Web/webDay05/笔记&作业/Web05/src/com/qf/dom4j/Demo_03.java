package com.qf.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

import org.dom4j.*;
import org.dom4j.io.*;

//dom4j 解析xml文件 完成 增删改查操作
public class Demo_03 {

	public static void main(String[] args) throws Exception {
		//1.创建解析器
		SAXReader reader = new SAXReader();
		//2.引入xml文件
		Document doc = reader.read(new File("Teacher.xml"));
		//3.获取根元素
		Element root = doc.getRootElement();
		System.out.println("root::::::"+root.getName());
		//循环遍历所有节点
		for(Iterator iter = root.elementIterator();iter.hasNext();){
			Element e = (Element)iter.next();
			System.out.println(e.getText());
		}
		//获取某个想要的节点
		Element ec = root.element("score");
		System.out.println("获取某个节点的值:::::"+ec.getText());
		//将节点信息修改为 50
		ec.setText("50");
		System.out.println("修改后的节点的值:::::"+ec.getText());
		//在某节点下增加子节点
		Element sex = root.addElement("sex");
		sex.setText("female");
		//删除某节点
		root.remove(ec);
		
		//最后 要将数据写出到xml文件中 不然没有作用
		//dom4j提供了专门的写出文件的对象 XMLWriter
		XMLWriter xmlWriter = new XMLWriter(new FileWriter("Teacher.xml"));
		xmlWriter.write(doc);
		xmlWriter.close();
	}

}
