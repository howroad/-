package com.project.dao.impl;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.project.dao.IUserDao;
import com.project.pojo.TPower;
import com.project.pojo.TUser;
import com.project.util.PageBean;

@Repository("userDao")
public class UserDaoImpl extends BasicDaoAdapter<TUser,String> implements IUserDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<TPower> findPowerByUserId(String userId) {
		String sql = "select distinct t_power.* from t_power left join t_role_power on t_power.power_id = t_role_power.power_id " + 
				"left join t_role on t_role.role_id = t_role_power.role_id " + 
				"left join t_user_role on t_user_role.role_id = t_role.role_id " + 
				"where t_user_role.user_id=? order by t_power.power_id asc";
		NativeQuery<TPower> query = sessionFactory.getCurrentSession().createNativeQuery(sql).setParameter(1, userId).addEntity(TPower.class);
		return query.list();
		
	}

	@Override
	public boolean letGo(List<String> userIds) {
		if(userIds==null) {
			return true;
		}
		for (String string : userIds) {
			TUser user = findById(string);
			user.setUserOutState(1);
			update(user);
		}
		return true;
	}

	@Override
	public boolean letBack(List<TUser> users) {
		if(users==null) {
			return true;
		}
		for (TUser user : users) {
			user.setUserOutState(0);
			update(user);
		}
		return true;
	}

	@Override
	public boolean setPwd(String orgId, String pwd) {
		String sql = "select t_user.* from t_user where t_user.org_id= ?  and t_user.user_manager_state= 1";
		TUser user = findEntityBySQL(sql, orgId);
		user.setUserPassword(pwd);
		return update(user);
	}

	@Override
	public PageBean<TUser> pageBeanAll(int pageNo, int pageSize, String userName, String roleId,String orgId) {
		String sql1 = "select distinct t_user.* from t_user left join t_user_role on t_user.user_id = t_user_role.user_id where t_user.user_rname like ? and t_user_role.role_id like ? and t_user.org_id = ? and t_user.user_states = 0";
		String sql2 = "select count(distinct t_user.user_id) from t_user left join t_user_role on t_user.user_id = t_user_role.user_id where t_user.user_rname like ? and t_user_role.role_id like ? and t_user.org_id = ? and t_user.user_states = 0";
		String userName2 = userName==null||userName.length()==0?"":userName; 
		return findAllPage(pageNo, pageSize, sql1, sql2, "%"+userName2+"%","%"+roleId+"%",orgId);
	}

	@Override
	public boolean deleteUser(String userId) {
		TUser user = findById(userId);
		user.setUserStates(1);
		update(user);
		return true;
	}

	@Override
	public TUser login(String userName, String password) {
		String sql = "select t_user.* from t_user where t_user.user_name = ? and t_user.user_password = ? and t_user.user_states = 0";
		return findEntityBySQL(sql, userName,password);
	}

	@Override
	public PageBean<TUser> findAddressList(int pageNo,int pageSize,String roleId,String userRname,String orgId){
		String sql1 = "select distinct t_user.* from t_user left join t_user_role on t_user.user_id = t_user_role.user_id where t_user_role.role_id like ? and t_user.user_rname like ? and t_user.org_id = ? and t_user.user_states = 0";
		String sql2 = "select count(distinct t_user.user_id) from t_user left join t_user_role on t_user.user_id = t_user_role.user_id where t_user_role.role_id like ? and t_user.user_rname like ? and t_user.org_id = ? and t_user.user_states = 0";
		String userRname2 = userRname==null||userRname.length()==0?"":userRname; 
		return findAllPage(pageNo, pageSize, sql1, sql2, "%"+roleId+"%","%"+userRname2+"%",orgId);
	}

	@Override
	public List<TUser> findAllUserInRole(String roleId, String orgId) {
		String sql = "select distinct t_user.* from t_user left join t_user_role on t_user.user_id = t_user_role.user_id where t_user.org_id = ? and t_user_role.role_id = ? and t_user.user_states = 0";
		return listBySQL(sql, orgId,roleId);
	}

	@Override
	public List<TUser> findAllUserNotInRole(String roleId, String orgId) {
		String sql = "select distinct t_user.* from t_user where org_id = ? and user_id NOT in (select user_id from t_user_role where t_user_role.role_id =? and user_id is not null) and t_user.user_states = 0";
		return listBySQL(sql, orgId,roleId);
	}

	@Override
	public TUser findManagerByOrg(String orgId) {
		String sql = "select t_user.* from t_user where t_user.org_id = ? and t_user.user_manager_state = 1";
		return findEntityBySQL(sql, orgId);
	}

	@Override
	public List<TUser> findUserCanGo(String orgId) {
		String sql = "select t_user.* from t_user where t_user.org_id = ? and t_user.user_out_state = 0 and t_user.user_states = 0";
		return listBySQL(sql, orgId);
	}

	@Override
	public List<TUser> findUserOnTask(String taskId) {
		String sql = "select DISTINCT t_user.* from t_user left join t_task_user on t_user.user_id = t_task_user.user_id where t_task_user.task_id = ? and t_user.user_states = 0";
		return listBySQL(sql, taskId);
	}


}
