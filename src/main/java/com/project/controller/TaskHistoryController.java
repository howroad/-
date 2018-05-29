package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TTaskHistory;
import com.project.pojo.TUser;
import com.project.service.ITaskHistoryService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
@MyOperation("部门历史任务")
@Controller("taskHistoryController")
public class TaskHistoryController {
	@Autowired
	private ITaskHistoryService taskHistoryService;

	@RequestMapping("showAllTaskByOrg")
	@ResponseBody
	public PageBean<TTaskHistory> showAllTaskByOrg(String pageNo,String startTime,String endTime,String taskName,HttpServletRequest request){
		int pageNoValue = pageNo==null||pageNo.length()==0?1:Integer.parseInt(pageNo);
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgName = user.getTOrganization().getOrgName();
		return taskHistoryService.findOrgTaskHistory(pageNoValue, 5, startTime, endTime, orgName, taskName);
	}
	
	@RequestMapping("showHistoryById")
	@ResponseBody
	public TTaskHistory showHistoryById(String taskId) {
		return taskHistoryService.showTaskHistory(taskId);
	}
		
}
