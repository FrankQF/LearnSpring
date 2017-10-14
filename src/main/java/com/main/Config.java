package com.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.init.BeanWayService;
import com.init.JSR250WayService;

@Configuration
@ComponentScan("com.init")
public class Config {
	//Java配置
	//initMethod在指定类的构造之后，destroyMethod在指定类的销毁之前执行
	@Bean(initMethod="init",destroyMethod="destory")
	BeanWayService beanWayService() {
		return new BeanWayService();
	}
	//注解方式
	@Bean
	JSR250WayService jsr250WayService() {
		return new JSR250WayService();
	}

}
