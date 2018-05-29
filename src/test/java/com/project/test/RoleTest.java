/**
 * 
 */
package com.project.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TRole;
import com.project.service.IRoleService;

/**
 * @author howroad
 * @Date 2018年5月15日
 * @version 1.0
 */
public class RoleTest {
	private IRoleService roleService;
	private ClassPathXmlApplicationContext context;

	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		roleService = (IRoleService) context.getBean("roleService");
	}

	@After
	public void after() {
		context.close();
	}
	/**
	 * 获得所有的角色
	 * @return
	 */
	@Test
	public void findAllRole() {
		System.out.println(roleService.findAllRole());
	}
	/**
	 * 获得所有的权限
	 * @return
	 */
	@Test
	public void findAllPower() {
		System.out.println(roleService.findAllPower().size());
	}
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@Test
	public void addRole() {
		System.out.println(roleService.addRole(new TRole("测试角色", "测试角色",null,null)));
	}
}
