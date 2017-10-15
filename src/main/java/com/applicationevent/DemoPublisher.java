package com.applicationevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {

	//注入ApplicationContext用来发布事件
	@Autowired
	ApplicationContext applicationContext;
	
	
	public void publish(String msg) {
		System.out.println("发布消息:"+msg);
		
		//使用ApplicationContext的publisher方法来发布
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}
}
