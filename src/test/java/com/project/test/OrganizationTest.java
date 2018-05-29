/**
 * 
 */
package com.project.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.service.IOrganizationService;
import com.project.vo.OrganizationVO;

/**
 * @author cyr
 * @Date 2018年5月15日
 * @version 1.0
 */
public class OrganizationTest {
	private IOrganizationService organizationService;
	private ClassPathXmlApplicationContext s;

	@Before
	public void before() {
		s = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		organizationService = (IOrganizationService) s.getBean("organizationService");
	}

	@After
	public void after() {
		s.close();
	}

	/**
	 * 查询区域的PageBean
	 * 
	 * @param pageNo 查询的页码数
	 * @param pageSize 每页显示的数量
	 * @param orgTypeKey 机构类型
	 * @param AreaKey 区域
	 * @return
	 */
	@Test
	public void pageBean() {
		organizationService.pageBean(1, 5, "XFBM", "QYQ");
	}

	/**
	 * 添加机构
	 * 
	 * @param org 机构VO
	 * @return boolean
	 */
	@Test
	public void addOrg() {
		OrganizationVO org = new OrganizationVO(null, "武侯区消防部门", "WHQ", "XFBM", "王麻子", "1231456543", 0, 0, 0, 0, "wmz",
				"555555", "图片5", "5");
		organizationService.addOrg(org);
	}

	/**
	 * 修改管理员密码
	 * 
	 * @param orgId 区域Id
	 * @param pwd
	 * @return boolean
	 */
	@Test
	public void updateUserPwd() {
		organizationService.updateUserPwd("1", "250250");
	}

	/**
	 * 显示当前机构的库存状态
	 * 
	 * @param orgId 机构Id
	 * @return 机构的VO
	 */
	@Test
	public void orgState() {
		System.out.println(organizationService.orgState("1"));
	}

	/**
	 * 根据ID查询机构详情
	 * 
	 * @param orgId 机构Id
	 * @return 机构的详情
	 */
	@Test
	public void showOrganizationById() {
		System.out.println(organizationService.showOrganizationById("1"));
	}

}
