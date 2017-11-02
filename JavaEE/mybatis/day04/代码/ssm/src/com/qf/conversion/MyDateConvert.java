package com.qf.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConvert implements Converter<String, Date>{

	@Override
	public Date convert(String value) {
		// TODO Auto-generated method stub
		//需要把  value 转换成Date
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date date = sdf.parse(value);
			//成功返回date
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
