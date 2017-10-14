package com.frank.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.frank.aop")
@EnableAspectJAutoProxy//开启Spring对AspectJ代理的支持
public class AopConfig {

}
