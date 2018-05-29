/**
 * 
 */
package com.project.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.dao.ITaskUserDao;
import com.project.pojo.TTask;
import com.project.pojo.TTaskUser;
import com.project.pojo.TUser;

/**
 * @author howroad
 * @Date 2018年5月14日
 * @version 1.0
 */
@Repository("taskUserDao")
public class TaskUserDaoImpl extends BasicDaoAdapter<TTaskUser, String> implements ITaskUserDao{

	@Override
	public boolean addUsers(String taskId, List<String> userIds) {
		if(userIds==null) {
			return true;
		}
		for (String string : userIds) {
			if("null".equals(string)) {
				break;
			}
			add(new TTaskUser(new TTask(taskId) , new TUser(string)));
		}
		return true;
	}

}
