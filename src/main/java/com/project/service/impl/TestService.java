package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IPowerDao;
import com.project.pojo.TPower;

@Service("testService")
public class TestService {
	@Autowired
	private IPowerDao powerDao;
	public void addPower(TPower...powers) {
		powerDao.addMany(powers);
	}
	public String addPower(TPower power) {
		return powerDao.add(power);
	}
}
