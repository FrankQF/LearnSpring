package com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.frank.aop.AopConfig;
import com.frank.aop.annotaton.DemoAnnotationService;
import com.frank.aop.method.DemoMethodService;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(AopConfig.class);
		
		DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
		
		DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
		
		demoAnnotationService.add();
		
		demoMethodService.add();
		
		context.close();
	}
}
