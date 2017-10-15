package com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.thread.AsyncTaskService;


public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(Config.class);
		AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
		
		for(int i =0 ; i<10 ;i++) {
			asyncTaskService.executeAsyncTask(i);
			asyncTaskService.executeAsyncTaskAdd(i);
		}
		
		context.close();
	}
}
