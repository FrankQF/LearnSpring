package com.frank.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.frank.app.MyMvcConfig;
import com.frank.springmvc.service.DemoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources") //注解在类上，用来生命加载的ApplicationContext是一个WebApplicationContext，属性指定
//的是web资源的位置
public class TestControllerIntegrationTests {
	private MockMvc mockMvc; //2模拟mvc对象
	//通过MockMvcBuilders.webAppContextSetup(this.wac).build(); 初始化
	@Autowired
	private DemoService demoService;//测试用例注入Bean
	
	@Autowired 
	WebApplicationContext wac; //注入WebApplicationContext
	
    @Autowired 
    MockHttpSession session; //注入模拟http session
    
    @Autowired 
    MockHttpServletRequest request; //注入模拟http request
    
    @Before //测试前初始化
    public void setup() {
    	mockMvc =
    			MockMvcBuilders.webAppContextSetup(this.wac).build(); //2
    	}
	
	@Test
	public void testNormalController() throws Exception{
		mockMvc.perform(get("/normal")) //8模拟发送get请求
				.andExpect(status().isOk())//预期返回值200
				.andExpect(view().name("page"))//预期wiew的名称为page
				.andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))//预期页面转向的真正路径
				.andExpect(model().attribute("msg", demoService.saySomething()));//预期model里的值
				
	}
	
	@Test
	public void testRestController() throws Exception{
		mockMvc.perform(get("/testRest")) //模拟发送test请求
        .andExpect(status().isOk())
         .andExpect(content().contentType("text/plain;charset=UTF-8"))//预期返回值的媒体类型为
        .andExpect(content().string(demoService.saySomething()));//预期返回值的内容为
	}

}
