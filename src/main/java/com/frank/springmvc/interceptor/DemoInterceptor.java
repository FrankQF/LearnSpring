package com.frank.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 继承HandlerInterceptorAdapter类 来实现自定义拦截器，实现自定义拦截器后要在配置中注入
 * @author Administrator
 *
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle :"+request.getRequestURL());
		//return true就是可以进入请求，return false则不可进入请求
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post :"+request.getRequestURL());
		System.out.println("postHandle :"+request.getRequestURL());
	}
}
