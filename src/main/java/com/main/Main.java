package com.main;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.applicationevent.DemoPublisher;



public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(Config.class);
		DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
		demoPublisher.publish("hello application event");
		
		context.close();
	}
}
