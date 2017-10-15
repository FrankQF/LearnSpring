package com.frank;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.main.Config;
import com.test.TestBean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {Config.class})//加载配置ApplicationContext，classes属性用于加载配置类
@ActiveProfiles("prod")//用来声明活动的profile
public class DemoBeanIntegrationTests {

	@Autowired
	private TestBean testBean;
	
	@Test
	public void prodBeanShouldInject() {
		String expected = "from production profile";
		String actual = testBean.getContent();
		Assert.assertEquals(expected, actual);
	}
}
