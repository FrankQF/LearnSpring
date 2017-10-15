package com.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
	@Bean
	@Profile("dev")//profile为dev时，实例化devDemoBean
	public DemoBean devDemoBean() {
		return new DemoBean("from dev profile");
	}
	@Bean
	@Profile("prod")//profile为dev时，实例化prodDemoBean
	public DemoBean prodDemoBean() {
		return new DemoBean("from prod profile");
	}
}
