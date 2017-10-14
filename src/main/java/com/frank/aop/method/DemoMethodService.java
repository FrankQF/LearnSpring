package com.frank.aop.method;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {

	public void add() {
		System.out.println("add method");
	}
}
