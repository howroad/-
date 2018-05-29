package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TCar;
import com.project.pojo.TUser;
import com.project.service.ICarService;
import com.project.util.MyOperation;
import com.project.util.PageBean;
@MyOperation("车辆管理")
@Controller("carManagerController")
public class CarManagerController {

	@Autowired
	private ICarService carService;
	@RequestMapping("listpage")
	@ResponseBody
	public PageBean<TCar> listPage(String pageNo,String carType,HttpServletRequest request) {
		int pageNoValue = pageNo==null||pageNo.length()==0?1:Integer.parseInt(pageNo);
		TUser user = (TUser)request.getSession().getAttribute("session_user");
		String orgId = user.getTOrganization().getOrgId();
		return carService.showCar(pageNoValue, 5, carType,orgId);
	}
	
	@RequestMapping("addcar")
	@ResponseBody
	public boolean addCar(TCar car,HttpServletRequest request) {
		TUser user = (TUser)request.getSession().getAttribute("session_user");
		return carService.addCar(car,user.getTOrganization())!=null;
	}
	
	@RequestMapping("deletecar")
	@ResponseBody
	public boolean deleteCar(String id) {
		return carService.deleteCar(id);
	}
	
	@RequestMapping("carbreak")
	@ResponseBody
	public boolean setCarBreak(String id) {
		return carService.setCarBreak(id);
	}
	

	@RequestMapping("repaircar")
	@ResponseBody
	public boolean repairCar(String id){
		return carService.repairCar(id);
		
	}
}
