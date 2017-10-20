package com.qf.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

public class ChartAction extends ActionSupport{
	private static final long serialVersionUID = 6753440299221230391L;
	
	private UserService userService=new UserServiceImpl();
	
	private Map<String,Object> jsonMap=new HashMap<>();
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
	
	public String chart(){
		
		Map<String, Object> map = userService.getChart();
		jsonMap.put("xAxis", map.get("sex"));
		jsonMap.put("yAxis", map.get("count"));
		
		
		return "chart";
	}
	
	
	
	
	
	
	

}
