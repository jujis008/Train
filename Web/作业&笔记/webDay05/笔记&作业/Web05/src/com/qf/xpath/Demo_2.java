package com.qf.xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

//使用xpath 解析xml 文件  专门用来查询数据 查询所有的节点数据
public class Demo_2 {

	public static void main(String[] args) throws Exception{
		//1.创建解析器
		SAXReader reader = new SAXReader();
		//2.引入xml文件
		Document document = reader.read("Book.xml");
		//3.获取所有节点 selectNodes
		// 第一个/ 是转译字符 第二个/*是根目录下所有的
		List<Node> list = document.selectNodes("//*");
		for(int i=0;i<list.size();i++){
			//获取每个节点
			Node node = list.get(i);
			//获取节点名 和 值
			System.out.println(node.getName()+",,,"+node.getText());
		}
	}

}




