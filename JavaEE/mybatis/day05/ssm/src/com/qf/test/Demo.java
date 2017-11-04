package com.qf.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Demo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String name="李二狗";
		/**
		 * URLEncoder.encode(Str,charset);
		 * 
		 * URLDecode.decode(str,charset)
		 * 
		 * 
		 */
		
		 String encode = URLEncoder.encode(name, "utf-8");
		 System.out.println(encode);
		 
		 String decode = URLDecoder.decode(encode, "utf-8");
		 
		 System.out.println(decode);
		 
	
	}

}
