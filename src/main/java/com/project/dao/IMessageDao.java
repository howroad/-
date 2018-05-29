/**
 * 
 */
package com.project.dao;

import com.project.pojo.TMessage;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
public interface IMessageDao extends IBasicDao<TMessage, String>{
	/**
	 * 获得任务出动时间
	 * @param taskId
	 * @return 时间
	 */
	public String getStartTime(String taskId);
}
