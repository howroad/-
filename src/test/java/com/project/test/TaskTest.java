/**
 * 
 */
package com.project.test;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.pojo.TOrganization;
import com.project.service.IOrganizationService;
import com.project.service.ITaskService;
import com.project.vo.TaskTopicDto;

/**
 * @author howroad
 * @Date 2018年5月15日
 * @version 1.0
 */
public class TaskTest {
	private ITaskService taskService;
	private ClassPathXmlApplicationContext context;
	@Before
	public void before() {
		System.out.println("start");
		context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		taskService = (ITaskService) context.getBean("taskService");
	}
	@After
	public void after() {
		context.close();
	}
	/**
	 * 查询所有未完成的任务
	 * @return pageBean
	 */
	@Test
	public void findTaskPending(){
		System.out.println(taskService.findTask(1, 5,"0","0",""));
	}
	/**
	 * 显示任务详情
	 * @param taskId
	 * @return
	 */
	@Test
	public void showTask() {
		System.out.println(taskService.showTask("4028813c6362204c0163622054bc0000"));
	}
	/**
	 * 出发
	 * @param taskId 任务Id
	 * @param taskUserId 负责人Id
	 * @param userList 出动的用户Id
	 * @param carList 出动的车辆Id
	 * @return 成功或失败
	 */
	@Test
	public void goTask() {
		System.out.println(taskService.goTask("4028813c6362204c0163622054bc0000", "1", Arrays.asList("1","4028813f6361d06b016361d0768b0001"), Arrays.asList("40288141635da70b01635da71e670000")));
	}
	/**
	 * 查询该任务的所有消息记录
	 * @param orgId
	 * @return 成功或失败
	 */
	@Test
	public void findMessgae(){
		System.out.println(taskService.findMessgae("4028813c6362204c0163622054bc0000").size());
	}
	/**
	 * 添加消息进入数据库并发送消息
	 * @param taskId 任务Id
	 * @param message 消息内容
	 * @return 成功或失败 
	 */
	@Test
	public void sendMessage() {
		System.out.println(taskService.sendMessage("4028813c6362204c0163622054bc0000", "2", "建议增员!"));
	}
	
	/**
	 * 结束任务
	 * @param taskId 任务Id
	 * @return 成功或失败 
	 */
	@Test
	public void endTask() {
		IOrganizationService orgService = (IOrganizationService) context.getBean("organizationService");
		TOrganization org = orgService.showOrganizationById("1");
		System.out.println(taskService.endTask("4028813c6362204c0163622054bc0000", org));
	}
	/**
	 * 添加任务到未完成
	 * @param task
	 * @return 成功或失败
	 */
	@Test
	public void addTaskPending() {
		TaskTopicDto task = new TaskTopicDto("组织机构代码号", "事件编号1", ""+50, ""+6, "郎沃学校", "火灾", "事件名称", "3");
		System.out.println(taskService.addTaskPending(task));
	}
	
}
