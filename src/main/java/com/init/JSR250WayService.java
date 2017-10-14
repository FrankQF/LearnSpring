package com.init;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {
	@PostConstruct//在构造函数执行完成之后执行
	public void init() {
		System.out.println("jsr250-init-method");
	}
	
	public JSR250WayService() {
		System.out.println("初始化JSR250WayService");
	}
	@PreDestroy//在Bean销毁前执行
	public  void destory() {
		System.out.println("jsr250-destory-method");
	}
}
