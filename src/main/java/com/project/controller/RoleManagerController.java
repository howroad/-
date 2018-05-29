package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.listener.DataInitListner;
import com.project.pojo.TPower;
import com.project.pojo.TRole;
import com.project.pojo.TUser;
import com.project.service.IDataService;
import com.project.service.IRoleService;
import com.project.service.IUserService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
@MyOperation("角色管理")
@Controller("roleManagerController")
public class RoleManagerController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IDataService dataService;
	/**
	 * 查询所有角色
	 * @param pageNo 查询的页码数
	 * @return
	 */
	//这里写该方法对应的权限名字(powerName,可以先不写)
	
	@RequestMapping("roleManager")
	@ResponseBody
	public PageBean<TUser> userList(String pageNo,String roleId,HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		int pageNoValue = pageNo==null||pageNo.equals("")?1:Integer.parseInt(pageNo);
		return userService.pageBeanAll(pageNoValue, 5, "", roleId,orgId);
	}
	@RequestMapping("addRole")
	@ResponseBody
	public boolean addRole(@RequestParam(value = "powerIds", required = false) List<String> powerIds,
			TRole role,HttpServletRequest request) {
		String roleId = roleService.addRole(role);
		roleService.addRolePower(powerIds, roleId);
		DataInitListner.setData(request.getServletContext(), dataService, roleService);
		return true;
	}
	@RequestMapping("findAllUserInRole")
	@ResponseBody
	public List<TUser> findAllUserInRole(String roleId,HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		return userService.findAllUserInRole(roleId, orgId);
	}
	
	@RequestMapping("findAllUserNotInRole")
	@ResponseBody
	public List<TUser> findAllUserNotInRole(String roleId,HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		return userService.findAllUserNotInRole(roleId, orgId);
	}
	
	@RequestMapping("updateRoleUser")
	@ResponseBody
	public boolean updateRoleUser(@RequestParam(value = "addUsers", required = false) List<String> addUsers,
			@RequestParam(value = "delUsers", required = false) List<String> delUsers,String roleId){
		roleService.addUserRole(addUsers, roleId);
		roleService.delUserRole(delUsers, roleId);
		return true;
	}
	
	@RequestMapping("findAllPowerInRole")
	@ResponseBody
	public List<TPower> findAllPowerInRole(String roleId){
		return roleService.findAllPowerInRole(roleId);
	}
	
	@RequestMapping("findAllPowerNotInRole")
	@ResponseBody
	public List<TPower> findAllPowerNotInRole(String roleId){
		return roleService.findAllPowerNotInRole(roleId);
	}
	
	
	@RequestMapping("updateRolePower")
	@ResponseBody
	public boolean updateRolePower(@RequestParam(value = "addPowers", required = false) List<String> addPowers,
			@RequestParam(value = "delPowers", required = false) List<String> delPowers,String roleId){
		roleService.addRolePower(addPowers, roleId);
		roleService.delPowers(delPowers, roleId);
		return true;
	}
}
