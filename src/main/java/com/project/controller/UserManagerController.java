package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TOrganization;
import com.project.pojo.TUser;
import com.project.service.IUserService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
import com.project.vo.UserVO;

@MyOperation("人员管理")
@Controller("userManagerController")
public class UserManagerController {
	@Autowired
	private IUserService userService;
	@RequestMapping("userList")
	@ResponseBody
	public PageBean<UserVO> findAllUser(String pageNo,String roleId,String userRName,HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		int pageNoValue = pageNo==null||pageNo.length()==0?1:Integer.parseInt(pageNo);
		return userService.change(userService.pageBeanAll(pageNoValue, 5, userRName, roleId, user.getTOrganization().getOrgId()));
	}
	
	@RequestMapping("showUser")
	@ResponseBody
	public TUser showUser(String userId){
		return userService.showUser(userId);
	}
	
	@RequestMapping("addUser")
	@ResponseBody
	public boolean addUser(TUser user,String roleId,HttpServletRequest request){
		System.out.println(roleId);
		TUser user2 = (TUser)request.getSession().getAttribute("session_user");
		TOrganization org = user2.getTOrganization();
		user.setTOrganization(org);
		userService.addUser(user,roleId);
		return true;
	}
	
	@RequestMapping("updateUserByManager")
	@ResponseBody
	public boolean updateUserByManager(TUser user){
		userService.updateUser(user);
		return true;
	}
	
	@RequestMapping("deleteUser")
	@ResponseBody
	public boolean deleteUser(String userId){
		userService.deleteUser(userId);
		return true;
	}
}
