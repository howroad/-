package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TUser;
import com.project.service.IUserService;
import com.project.util.MyOperation;
@MyOperation("我的信息")
@Controller("userInfoController")
public class UserInfoController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("findUserById")
	@ResponseBody
	public TUser findUserById(HttpServletRequest request){
		return (TUser) request.getSession().getAttribute("session_user");
	}
	
	@RequestMapping("updateUser")
	@ResponseBody
	public boolean updateUser(String userPassword,String userTel,String userEmail,HttpServletRequest request) {
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		user.setUserPassword(userPassword);
		user.setUserTel(userTel);
		user.setUserEmail(userEmail);
		return userService.updateUser(user);
	}
}
