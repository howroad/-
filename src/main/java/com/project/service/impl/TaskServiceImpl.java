/**
 * 
 */
package com.project.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.ICarDao;
import com.project.dao.IDataDao;
import com.project.dao.IMessageDao;
import com.project.dao.IOrganizationDao;
import com.project.dao.ITaskCarDao;
import com.project.dao.ITaskDao;
import com.project.dao.ITaskHistoryDao;
import com.project.dao.ITaskUserDao;
import com.project.dao.IUserDao;
import com.project.pojo.TCar;
import com.project.pojo.TMessage;
import com.project.pojo.TOrganization;
import com.project.pojo.TTask;
import com.project.pojo.TTaskHistory;
import com.project.pojo.TUser;
import com.project.service.ISenderService;
import com.project.service.ITaskService;
import com.project.util.PageBean;
import com.project.vo.ReplyQueueDto;
import com.project.vo.TaskTopicDto;
import com.project.vo.TaskVO;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
@Repository("taskService")
public class TaskServiceImpl implements ITaskService {
	@Autowired
	private ITaskDao taskDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private ICarDao carDao;
	@Autowired
	private ITaskUserDao taskUserDao;
	@Autowired
	private ITaskCarDao taskCarDao;
	@Autowired
	private IMessageDao messageDao;
	@Autowired
	private ITaskHistoryDao taskHistoryDao;
	@Autowired
	private ISenderService senderService;
	@Autowired
	private IOrganizationDao organizationDao;
	@Autowired
	private IDataDao dataDao;
	@Autowired
	private HttpSession session;

	@Override
	public PageBean<TTask> findTask(int pageNo, int pageSize,String orgId,String taskLevel,String taskState) {
		return taskDao.findTask(pageNo, pageSize,orgId,taskLevel,taskState);
	}

	@Override
	public TTask showTask(String taskId) {
		return taskDao.findById(taskId);
	}

	@Override
	public boolean goTask(String taskId, String taskUserId, List<String> userList, List<String> carList) {
		// 1.循环把员工的外出状态更改
		userDao.letGo(userList);
		// 2.循环把车辆的外出状态更改
		carDao.letGo(carList);
		// 3.添加多对多关系表
		taskUserDao.addUsers(taskId, userList);
		taskCarDao.addCars(taskId, carList);
		// 4.设置任务状态为进行中,设置负责人
		TTask task = taskDao.findById(taskId);
		task.setUserId(taskUserId);
		task.setTaskState(1);
		taskDao.update(task);
		// 5.存储消息到数据库
		messageDao.add(new TMessage(task, LocalDateTime.now().toString(),"已出动", "1"));
		// 6.发送MQ数据
		TUser user = (TUser)session.getAttribute("session_user");
		ReplyQueueDto rqd = new ReplyQueueDto("1", "我已出动", task.getEventCode(), task.getTOrganization().getOrgCode(),user.getUserRname(),user.getUserTel());
		senderService.sendMsg(rqd);
		return true;
	}

	@Override
	public List<TMessage> findMessgae(String taskId) {
		return new ArrayList<TMessage>(taskDao.findById(taskId).getTMessages());
	}

	@Override
	public boolean sendMessage(String taskId, String msgKey, String message) {
		// 添加数据库
		// 1.查到任务
		TTask task = taskDao.findById(taskId);
		TMessage m = new TMessage(task, LocalDateTime.now().toString(), message, msgKey);
		// 2.添加
		messageDao.add(m);
		// 发送消息
		TUser user = (TUser)session.getAttribute("session_user");
		ReplyQueueDto rqd = new ReplyQueueDto("2", message, task.getEventCode(), task.getTOrganization().getOrgCode(),user.getUserRname(),user.getUserTel());
		senderService.sendMsg(rqd);
		return true;
	}

	@Override
	public boolean endTask(String taskId, TOrganization org) {
		// 1.改变状态
		TTask task = taskDao.findById(taskId);
		task.setTaskState(2);
		taskDao.update(task);
		String endTime = LocalDateTime.now().toString();
		// 2.归队
		List<TUser> userList = userDao.findUserOnTask(taskId);
		List<TCar> carList = carDao.findCarOnTask(taskId);
		userDao.letBack(userList);
		carDao.letBack(carList);
		// 3.发送一个归队消息
		TUser sessionUser = (TUser)session.getAttribute("session_user");
		ReplyQueueDto rqd = new ReplyQueueDto("3", "我已归队", task.getEventCode(), task.getTOrganization().getOrgCode(),sessionUser.getUserRname(),sessionUser.getUserTel());
		senderService.sendMsg(rqd);
		// 4.添加到数据
		TMessage message = new TMessage(task, endTime, "我已归队", "2");
		messageDao.add(message);
		// 5.保存数据到Hisotry
		String fuzeren ;
		String dianhua;
		if(task.getUserId()==null) {
			fuzeren = "无";
			dianhua = "无";
		}else {
			TUser user = userDao.findById(task.getUserId());
			fuzeren = user.getUserRname();
			dianhua = user.getUserTel();
		}
		TTaskHistory taskHistory = new TTaskHistory(task.getTaskName(), task.getTaskAddress(), task.getEventCode(),
				task.getTaskTime(), endTime, task.getTaskPersonNum(), task.getTaskCarNum(), fuzeren,
				dianhua, org.getOrgName(), dataDao.getValue("RWDJ", task.getTaskLevel()), dataDao.getValue("RWLX", task.getTaskType()), org.getOrgArea());
		taskHistoryDao.add(taskHistory);
		return true;
	}

	@Override
	public String addTaskPending(TaskTopicDto task) {
		TOrganization org = organizationDao.findByCode(task.getOrgCode());
		TTask tTask = new TTask(org, task.getrName(), task.getrAddress(), task.getrCode(),
				LocalDateTime.now().toString(), Integer.parseInt(task.getrPersonNum()), Integer.parseInt(task.getrCarNum()), 0, task.getrType().toUpperCase(),
				task.getrLevel(), null, null, null, null);
		return taskDao.add(tTask);
	}

	@Override
	public boolean cantGoTask(String taskId, TOrganization org) {
		String endTime = LocalDateTime.now().toString();
		sendMessage(taskId, "2", "资源不足未出动");
		//添加该消息到数据库
		TTask task = taskDao.findById(taskId);
		TMessage message = new TMessage(task,endTime , "资源不足未出动", "2");
		messageDao.add(message);
		//改变事件状态为已完成
		task.setTaskState(2);
		taskDao.update(task);
		//添加历史事件到数据库
		TTaskHistory taskHistory = new TTaskHistory(task.getTaskName(), task.getTaskAddress(), task.getEventCode(),
				task.getTaskTime(), endTime, task.getTaskPersonNum(), task.getTaskCarNum(), "无人员出动",
				"无", org.getOrgName(),dataDao.getValue("RWDJ", task.getTaskLevel()), dataDao.getValue("RWLX", task.getTaskType()), org.getOrgArea());
		taskHistoryDao.add(taskHistory);
		return true;
	}

	@Override
	public TaskVO showTaskVO(String taskId) {
		TTask task = showTask(taskId);
		String goTime = messageDao.getStartTime(taskId);
		String userId = task.getUserId();
		if(userId!=null) {
			TUser user = userDao.findById(userId);
			return new TaskVO(task, goTime,user,userDao.findUserOnTask(taskId),carDao.findCarOnTask(taskId));
		}
		return new TaskVO(task, goTime, null, userDao.findUserOnTask(taskId), carDao.findCarOnTask(taskId));
	}

}
