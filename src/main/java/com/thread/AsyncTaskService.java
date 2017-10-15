package com.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
/**
 * 任务执行类
 * @author Administrator
 *
 */
@Service
public class AsyncTaskService {

	//通过Async注解表明该方法是个异步方法，如果注解在类级别，则表明该类所有的方法都是异步方法
	//而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
	@Async
	public void executeAsyncTask(Integer i) {
		System.out.println("执行异步任务 :" + i);
	}
	
	@Async
	public void executeAsyncTaskAdd(Integer i) {
		System.out.println("执行异步任务i+1 :" + (i+1));
	}
}
