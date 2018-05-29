package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TCar;
import com.project.pojo.TOrganization;
import com.project.pojo.TTask;
import com.project.pojo.TUser;
import com.project.service.IOrganizationService;
import com.project.service.ITaskService;
import com.project.service.IUserService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
import com.project.vo.OrgStateVO;
@MyOperation("待处理任务")
@Controller("taskPendingController")
public class TaskPendingController {
	@Autowired
	private ITaskService taskService;
	@Autowired
	private IOrganizationService orgService; 
	@Autowired
	private IUserService userService;
	
	@RequestMapping("findAllTaskPending")
	@ResponseBody
	public PageBean<TTask> findAllTaskPending(String pageNo,String taskLevel,HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		int pageNoValue = pageNo==null||pageNo.length()==0?1:Integer.parseInt(pageNo);
		return taskService.findTask(pageNoValue, 5, orgId, taskLevel,"0");
	}
	
	@RequestMapping("getOrgState")
	@ResponseBody
	public OrgStateVO getOrgState(HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		return orgService.orgState(orgId);
	}
	@RequestMapping("getTaskById")
	@ResponseBody
	public TTask getTaskById(String taskId) {
		return taskService.showTask(taskId);
	}
	
	@RequestMapping("findUserCanGo")
	@ResponseBody
	public List<TUser> findUserCanGo(HttpServletRequest request) {
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		return userService.findUserCanGo(orgId);
	}
	
	@RequestMapping("findCarCanGo")
	@ResponseBody
	public List<TCar> findCarCanGo(HttpServletRequest request) {
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		return userService.findCarCanGo(orgId);
	}
	@RequestMapping("goTask")
	@ResponseBody
	public boolean goTask(String taskId, String taskUserId, 
			@RequestParam(value = "userList", required = false) List<String> userList,
			@RequestParam(value = "carList", required = false) List<String> carList) {
		return taskService.goTask(taskId, taskUserId, userList, carList);
	}
	@RequestMapping("cantGoTask")
	@ResponseBody
	public boolean cantGoTask(String taskId,HttpServletRequest request) {
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		TOrganization org = user.getTOrganization();
		return taskService.cantGoTask(taskId, org);
	}
}
