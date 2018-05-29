package com.project.dao;

import java.util.List;

import com.project.pojo.TCar;
import com.project.util.PageBean;

public interface ICarDao extends IBasicDao<TCar, String>{
	/**
	 * 派遣车辆
	 * @param CarId 车辆Id
	 * @return 成功或失败
	 */
	public boolean letGo(List<String> CarId);
	/**
	 * 车辆归队
	 * @param CarId 车辆Id
	 * @return 成功或失败
	 */
	public boolean letBack(List<TCar> cars);
	/**
	 * 设置车辆状态为报修状态
	 * @param carId 车辆ID
	 * @return 成功或失败
	 */
	public boolean setCar(String carId);
	/**
	 * 删除车辆(设置车辆为删除状态)
	 * @param carId 车辆Id
	 * @return 成功或失败
	 */
	public boolean deleteCar(String carId);
	
	/**
	 * 查询可以派出的车辆
	 * @return list
	 */
	public List<TCar> findCarCanGo(String orgId);

	/**
	 * 查询任务中的车辆
	 * @param taskId
	 * @return list
	 */
	public List<TCar> findCarOnTask(String taskId);

	
	/**
	 * 分页和模糊查询
	 * @param pageNo 当前页数
	 * @param pageSize 当前页显示几条数据
	 * @param carType 车辆类型
	 * @return  PageBean
	 */
	public PageBean<TCar> listPage(int pageNo, int pageSize, String carType,String orgId);
	
	/**
	 * 添加车辆
	 * @param car 实体
	 * @return 添加成功或 失败 
	 */
	public boolean  addCar(TCar car);
	
	/**
	 * 报废
	 * @param carId 车辆Id 
	 * @return 修改成功或失败
	 */
	public boolean repairCar(String  carId);


}
