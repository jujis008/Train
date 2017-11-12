package com.qf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.user.service.UserService;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private UserService userService;

	@RequestMapping("/h1")
	public String hello() {
		System.out.println("action");
		userService.say();
		return "1";
	}

}
