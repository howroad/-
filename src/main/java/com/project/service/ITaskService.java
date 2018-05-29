package com.project.service;

import java.util.List;

import com.project.pojo.TMessage;
import com.project.pojo.TOrganization;
import com.project.pojo.TTask;
import com.project.util.PageBean;
import com.project.vo.TaskTopicDto;
import com.project.vo.TaskVO;

public interface ITaskService {
	/**
	 * 查询任务
	 * @return pageBean
	 */
	public PageBean<TTask> findTask(int pageNo,int pageSize,String orgId,String taskLevel,String taskState);
	/**
	 * 显示任务详情
	 * @param taskId
	 * @return
	 */
	public TTask showTask(String taskId);
	/**
	 * 出发
	 * @param taskId 任务Id
	 * @param taskUserId 负责人Id
	 * @param userList 出动的用户Id
	 * @param carList 出动的车辆Id
	 * @return 成功或失败
	 */
	public boolean goTask(String taskId,String taskUserId,List<String> userList,List<String> carList);
	/**
	 * 查询该任务的所有消息记录
	 * @param orgId
	 * @return 成功或失败
	 */
	public List<TMessage> findMessgae(String taskId);
	/**
	 * 添加消息进入数据库并发送消息
	 * @param taskId 任务Id
	 * @param message 消息内容
	 * @return 成功或失败 
	 */
	public boolean sendMessage(String taskId,String msgkey,String message);
	
	/**
	 * 结束任务
	 * @param taskId 任务Id
	 * @return 成功或失败 
	 */
	public boolean endTask(String taskId,TOrganization org);
	/**
	 * 添加任务到未完成
	 * @param task
	 * @return 成功或失败
	 */
	public String addTaskPending(TaskTopicDto task);
	/**
	 * 无法出动任务,发送消息并结束
	 * @param taskId
	 * @param org
	 * @return 成功或失败
	 */
	public boolean cantGoTask(String taskId,TOrganization org);
	/**
	 * 显示任务详情
	 * @param taskId
	 * @return
	 */
	public TaskVO showTaskVO(String taskId);
}
