package com.frank.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.frank.springmvc.interceptor.DemoInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.frank.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	//配置拦截器的Bean
	@Bean
	public DemoInterceptor demoInterceptor (){
		return new DemoInterceptor();
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");//运行时会将页面自动编译到这个目录下
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	//继承WebMvcConfigurerAdapter 重写此方法可对SpringMVC进行配置
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceHandler指文件放置的目录 
		//addResourceLocations指对外暴露的访问路径
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		
	}
	//重写addInterceptors方法，注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
	
	//快捷添加ViewController
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("toUpload").setViewName("/upload");
		
	}
	//配置接收文件
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}
}
