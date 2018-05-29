/**
 * 
 */
package com.project.dao;

import com.project.pojo.TTask;
import com.project.util.PageBean;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
public interface ITaskDao extends IBasicDao<TTask, String>{
	/**
	 * 查询所有未完成的任务
	 * @return pageBean
	 */
	public PageBean<TTask> findTask(int pageNo,int pageSize,String orgId,String taskLevel,String taskState);
}
