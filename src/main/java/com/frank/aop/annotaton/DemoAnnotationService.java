package com.frank.aop.annotaton;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
	@Action(name="注解式拦截的 add操作 ")
	public void add() {
		System.out.println("annotation add");
	}
}
