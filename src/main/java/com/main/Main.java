package com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.scope.DemoPropertyService;
import com.scope.DemoSingletonService;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(Config.class);
		DemoSingletonService s1=context.getBean(DemoSingletonService.class);
		DemoSingletonService s2=context.getBean(DemoSingletonService.class);
		DemoPropertyService p1=context.getBean(DemoPropertyService.class);
		DemoPropertyService p2=context.getBean(DemoPropertyService.class);
		
		System.out.println("s1与s2是否相等" + s1.equals(s2) +"");
		System.out.println("p1与p2是否相等" + p1.equals(p2) +"");
		
		
		context.close();
	}
}
