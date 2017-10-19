package com.qf.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class MyDateTypeConverter extends DefaultTypeConverter{
	
	
	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {
		// TODO Auto-generated method stub
		//  yyyy/mm/dd  把字符串变成Date
		//value  从jsp页面传过来的birthday的值  String[]
		/**
		 * 从jsp到action:把时间字符串转换成java.util.Date
		 * 从action到jsp：吧java.util.Date转成时间字符串    默认转成2102-12-12      显示2012年12月12日
		 * 
		 * 
		 * 
		 */
		
		//前台jsp有可能传过来  yyyy-MM-dd 、yyyy/MM/dd 、yyyy年MM月dd日
		String regex="[0-9]{4}/[0-9]{2}/[0-9]{2}";
		String regex1="[0-9]{4}-[0-9]{2}-[0-9]{2}";
		String regex2="[0-9]{4}年[0-9]{2}月[0-9]{2}日";
		
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日");
		
		if(toType==Date.class){//从jsp到action:把时间字符串转换成java.util.Date
			String[] v=(String[])value;
			if(v[0].matches(regex)){//2012/12/12
				System.out.println("value====="+v[0]);
				try {
					Date parse = sdf.parse(v[0]);
					return parse;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(v[0].matches(regex1)){//2012-12-12
				System.out.println("value====="+v[0]);
				try {
					Date parse = sdf1.parse(v[0]);
					return parse;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(v[0].matches(regex2)){//2012年12月12日
				System.out.println("value====="+v[0]);
				try {
					Date parse = sdf2.parse(v[0]);
					return parse;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			
		}
		

		
		Object convertValue = super.convertValue(context, value, toType);
		System.out.println("父类的处理："+convertValue);
		return convertValue;
	}

}
