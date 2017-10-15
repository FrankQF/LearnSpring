package com.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.test.TestBean;


//@ComponentScan("com.main")
@Configuration
public class Config {

	@Bean
	@Profile("dev")
	public TestBean devTestBean() {
		return new TestBean("from development profile");
	}
	@Bean
	@Profile("prod")
	public TestBean prodTestBean() {
		return new TestBean("from production profile");
	}
}
