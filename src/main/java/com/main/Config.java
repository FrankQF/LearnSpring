package com.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ComponentScan("com.schedule")
@EnableScheduling//开启对计划任务的支持
public class Config {

}
