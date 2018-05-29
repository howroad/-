/**
 * 
 */
package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IPowerDao;
import com.project.dao.IRoleDao;
import com.project.dao.IRolePowerDao;
import com.project.pojo.TPower;
import com.project.pojo.TRole;
import com.project.pojo.TRolePower;
import com.project.service.IRoleService;

/**
 * @author howroad
 * @Date 2018年5月9日
 * @version 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IPowerDao powerDao;
	@Autowired
	private IRolePowerDao rolePowerDao;
	
	@Override
	public List<TRole> findAllRole() {
		return roleDao.findAllListNoManager();
	}

	@Override
	public List<TPower> findAllPower() {
		return powerDao.findAllList();
	}

	@Override
	public String addRole(TRole role) {
		return roleDao.add(role);
	}

	@Override
	public boolean addRolePower(List<String> powers, String roleId) {
		TRole role = roleDao.findById(roleId);
		for (String string : powers) {
			TPower power = powerDao.findById(string);
			rolePowerDao.add(new TRolePower(power, role));
		}
		return true;
	}

	@Override
	public boolean addUserRole(List<String> users, String roleId) {
		return roleDao.addUserRole(users, roleId);
	}

	@Override
	public boolean delUserRole(List<String> users, String roleId) {
		return roleDao.delUserRole(users, roleId);
	}

	@Override
	public List<TPower> findAllPowerInRole(String roleId) {
		return powerDao.findAllPowerInRole(roleId);
	}

	@Override
	public List<TPower> findAllPowerNotInRole(String roleId) {
		return powerDao.findAllPowerNotInRole(roleId);
	}

	@Override
	public boolean addPowers(List<String> powers, String roleId) {
		return roleDao.addPowers(powers, roleId);
	}

	@Override
	public boolean delPowers(List<String> powers, String roleId) {
		return roleDao.delPowers(powers, roleId);
	}

	@Override
	public boolean checkPower(String powerName, String userId) {
		return powerDao.checkPower(powerName, userId);
	}

}
