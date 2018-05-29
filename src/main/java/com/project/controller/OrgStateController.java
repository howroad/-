/**
 * 
 */
package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.service.IOrganizationService;
import com.project.vo.OrgStateDto;

/**
 * @author howroad
 * @Date 2018年5月18日
 * @version 1.0
 */
@RestController("orgStateController")
public class OrgStateController {
	@Autowired
	private IOrganizationService organizationService;
	@RequestMapping(value="OrgStock/{orgCode}",method=RequestMethod.GET)
	public OrgStateDto getOrgState(@PathVariable("orgCode")String orgCode){
		return organizationService.orgStateByCode(orgCode);
	}
	@RequestMapping(value ="findResByCodes")
	public void getOrgState2(@RequestParam(value = "list",required = false) List<String> list,HttpServletResponse response) throws Exception{
		System.out.println(list);
		if(list==null||list.size()==0||list.get(0).equals("null")) {
			return;
		}
		List<OrgStateDto> list2 = organizationService.orgStateByCodeList(list);
		String str = new ObjectMapper().writeValueAsString(list2);
		response.getWriter().print("successCallback("+str+")");
	}
}
