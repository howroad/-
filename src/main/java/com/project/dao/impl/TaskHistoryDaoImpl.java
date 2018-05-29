/**
 * 
 */
package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.ITaskHistoryDao;
import com.project.pojo.TTaskHistory;
import com.project.util.PageBean;

/**
 * @author cyr
 * @Date 2018年5月14日
 * @version 1.0
 */
@Repository("taskHistoryDao")
public class TaskHistoryDaoImpl extends BasicDaoAdapter<TTaskHistory, String> implements ITaskHistoryDao {

	@Override
	public PageBean<TTaskHistory> findAllTaskHistory(int pageNo, int pageSize, String startTime, String endTime,
			String orgName, String areaKey) {
		String sql = "select t_task_history.* from t_task_history where  t_task_history.start_time>=? and  t_task_history.start_time <=? and "
				+ " t_task_history.org_name like ? and  t_task_history.task_area like ?";
		String sql2 = "select count(0) from  t_task_history where  t_task_history.start_time>=? and  t_task_history.start_time <=? and "
				+ " t_task_history.org_name like ? and  t_task_history.task_area like ?";
		String orgName2 = orgName==null||orgName.length()==0?"":orgName;
		String startTime2 = startTime==null||startTime.length()==0?"1900":startTime;
		String endTime2 = endTime==null||endTime.length()==0?"3000":endTime;
		System.out.println(orgName2);
		return this.findAllPage(pageNo, pageSize, sql, sql2, startTime2, endTime2, "%"+orgName2+"%", "%"+areaKey+"%");
	}

	@Override
	public PageBean<TTaskHistory> findOrgTaskHistory(int pageNo, int pageSize, String startTime, String endTime,
			String orgName, String taskName) {
		String sql = "select t_task_history.* from t_task_history where  t_task_history.start_time>=? and  t_task_history.start_time <=? and "
				+ " t_task_history.org_name=? and  t_task_history.task_name like ?";
		String sql2 = "select count(0) from  t_task_history where  t_task_history.start_time>=? and  t_task_history.start_time <=? and "
				+ " t_task_history.org_name=? and  t_task_history.task_name like ?";
		String taskName2 = taskName==null||taskName.length()==0?"":taskName;
		String startTime2 = startTime==null||startTime.length()==0?"1900":startTime;
		String endTime2 = endTime==null||endTime.length()==0?"3000":endTime;
		return this.findAllPage(pageNo, pageSize, sql, sql2, startTime2, endTime2, orgName, "%"+taskName2+"%");
	}

}
