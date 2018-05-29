package com.project.dao;

import java.util.List;

import com.project.pojo.TPower;
import com.project.pojo.TUser;
import com.project.util.PageBean;

public interface IUserDao extends IBasicDao<TUser,String>{
	/**
	 * 根据用户Id查询用户的所有权限
	 * @param userId
	 * @return 用户的所有权限
	 */
	public List<TPower> findPowerByUserId(String userId);
	/**
	 * 批量设置员工状态为外出状态
	 * @param userIds
	 * @return 成功或失败
	 */
	public boolean letGo(List<String> userIds);
	/**
	 * 设置员工外出状态为没有外出
	 * @param userIds
	 * @return 成功或失败
	 */
	public boolean letBack(List<TUser> userIds);
	/**
	 * 修改管理员密码
	 * @param orgId
	 * @param pwd
	 * @return
	 */
	public boolean setPwd(String orgId,String pwd);

	/**
	 * 获得分页后的User信息
	 * @param pageNo
	 * @param pageSize
	 * @param userName
	 * @param roleId
	 * @param orgId
	 * @return pageBean
	 */
	public PageBean<TUser> pageBeanAll(int pageNo,int pageSize,String userName,String roleId,String orgId);

	/**
	 * 删除员工(改变员工的状态)
	 * @param userId 员工Id
	 * @return 成功或失败
	 */
	public boolean deleteUser(String userId);
	/**
	 * 登陆
	 * @param userName 用户名
	 * @param password 密码
	 * @return 失败返回NULL
	 */
	public TUser login(String userName,String password);
	/**
	 * 显示通讯录
	 * @param roleId 角色Id
	 * @param userRname 真实姓名
	 * @param orgId 部门Id
	 * @return 分页信息
	 */
	public PageBean<TUser> findAddressList(int pageNo,int pageSize,String roleId,String userRname,String orgId);
	
	/**
	 * 显示该机构中该角色管理的所有用户
	 * @param roleId
	 * @param orgId
	 * @return list
	 */
	public List<TUser> findAllUserInRole(String roleId,String orgId);
	/**
	 * 显示该机构中不属于该角色的用户
	 * @param roleId
	 * @param orgId
	 * @return
	 */
	public List<TUser> findAllUserNotInRole(String roleId,String orgId);
	/**
	 * 查询机构的管理员
	 * @param orgId
	 * @return user
	 */
	public TUser findManagerByOrg(String orgId);
	/**
	 * 查询可以派出的 人员
	 * @return list
	 */
	public List<TUser> findUserCanGo(String orgId);
	/**
	 * 查询该任务中的员工
	 * @param taskId
	 * @return 员工
	 */
	public List<TUser> findUserOnTask(String taskId);
}
