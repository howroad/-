package com.project.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TCar;
import com.project.pojo.TOrganization;
import com.project.service.ICarService;
import com.project.service.IOrganizationService;

public class CarTest {
	private ICarService car;
	private ClassPathXmlApplicationContext s;
	@Before
	public void si() {
		s = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		car = (ICarService) s.getBean("carService");
	}
	public void after() {
		s.close();
	}

	@Test
	/**
	 * @Description:车辆的删除测试；
	 */
	public void test() {
		car.deleteCar("1");
	}

	@Test
	/**
	 * @Description:车辆的添加测试；
	 */
	public void test1() {
		IOrganizationService orgService = (IOrganizationService) s.getBean("organizationService");
		TOrganization org = orgService.showOrganizationById("1");
		TCar car1 = new TCar(org, "鲁N27162", 5, "法拉利", 0, 0, 0, "XKC", null);
		car.addCar(car1,null);
	}

	@Test
	/**
	 * @Description:车辆状态状态测试；
	 */
	public void test2() {
		car.setCarBreak("4028813c63620f0f0163620f18080000");
	}

}
