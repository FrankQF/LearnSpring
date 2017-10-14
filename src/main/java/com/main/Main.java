package com.main;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.init.BeanWayService;
import com.init.JSR250WayService;


public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(Config.class);
		BeanWayService beanWayService=context.getBean(BeanWayService.class);
		
		JSR250WayService jsr250WayService=context.getBean(JSR250WayService.class);
		
		context.close();
	}
}
