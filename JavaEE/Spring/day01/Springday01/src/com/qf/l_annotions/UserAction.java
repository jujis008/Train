package com.qf.l_annotions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("userAction")
//@Scope(value="prototype")
public class UserAction {
	//按照类型自动注入
	/*@Autowired
	private UserService userService;*/
	/**
	 * @Resource()是java给我们提供
	 * 
	 * Resource(name="userService")就相当于
	 * @Autowired
		@Qualifier(value="userService")
	 */
	@Resource(name="userService")
	private UserService userService;
	
	public String execute(){
		
		userService.sayHlleo();
		return "";
	}
	
	
	@PostConstruct
	void init(){
		System.out.println("初始化~~~");
	}
	@PreDestroy
	void destory(){
		System.out.println("销毁~~~");
	}

}
