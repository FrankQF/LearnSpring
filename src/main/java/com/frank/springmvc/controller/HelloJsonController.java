package com.frank.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frank.springmvc.dto.DemoObj;

@RestController
public class HelloJsonController {
	@RequestMapping("/json")
	public DemoObj json() {
		DemoObj demoObj=new DemoObj();
		demoObj.setId(123l);
		demoObj.setName("abc");
		return demoObj;
	}
}
