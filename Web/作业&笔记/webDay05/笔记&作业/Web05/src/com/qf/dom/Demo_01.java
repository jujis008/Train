package com.qf.dom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;
import org.w3c.dom.Element;

import com.qf.bean.Student;

//DOM解析 xml文件 将 student.xml中的数据解析出来 存放到student对象中 将对象 存入集合中
public class Demo_01 {

	public static void main(String[] args) throws Exception{
		//1.创建解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.创建解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.引入xml 获取document对象
		Document document = builder.parse("student.xml");
		//获取根元素
		Element root = document.getDocumentElement();
		//根据元素名称 获得根元素下的所有子节点(节点集合)
		NodeList stuNodes = root.getElementsByTagName("student");
		
		//创建集合 存放Student 数据
		List<Student> list = new ArrayList<Student>();
		
		//遍历 学生xml的集合
		for(int i = 0;i<stuNodes.getLength();i++){
			//获取每个学生标签(节点)
			Node stuNode = stuNodes.item(i);
			//获得 学生标签 下 子标签 id name age
			NodeList stuChildNodes = stuNode.getChildNodes();
			//System.out.println(stuChildNodes);
			//创建学生对象 准备存储信息
			Student stu = new Student();
			//遍历 student标签下的子标签
			for(int j=0;j<stuChildNodes.getLength();j++){
				Node node = stuChildNodes.item(j);
				//判断节点是元素 该节点为 Element。
				if(node.getNodeType() == Node.ELEMENT_NODE){
					//获取节点的名 和 值 
					String name = node.getNodeName();
					//请注意，这里还使用了一个getFirstChild()方法来获得message下面的第一个子Node对象。
					//虽然在标签下面除了文本外 并没有其它子标签或者属性，
					//但是我们坚持在这里使用getFirseChild()方法，这主要和W3C对DOM的定义有关。
					//W3C把标签内的文本部分也 定义成一个Node，所以先要得到代表文本的那个Node，
					//我们才能够使用getNodeValue()来获取文本的内容。
					String value = node.getFirstChild().getNodeValue();
					//System.out.println(name+",,,"+value);
					//判断标签名 根据名字 存储值
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






