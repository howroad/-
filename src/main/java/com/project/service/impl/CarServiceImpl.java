package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ICarDao;
import com.project.pojo.TCar;
import com.project.pojo.TOrganization;
import com.project.service.ICarService;
import com.project.util.PageBean;


@Service("carService")
public class CarServiceImpl implements ICarService{
	@Autowired
	private ICarDao carDao;


	@Override
	public String addCar(TCar car,TOrganization org) {
		car.setCarOutState(0);
		car.setCarDeleteState(0);
		car.setTOrganization(org);
		return carDao.add(car);
	}

	@Override
	public boolean setCarBreak(String carId) {
		return carDao.setCar(carId);
	}

	@Override
	public boolean deleteCar(String carId) {
		return carDao.deleteCar(carId);
	}

	@Override
	public PageBean<TCar> showCar(int pageNo, int pageSize, String carType,String orgId) {
		return carDao.listPage(pageNo, pageSize, carType,orgId);
	}

	@Override
	public boolean repairCar(String carId) {
		return carDao.repairCar(carId);
	}

}
