package com.init;

public class BeanWayService {
	
	public void init() {
		System.out.println("@Bean-init-method");
	}
	
	public void destory() {
		System.out.println("@Bean-destory-method");
	}
	
	public BeanWayService() {
		System.out.println("BeanWayService 初始化");
	}
}
