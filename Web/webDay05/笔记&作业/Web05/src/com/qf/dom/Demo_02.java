package com.qf.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.*;

//使用DOM解析xml 向 student.xml文件中添加一条学生信息
public class Demo_02 {

	public static void main(String[] args) throws Exception{
		//1创建解析工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2创建解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3引入xml
		Document document = builder.parse("student.xml");
		//创建新的元素
		Element StuElement = document.createElement("student");
		Element idElement = document.createElement("id");
		Element nameElement = document.createElement("name");
		Element ageElement = document.createElement("age");
		//给元素添加值
		idElement.setTextContent("33");
		nameElement.setTextContent("赵六");
		ageElement.setTextContent("56");
		//确定元素之间的关系
		StuElement.appendChild(idElement);
		StuElement.appendChild(nameElement);
		StuElement.appendChild(ageElement);
		document.getElementsByTagName("students").item(0).appendChild(StuElement);
	
		//把内存中的Dom树写回xml文件中
		//用于把代表xml文件的Document对象 转换为某种格式后 进行输出
		//将 Document 对象 重新写入到xml文件中
		// Transformer 通过 transform方法完成转换的操作 该方法接收一个源和一个目的地
		TransformerFactory factory1 = TransformerFactory.newInstance();
		Transformer transformer = factory1.newTransformer();
		//指定输出到xml文件的属性 -->编码集 
		//Transformer 应用此编码集将字符序列编码 作为 字节序列编码传输
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		//abstract  void transform(Source xmlSource, Result outputTarget) 
		Source xmlSource = new DOMSource(document);//源头
		Result outputTarget = new StreamResult("student.xml");//目的地
		//将源写入到目的地中
		transformer.transform(xmlSource, outputTarget);
	}
}







