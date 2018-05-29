package com.project.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.dao.ICarDao;
import com.project.pojo.TCar;
import com.project.util.PageBean;

@Repository("carDao")
public class CarDaoImpl extends BasicDaoAdapter<TCar, String> implements ICarDao {

	
	@Override
	public boolean setCar(String carId) {
		TCar car = findById(carId);
		car.setCarBreakState(1);
		return update(car);
	}

	@Override
	public boolean deleteCar(String carId) {
		TCar car = findById(carId);
		car.setCarDeleteState(1);
		return update(car);
	}

	@Override
	public boolean letGo(List<String> CarId) {
		if(CarId==null) {
			return true;
		}
		for (String string : CarId) {
			if("null".equals(string)) {
				break;
			}
			TCar car = findById(string);
			car.setCarOutState(1);
			update(car);
		}
		return true;
	}

	@Override
	public boolean letBack(List<TCar> cars) {
		if(cars==null) {
			return true;
		}
		for (TCar car : cars) {
			car.setCarOutState(0);
			update(car);
		}
		return true;
	}
	
	@Override
	public boolean addCar(TCar car) {
		car.setCarDeleteState(0);
		car.setCarOutState(0);
		add(car);
		return false;
	}
	
	
	@Override
	public boolean repairCar(String carId) {
		TCar car = findById(carId);
		car.setCarBreakState(0);
		return update(car);
	}

	@Override
	public List<TCar> findCarCanGo(String orgId) {
		String sql = "select t_car.* from t_car where t_car.org_id = ? and t_car.car_out_state = 0 and t_car.car_delete_state = 0";
		return listBySQL(sql, orgId);
	}


	@Override
	public List<TCar> findCarOnTask(String taskId) {
		String sql = "select DISTINCT t_car.* from t_car left join t_task_car on t_car.car_id = t_task_car.car_id where t_task_car.task_id = ?";
		return listBySQL(sql, taskId);
	}


	@Override
	public PageBean<TCar> listPage(int pageNo, int pageSize, String carType,String orgId) {
		String sql = "select data_value as car_type,t_car.* from t_car left join t_data on t_car.car_type = t_data.data_key where car_delete_state = 0 and car_type like ? and data_type = 'CLLX' and t_car.org_id = ?";
		String sql1 = "select count(*) from t_car left join t_data on t_car.car_type = t_data.data_key where car_delete_state = 0 and car_type like ? and data_type = 'CLLX' and t_car.org_id = ?";
		return findAllPage(pageNo,pageSize,sql,sql1,"%"+carType+"%",orgId);
	}
}
