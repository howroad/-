package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TTaskHistory;
import com.project.service.ITaskHistoryService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
@MyOperation("任务总览")
@Controller("taskOverviewController")
public class TaskOverviewController {
	@Autowired
	private ITaskHistoryService taskHistoryService;

	@RequestMapping("showAllTask")
	@ResponseBody
	public PageBean<TTaskHistory> showAllTask(String pageNo,String startTime,String endTime,String orgName,String areaKey){
		int pageNoValue = pageNo==null||pageNo.length()==0?1:Integer.parseInt(pageNo);
		return taskHistoryService.findAllTaskHistory(pageNoValue, 5, startTime, endTime, orgName, areaKey);
	}
	
	@RequestMapping("findHistoryById")
	@ResponseBody
	public TTaskHistory findHistoryById(String taskId) {
		return taskHistoryService.showTaskHistory(taskId);
	}
	
}
