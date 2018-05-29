/**
 * 
 */
package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IMessageDao;
import com.project.pojo.TMessage;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
@Repository("messageDao")
public class MessageDaoImpl extends BasicDaoAdapter<TMessage, String> implements IMessageDao {

	@Override
	public String getStartTime(String taskId) {
		TMessage message = findEntityBySQL("select t_message.* from t_message where t_message.task_id = ? and t_message.msg_type = 1", taskId);
		return message==null?null:message.getMsgTime();
	}

}
