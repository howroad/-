package com.project.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TUser;
import com.project.service.ISenderService;
import com.project.service.IUserService;

public class AmqTest {
	private ISenderService senderService;
	private ClassPathXmlApplicationContext context;
	private IUserService userService;
	@Before
	public void before() {
		System.out.println("start");
		context = new ClassPathXmlApplicationContext(new String[]{"spring-hibernate.xml","spring-mq.xml"});
		senderService = (ISenderService) context.getBean("senderService");
		userService = (IUserService) context.getBean("userService");
	}
	@After
	public void after() {
		context.close();
	}
	@Test
	public void test1() {
		TUser user =  userService.showUser("1");
		senderService.sendMsg(user);
	}
}
