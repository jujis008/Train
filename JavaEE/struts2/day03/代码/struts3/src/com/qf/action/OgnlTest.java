package com.qf.action;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlTest {
	
	@Test
	public void run1() throws OgnlException{
		//获取ognl对象
		OgnlContext context=new OgnlContext();
		
		//存值
		context.put("name", "张三疯~~~");
		
		//取值	
		Object value = Ognl.getValue("#name", context, context.getRoot());
		System.out.println(value);
		
	}
	
	@Test
	public void run2() throws OgnlException{
		//获取ognl对象
		OgnlContext context=new OgnlContext();
		
		//存值
		context.put("name", "张三疯~~~");
		
		//取值	
		Object value = Ognl.getValue("#name.length()", context, context.getRoot());
		Object value1 = Ognl.getValue("'123456'.length()", context, context.getRoot());
		System.out.println(value1);
		
	}

}
