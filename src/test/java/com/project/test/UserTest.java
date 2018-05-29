package com.project.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TOrganization;
import com.project.pojo.TUser;
import com.project.service.IOrganizationService;
import com.project.service.IUserService;

public class UserTest {
	private IUserService user;
	private ClassPathXmlApplicationContext a;
	@Before
	public void ser() {
		a = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		user = (IUserService) a.getBean("userService");
	}
	@After
	public void after() {
		a.close();
	}
	@Test
	/**
	 * @Description:根据用户Id查询所有权限的测试
	 */
	public void test() {
		user.findPowerByUserId("1");
	}

	@Test
	/**
	 * @Description:获得分页后User信息的测试
	 */
	public void test1() {
		System.out.println(user.pageBeanAll(1, 1, "", "1","1"));
	}

	@Test
	/**
	 * @Description:查询用户所有信息的测试
	 */
	public void test2() {
		System.out.println(user.showUser("1"));
	}

	@Test
	/**
	 * @Description:添加员工测试
	 */
	public void test3() {
		TUser user1 = new TUser();
		IOrganizationService orgService = (IOrganizationService) a.getBean("organizationService");
		TOrganization org = orgService.showOrganizationById("1");
		user1.setUserAddress("广东");
		user1.setUserBirth("1995-05-02");
		user1.setUserEmail("465622136@qq.com");
		user1.setUserGender("女");
		user1.setUserName("zhangsan");
		user1.setUserOutState(1);
		user1.setUserPassword("19950502");
		user1.setUserPic("123");
		user1.setUserRegistTime("2018-06-11 00:00:00");
		user1.setUserRname("赵丽");
		user1.setUserStates(1);
		user1.setUserTel("18435784567");
		user1.setTOrganization(org);
		user1.setUserManagerState(1);
		user.addUser(user1,null);

	}

	@Test
	/**
	 * @Description:修改员工信息测试
	 */
	public void test4() {
		TUser user2 = user.showUser("40288141636198520163619864b10000");
		user2.setUserAddress("山东禹城");
		user.updateUser(user2);

	}

	@Test
	/**
	 * @Description:删除员工测试
	 */
	public void test5() {
		user.deleteUser("2");
	}

	@Test
	/**
	 * @Description:登录测试
	 */
	public void test6() {
		user.login("zhangsan", "123");
	}

	@Test
	/**
	 * @Description:显示通讯录测试
	 */
	public void test7() {
		System.out.println(user.findAddressList(1, 1, "1", "", "1"));
	}
	/**
	 * 显示该机构中该角色管理的所有用户
	 * @param roleId
	 * @param orgId
	 * @return list
	 */
	@Test
	public void findAllUserInRole(){
		System.out.println(user.findAllUserInRole("402881886363b0d9016363b0f7da0000", "402881886363aef5016363aef9810000").get(0).getUserName());
	}
	/**
	 * 显示该机构中不属于该角色的用户
	 * @param roleId
	 * @param orgId
	 * @return
	 */
	@Test
	public void findAllUserNotInRole(){
		System.out.println(user.findAllUserNotInRole("402881886363b0d9016363b0f7da0000", "402881886363aef5016363aef9810000"));
	}
}
