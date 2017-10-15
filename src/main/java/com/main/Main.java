package com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(Config.class);
		//报错不用理会Could not find default ScheduledExecutorService bean 没找到调度器，则使用默认调度器
		
//		context.close();
	}
}
