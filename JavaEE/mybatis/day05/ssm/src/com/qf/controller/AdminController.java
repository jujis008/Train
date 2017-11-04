package com.qf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.qf.pojo.Items;

@Controller
public class AdminController {
	/**
	 * 得到图片存储带磁盘：  把他的路径存储到数据库
	 * @param name
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	
	@RequestMapping("/upload1")
	public String upload1(String name, @RequestParam("file")CommonsMultipartFile  file) throws IllegalStateException, IOException{
		//得到原文件名字
		String originalFilename = file.getOriginalFilename();
		String name2 = file.getName();
		
		//得到新文件的名字
		File f=new File("D:\\pics");
		
		if(!f.isDirectory()){
			f.mkdirs();//创建
			
		}
		
		File pic=new File(f,UUID.randomUUID().toString()+originalFilename);
		
		//向磁盘写出
		file.transferTo(pic);
		
		
		return "redirect:/upload.jsp";
	}
	
	@RequestMapping("/down")
	public  String  down(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		//得到需要下载的文件
				String path = request.getServletContext().getRealPath("/images/001.jpg");
				
				File file = new File(path);
				//读取服务器本地的文件
				FileInputStream in = new FileInputStream(file);
				
				/**
				 * 处理URL编码问题
				 */
				String fileName = file.getName();
				
				/**
				 * Cookie 能存储中文吗    
				 */
				//对文件名进行URl编码
				fileName = URLEncoder.encode(fileName, "utf-8");
				
				//判断不同浏览器
				String userAgent = request.getHeader("user-agent");
				String filefix = null;
				if(userAgent.contains("Trident")){
					//IE
					filefix = "filename="+fileName;
				}else if(userAgent.contains("Firefox")){
					//Firefox
					filefix = "filename*="+fileName;
				}else{
					filefix = "filename="+fileName;
				}
				
				//告诉浏览器以下载方式打开资源
				response.setHeader("Content-Disposition", "attachment;"+filefix);
				
				//把本地文件发送给浏览器
				byte[] buf = new byte[1024];
				int len = 0;
				while( (len=in.read(buf))!=-1 ){
					response.getOutputStream().write(buf, 0, len);
				}
				//关闭
				in.close();
				return "";
	}

/**
 *contentType: application/x-www-form-urlencoded  ：是key和value的数据格式
 * 
 * contentType:"application/json;charset=utf-8"     请求数据是json字符串          @RequestBody
 *  @RequestBody:是把传过来的json字符串 转换成java对象
 *  
 *  @ResponseBody 把java对象变成json字符串
 *  
 *  
 *  总结：
 *  	两种方式：1.key和value  浏览器和服务器 常用
 *  			2.json字符串   服务器和服务器之间       webService  
 *  
 * @param item
 * @return
 */
	@RequestMapping("/ajax")
	public   @ResponseBody Items ajax( /*@RequestBody */Items item){
		
		
		
		return item;
	}

}
