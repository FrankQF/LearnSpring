package com.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class DemoSingletonService {
	
	public DemoSingletonService() {
		System.out.println("new DemoSingletonService");
	}

}
