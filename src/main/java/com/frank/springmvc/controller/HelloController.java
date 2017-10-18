package com.frank.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frank.springmvc.dto.DemoObj;

@Controller//注解控制器
public class HelloController {
	//配置url和方法之间的映射
	@RequestMapping("/index")
	public String hello() {
		System.out.println("index");
		return "index";//返回值为index，说明我们的页面放置的路径为/WEB-INF/classer/views/index.jsp
	}
	

}
