package com.qf.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	private static final long serialVersionUID = 1423880349519186223L;
	/**
	 * 要提供getter和setter方法
	 */
	//用户名
	private String  uname;
	
	//文件  文件对象的名字  要和表单的名字一样
	private File photo;
	//文件的名字   文件名+FileName
	private String photoFileName;
	
	//文件的类型  MIME类型  文件名+ContentType
	private String  photoContentType;
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}


	public String upload() throws IOException{
		
		System.out.println("文件名==="+photoFileName);
		System.out.println("文件类型==="+photoContentType);
		System.out.println("文件大小==="+photo.length());
		//获得项目发布的真是目录
		String realPath = ServletActionContext.getServletContext().getRealPath("/");
		
		File f1=new File("D:\\imgs");
		String name=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+UUID.randomUUID().toString()+photoFileName;
		System.out.println(realPath);
		//复制图片
		FileUtils.copyFile(photo, new File(f1,name));
		
		return SUCCESS;
	}

}
