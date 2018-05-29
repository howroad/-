/**
 * 
 */
package com.project.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.dao.IPowerDao;
import com.project.pojo.TPower;

/**
 * @author howroad
 * @Date 2018年5月9日
 * @version 1.0
 */
@Repository("powerDao")
public class PowerDaoImpl extends BasicDaoAdapter<TPower, String> implements IPowerDao{

	@Override
	public List<TPower> findAllPowerInRole(String roleId) {
		String sql = "select distinct t_power.* from t_power left join t_role_power on t_role_power.power_id = t_power.power_id where t_role_power.role_id = ?";
		return listBySQL(sql, roleId);
	}

	@Override
	public List<TPower> findAllPowerNotInRole(String roleId) {
		String sql = "select distinct t_power.* from t_power where power_id not in(select power_id from t_role_power where t_role_power.role_id = ? and power_id is not null) and t_power.power_id not in ('01','02','03','06')";
		return listBySQL(sql, roleId);
	}

	@Override
	public boolean checkPower(String powerName, String userId) {
		String sql ="select count(0) from t_power left join t_role_power on t_power.power_id = t_role_power.power_id " + 
				"left join t_role on t_role.role_id = t_role_power.role_id " + 
				"left join t_user_role on t_user_role.role_id = t_role.role_id " + 
				"where t_user_role.user_id=? and t_power.power_name = ?";
		return countBySQL(sql,userId,powerName)>0;
	}
}
