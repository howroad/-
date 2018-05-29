package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TData;
import com.project.pojo.TPower;
import com.project.service.IDataService;
import com.project.service.impl.TestService;

@Controller("testController")
public class TestController {
	@Autowired
	private TestService testService;
	@Autowired
	private IDataService dataService;

	@RequestMapping("test1")
	@ResponseBody
	public String test() {
		TPower power1 = new TPower("机构总览", "org_overview.jsp", null);
		TPower power2 = new TPower("任务总览", "task_overview.jsp", null);
		TPower power3 = new TPower("数据分析", "data_analysis.jsp", null);
		TPower power4 = new TPower("数据字典维护", "data_manager.jsp", null);
		TPower power5 = new TPower("待处理任务", "task_pending.jsp", null);
		TPower power6 = new TPower("进行中任务", "task_ongoing.jsp", null);
		TPower power7 = new TPower("角色管理", "role_manager.jsp", null);
		TPower power8 = new TPower("人员管理", "user_manager.jsp", null);
		TPower power9 = new TPower("车辆管理", "car_manager.jsp", null);
		TPower power10 = new TPower("部门历史任务", "task_history.jsp", null);
		TPower power11 = new TPower("我的信息", "user_information.jsp", null);
		TPower power12 = new TPower("通讯录", "address_list.jsp", null);
		testService.addPower(power1,power2,power3,power4,power5,power6,power7,power8,power9,power10,power11,power12);
		return "success";
	}
	@RequestMapping("test2")
	@ResponseBody
	public String test2() {
		List<TData> list = dataService.findData("QY");
		System.out.println(list);
		return "success!";
	}
}
