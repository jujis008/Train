package com.qf.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownAction extends ActionSupport{
	private static final long serialVersionUID = 4514660571897013335L;
	//名字一般叫inputStream
	private InputStream inputStream;
	private String fileName;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String down() throws FileNotFoundException{
		String path=ServletActionContext.getServletContext().getRealPath("/down/mm1.jpg");
		
		File file = new File(path);//下载的文件资源
		inputStream=new FileInputStream(file);
		
		fileName=file.getName();
		return "success";
	}

}
