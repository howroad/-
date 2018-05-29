/**
 * 
 */
package com.project.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.dao.ITaskCarDao;
import com.project.pojo.TCar;
import com.project.pojo.TTask;
import com.project.pojo.TTaskCar;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
@Repository("taskCarDao")
public class TaskCarDaoImpl extends BasicDaoAdapter<TTaskCar, String> implements ITaskCarDao{

	@Override
	public boolean addCars(String taskId, List<String> cars) {
		if(cars==null) {
			return true;
		}
		for (String string : cars) {
			if("null".equals(string)) {
				break;
			}
			add(new TTaskCar(new TTask(taskId) , new TCar(string)));
		}
		return true;
	}

}
