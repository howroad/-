package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TUser;
import com.project.service.IUserService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
import com.project.vo.UserVO;
@MyOperation("通讯录")
@Controller("addressListController")
public class AddressListController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("findAddressList")
	@ResponseBody
	public PageBean<UserVO> findAddressList(String pageNo,String roleId,String userRname,HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		int pageNoValue = pageNo==null||pageNo.length()==0?1:Integer.parseInt(pageNo);
		return userService.findAddressList(pageNoValue, 5, roleId, userRname, orgId);
	}
}
