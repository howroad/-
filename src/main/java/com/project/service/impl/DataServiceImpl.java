/**
 * 
 */
package com.project.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IDataDao;
import com.project.pojo.TData;
import com.project.service.IDataService;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
@Service("dataService")
public class DataServiceImpl implements IDataService {
	@Autowired
	private IDataDao dataDao;
	
	@Override
	public List<TData> findData(String type) {
		return dataDao.findData(type);
	}

	@Override
	public boolean add(TData data) {
		return dataDao.add(data)!=null;
	}

	@Override
	public List<String> getAllType() {
		return dataDao.getAllType();
	}

	@Override
	public HashMap<String, Integer> getData1(String year) {
		return dataDao.getData1(year);
	}

}
