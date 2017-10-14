package com.frank.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.frank.aop.annotaton.Action;


@Aspect//aspect注解声明一个切面
@Component//让此切面成为Spring容器管理的Bean
public class LogAspect {
	//通过@Pointcut注册一个切点
	@Pointcut("@annotation(com.frank.aop.annotaton.Action)")
	public void annotationPointCut() {	};
	
	@After("annotationPointCut()")
	public void annotationAfter(JoinPoint joinpoint) {
		MethodSignature signature=(MethodSignature) joinpoint.getSignature();
		Method method=signature.getMethod();
		Action action=method.getAnnotation(Action.class);
		
		System.out.println("注解式拦截" + action.name());
		
	}
	
	//Before注解声明一个建言，此建言直接使用拦截规则作为参数
	//需要注意pointcut expression的正确与否
	@Before("execution(* com.frank.aop.method.*.*(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature=(MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则before拦截，" + method.getName());
	}
	
	@After("execution(* com.frank.aop.method.*.*(..))")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature=(MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则after拦截，" + method.getName());
	}
}
