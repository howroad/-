/**
 * 
 */
package com.project.dao;

import java.util.List;

import com.project.pojo.TTaskUser;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
public interface ITaskUserDao extends IBasicDao<TTaskUser, String>{
	/**
	 * 批量添加任务员工对应关系
	 * @param taskId
	 * @param cars
	 * @return 成功 失败
	 */
	public boolean addUsers(String taskId,List<String> userIds);
}
