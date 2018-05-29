/**
 * 
 */
package com.project.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TData;
import com.project.service.IDataService;

/**
 * @author cyr
 * @Date 2018年5月15日
 * @version 1.0
 */
public class DataTest {
	private IDataService dataService;
	private ClassPathXmlApplicationContext s;
	@Before
	public void before() {
		s = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		dataService = (IDataService) s.getBean("dataService");
	}
	@After
	public void after() {
		s.close();
	}

	/**
	 * 查修该种类所有数据
	 * @return 数据List
	 */
	@Test
	public void findData(){
		System.out.println(dataService.findData("JGLX"));
	}
	/**
	 * 添加信息
	 * @param data 信息
	 * @return 成功或失败
	 */
	@Test
	public void add() {
		TData data = new TData();
		data.setDataDesc("测试");
		data.setDataKey("cs");
		data.setDataType("cs");
		data.setDataValue("测试");
		System.out.println(dataService.add(data));
	}
	/**
	 * 获得所有数据类型
	 */
	@Test
	public void getAllType() {
		System.out.println(dataService.getAllType());
	}
}
