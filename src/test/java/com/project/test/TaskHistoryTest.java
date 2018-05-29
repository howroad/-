/**
 * 
 */
package com.project.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.service.ITaskHistoryService;

/**
 * @author cyr
 * @Date 2018年5月15日
 * @version 1.0
 */
public class TaskHistoryTest {

	private ITaskHistoryService taskHistoryService;
	private ClassPathXmlApplicationContext s;
	@Before
	public void before() {
		s = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		taskHistoryService = (ITaskHistoryService) s.getBean("taskHistoryService");
	}
	@After
	public void after() {
		s.close();
	}
	/**
	 * 查询历史任务
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param orgName 机构名称
	 * @param areaKey 区域名称
	 * @return pageBean
	 */
	@Test
	public void  findAllTaskHistory(){
		System.out.println(taskHistoryService.findAllTaskHistory(1, 5, "1000","3000", "金牛区消防队", "JNQ"));
	}
	/**
	 * 显示历史事件详情
	 * @param thId 事件Id
	 * @return 历史事件详情
	 */
	@Test
	public void showTaskHistory() {
		System.out.println(taskHistoryService.showTaskHistory("1"));
	}
	/**
	 * 查询部门历史任务
	 * @param pageNo
	 * @param pageSize
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param orgName 机构名称
	 * @param taskName 任务名称
	 * @return 分页信息
	 */
	@Test
	public void findOrgTaskHistory() {
		System.out.println(taskHistoryService.findOrgTaskHistory(1, 5, "1000", "3000", "金牛区消防队", "金牛区"));
	}
	


}
