/**
 * 
 */
package com.project.dao;

import java.util.List;

import com.project.pojo.TTaskCar;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
public interface ITaskCarDao extends IBasicDao<TTaskCar, String>{
	/**
	 * 批量添加任务车辆对应关系
	 * @param taskId
	 * @param cars
	 * @return 成功 失败
	 */
	public boolean addCars(String taskId,List<String> cars);

}
