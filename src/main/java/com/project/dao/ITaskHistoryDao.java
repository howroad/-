/**
 * 
 */
package com.project.dao;

import com.project.pojo.TTaskHistory;
import com.project.util.PageBean;

/**
 * @author cyr
 * @Date 2018年5月14日
 * @version 1.0
 */
public interface ITaskHistoryDao extends IBasicDao<TTaskHistory, String>{
	/**
	 * 根据条件查询所有历史事件
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param orgName 机构名称
	 * @param areaKey 区域
	 * @return 查询到的所有历史事件
	 */
	public PageBean<TTaskHistory> findAllTaskHistory(int pageNo, int pageSize, String startTime, String endTime,
			String orgName, String areaKey);
	
	/**
	 * 根据条件查询某机构的所有历史任务
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param orgName 机构名称
	 * @param taskName 任务名称
	 * @return 查询到的所有历史事件
	 */
	public PageBean<TTaskHistory> findOrgTaskHistory(int pageNo,int pageSize,String startTime,String endTime,String orgName,String taskName);
}
