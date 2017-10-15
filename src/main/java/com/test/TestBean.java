package com.test;

public class TestBean {
	private  String content;
	
	public TestBean(String contnet) {
		this.content = contnet;
		System.out.println("初始化TestBean");
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
