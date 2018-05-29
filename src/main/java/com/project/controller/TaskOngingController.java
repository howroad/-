package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TTask;
import com.project.pojo.TUser;
import com.project.service.ITaskService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
import com.project.vo.TaskVO;
@MyOperation("进行中任务")
@Controller("taskOngoingController")
public class TaskOngingController {
	@Autowired
	private ITaskService taskService;

	
	@RequestMapping("findAllTaskOngoing")
	@ResponseBody
	public PageBean<TTask> findAllTaskOngoing(String pageNo,String taskLevel,HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		int pageNoValue = pageNo==null||pageNo.length()==0?1:Integer.parseInt(pageNo);
		return taskService.findTask(pageNoValue, 5, orgId, taskLevel,"1");
	}
	
	@RequestMapping("showTaskVO")
	@ResponseBody
	public TaskVO showTaskVO(String taskId){
		return taskService.showTaskVO(taskId);
	}
	
	@RequestMapping("sendMsg")
	@ResponseBody
	public boolean sendMsg(String taskId,String msg){
		return taskService.sendMessage(taskId, "2", msg);
	}
	
	
	@RequestMapping("endTask")
	@ResponseBody
	public boolean endTask(String taskId,HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		return taskService.endTask(taskId, user.getTOrganization());
	}
}
