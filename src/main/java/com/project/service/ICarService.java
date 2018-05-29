package com.project.service;

import com.project.pojo.TCar;
import com.project.pojo.TOrganization;
import com.project.util.PageBean;

public interface ICarService {
	/**
	 * 添加车辆
	 * @param car 车辆信息
	 * @return 成功或失败
	 */
	public String addCar(TCar car,TOrganization org);
	/**
	 * 设置车辆状态为报修状态
	 * @param carId 车辆ID
	 * @return 成功或失败
	 */
	public boolean setCarBreak(String carId);
	/**
	 * 删除车辆(设置车辆为删除状态)
	 * @param carId 车辆Id
	 * @return 成功或失败
	 */
	public boolean deleteCar(String carId);
	
	
	/**
	 * 报废
	 * @param carId 车辆Id 
	 * @return 修改成功或失败
	 */
	public boolean repairCar(String  carId);
	
	/**
	 * 分页和模糊查询
	 * @param pageNo 当前页数
	 * @param pageSize 当前页显示几条数据
	 * @param carType 车辆类型
	 * @return  PageBean
	 */
	public PageBean<TCar> showCar(int pageNo,int pageSize,String carType,String orgId);
}
