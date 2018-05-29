/**
 * 
 */
package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.ITaskDao;
import com.project.pojo.TTask;
import com.project.util.PageBean;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
@Repository("taskDao")
public class TaskDaoImpl extends BasicDaoAdapter<TTask, String>implements ITaskDao {

	@Override
	public PageBean<TTask> findTask(int pageNo, int pageSize,String orgId,String taskLevel,String taskState) {
		String sql1 = "select dt1.data_value task_level,dt2.data_value task_type,t_task.* from t_task left join t_data dt1 on dt1.data_key = t_task.task_level and dt1.data_type = 'RWDJ' left join t_data dt2 on dt2.data_key = t_task.task_type and dt2.data_type = 'RWLX'" + 
				" where t_task.org_id = ? and t_task.task_level like ? and t_task.task_state = ?";
		String sql2 = "select count(0) from t_task where t_task.org_id = ? and t_task.task_level like ? and t_task.task_state = ?";
		return findAllPage(pageNo, pageSize, sql1, sql2,orgId,taskLevel+"%",taskState);
	}

}
