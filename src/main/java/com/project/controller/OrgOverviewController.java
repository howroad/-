package com.project.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.service.IOrganizationService;
import com.project.service.IUserService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
import com.project.vo.OrganizationVO;
@MyOperation("机构总览")
@Controller("orgOverviewController")
public class OrgOverviewController {
	@Autowired
	private IOrganizationService orgService;
	@Autowired
	private IUserService userService;
	/**
	 * 返回所有机构
	 * @param pageNo
	 * @param orgType
	 * @param orgArea
	 * @return pageBean
	 */
	@RequestMapping("findOrg")
	@ResponseBody
	public PageBean<OrganizationVO> findOrg(String pageNo,String orgType,String orgArea){
		int pageNoValue = pageNo==null||pageNo.length()==0?1:Integer.parseInt(pageNo);
		return orgService.pageBean(pageNoValue, 5, orgType, orgArea);
	}
	@RequestMapping("addOrg")
	@ResponseBody
	public boolean addOrg(OrganizationVO org) {
		return orgService.addOrg(org);
	}
	
	@RequestMapping("findManagerByOrgId")
	@ResponseBody
	public String findManagerByOrgId(String orgId) {
		return userService.findManagerByOrg(orgId).getUserName();
	}
	
	@RequestMapping("updateOrgUserPwd")
	@ResponseBody
	public boolean updateOrgUserPwd(String orgId,String pwd) {
		return orgService.updateUserPwd(orgId, pwd);
	}
	
	@RequestMapping("downloadExcel")
	@ResponseBody
	public void downloadExcel(HttpServletResponse response) throws IOException {
		Workbook wb =orgService.createExcel();
		response.setHeader("Content-Disposition","attachment;filename="+LocalDate.now()+".xls");
		response.setContentType("application/ynd.ms-excel;charset=UTF-8");
		wb.write(response.getOutputStream());
	}
}
