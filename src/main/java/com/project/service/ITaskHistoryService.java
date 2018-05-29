package com.project.service;

import com.project.pojo.TTaskHistory;
import com.project.util.PageBean;

public interface ITaskHistoryService {
	/**
	 * 查询历史任务
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param orgName 机构名称
	 * @param areaKey 区域名称
	 * @return pageBean
	 */
	public PageBean<TTaskHistory>  findAllTaskHistory(int pageNo,int pageSize,String startTime,String endTime,String orgName,String areaKey);
	/**
	 * 显示历史事件详情
	 * @param thId 事件Id
	 * @return 历史事件详情
	 */
	public TTaskHistory showTaskHistory(String thId);
	/**
	 * 查询部门历史任务
	 * @param pageNo
	 * @param pageSize
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param orgName 机构名称
	 * @param taskName 任务名称
	 * @return 分页信息
	 */
	public PageBean<TTaskHistory> findOrgTaskHistory(int pageNo,int pageSize,String startTime,String endTime,String orgName,String taskName);
	
}
