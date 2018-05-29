/**
 * 
 */
package com.project.dao;

import java.util.List;

import com.project.pojo.TRole;

/**
 * @author howroad
 * @Date 2018年5月9日
 * @version 1.0
 */
public interface IRoleDao extends IBasicDao<TRole, String>{
	/**
	 * 批量添加角色用户
	 * @param users
	 * @param roleId
	 * @return 成功或失败
	 */
	public boolean addUserRole(List<String> users,String roleId);
	/**
	 * 批量删除角色用户
	 * @param users
	 * @param roleId
	 * @return 成功或失败
	 */
	public boolean delUserRole(List<String> users,String roleId);
	/**
	 * 批量添加角色权限
	 * @param users
	 * @param roleId
	 * @return 成功或失败
	 */
	public boolean addPowers(List<String> powers,String roleId);
	/**
	 * 批量删除角色权限
	 * @param users
	 * @param roleId
	 * @return 成功或失败
	 */
	public boolean delPowers(List<String> powers,String roleId);
	/**
	 * 查询该用户所有的角色
	 * @param userId
	 * @return
	 */
	public List<TRole> findRole(String userId);
	/**
	 * 查询所有的权限
	 * @return 
	 */
	public List<TRole> findAllListNoManager();
}
