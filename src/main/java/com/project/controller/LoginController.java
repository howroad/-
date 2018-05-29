package com.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.pojo.TUser;
import com.project.service.IUserService;
@Controller("loginController")
public class LoginController {
	@Autowired
	private IUserService userService;
	@RequestMapping("login")
	public void login(String username,String password,HttpServletRequest request,HttpServletResponse response) throws IOException {
		TUser user = userService.login(username, password);
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("session_user", user);
			session.setAttribute("session_power", userService.findPowerByUserId(user.getUserId()));
			session.setAttribute("session_orgName", user.getUserSuperState()==1?"超级管理员":user.getTOrganization().getOrgName());
			response.sendRedirect(request.getContextPath()+"/index");
		}else {
			response.sendRedirect(request.getContextPath()+"/html/login.html");
		}
	}
	@RequestMapping("/index")
	public ModelAndView login() throws IOException {
		return new ModelAndView("index.jsp");
	}
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
		
	}
}
