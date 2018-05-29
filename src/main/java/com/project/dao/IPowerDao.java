/**
 * 
 */
package com.project.dao;

import java.util.List;

import com.project.pojo.TPower;

/**
 * @author howroad
 * @Date 2018年5月9日
 * @version 1.0
 */
public interface IPowerDao extends IBasicDao<TPower, String>{
	/**
	 * 查询该角色下所有的权限
	 * @param roleId
	 * @return
	 */
	public List<TPower> findAllPowerInRole(String roleId);
	/**
	 * 查询不在该角色下的所有的权限
	 * @param roleId
	 * @return
	 */
	public List<TPower> findAllPowerNotInRole(String roleId);
	/**
	 * 查询该用户是否有此权限
	 * @param powerName
	 * @return boolean
	 */
	public boolean checkPower(String powerName,String userId);
}
