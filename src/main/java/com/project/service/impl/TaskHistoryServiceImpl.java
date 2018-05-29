/**
 * 
 */
package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ITaskHistoryDao;
import com.project.pojo.TTaskHistory;
import com.project.service.ITaskHistoryService;
import com.project.util.PageBean;

/**
 * @author cyr
 * @Date 2018年5月14日
 * @version 1.0
 */
@Service("taskHistoryService")
public class TaskHistoryServiceImpl implements ITaskHistoryService {
	@Autowired
	private ITaskHistoryDao taskHistoryDao;

	@Override
	public PageBean<TTaskHistory> findAllTaskHistory(int pageNo, int pageSize, String startTime, String endTime,
			String orgName, String areaKey) {

		return taskHistoryDao.findAllTaskHistory(pageNo, pageSize, startTime, endTime, orgName, areaKey);
	}

	@Override
	public TTaskHistory showTaskHistory(String thId) {
		return taskHistoryDao.findById(thId);
	}

	@Override
	public PageBean<TTaskHistory> findOrgTaskHistory(int pageNo, int pageSize, String startTime, String endTime,
			String orgName, String taskName) {
		return taskHistoryDao.findOrgTaskHistory(pageNo, pageSize, startTime, endTime, orgName, taskName);
	}

	

}
