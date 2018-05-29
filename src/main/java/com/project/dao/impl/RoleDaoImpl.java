/**
 * 
 */
package com.project.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.project.dao.IRoleDao;
import com.project.pojo.TRole;

/**
 * @author howroad
 * @Date 2018年5月9日
 * @version 1.0
 */
@Repository("roleDao")
public class RoleDaoImpl extends BasicDaoAdapter<TRole, String> implements IRoleDao{

	@Override
	public boolean addUserRole(List<String> users, String roleId) {
		Session session = sessionFactory.getCurrentSession();
		for (String string : users) {
			if("null".equals(string)) {
				break;
			}
			String sql = "insert into t_user_role(ur_id,role_id,user_id) values(?,?,?)";
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			session.createNativeQuery(sql).setParameter(1, uuid)
			.setParameter(2, roleId).setParameter(3, string).executeUpdate();
		}
		return true;
	}

	@Override
	public boolean delUserRole(List<String> users, String roleId) {
		if(users==null||users.size()==0||users.get(0).equals("null")) {
			return true;
		}
		Session session = sessionFactory.getCurrentSession();
		for (String string : users) {
			String sql = "delete from t_user_role where t_user_role.user_id = ? and t_user_role.role_id = ?";
			session.createNativeQuery(sql).setParameter(1, string).setParameter(2, roleId).executeUpdate();
		}
		return true;
	}

	@Override
	public boolean addPowers(List<String> powers, String roleId) {
		Session session = sessionFactory.getCurrentSession();
		for (String string : powers) {
			if("null".equals(string)) {
				break;
			}
			String sql = "insert into t_role_power(rp_id,power_id,role_id) values(?,?,?)";
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			session.createNativeQuery(sql).setParameter(1, uuid)
			.setParameter(2, string).setParameter(3, roleId).executeUpdate();
		}
		return true;
	}

	@Override
	public boolean delPowers(List<String> powers, String roleId) {
		if(powers==null||powers.size()==0||powers.get(0).equals("null")) {
			return true;
		}
		Session session = sessionFactory.getCurrentSession();
		for (String string : powers) {
			String sql = "delete from t_role_power where t_role_power.power_id = ? and t_role_power.role_id = ?";
			session.createNativeQuery(sql).setParameter(1, string).setParameter(2, roleId).executeUpdate();
		}
		return true;
	}

	@Override
	public List<TRole> findRole(String userId) {
		String sql = "select distinct t_role.* from t_role left join t_user_role on t_role.role_id = t_user_role.role_id where t_user_role.user_id = ?";
		return listBySQL(sql, userId);
	}

	@Override
	public List<TRole> findAllListNoManager() {
		String sql = "select t_role.* from t_role where t_role.role_id not in('CJGLY','BMGLY')";
		return listBySQL(sql);
	}

}
