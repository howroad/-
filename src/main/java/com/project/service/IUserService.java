package com.project.service;

import java.util.List;

import com.project.pojo.TCar;
import com.project.pojo.TPower;
import com.project.pojo.TUser;
import com.project.util.PageBean;
import com.project.vo.UserVO;

public interface IUserService {
	/**
	 * 根据用户Id查询到所有的权限
	 * @param userId
	 * @return Set
	 */
	public List<TPower> findPowerByUserId(String userId);

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
	 * 查询用户的所有信息
	 * @param userId
	 * @return 用户Bean
	 */
	public TUser showUser(String userId);
	/**
	 * 添加员工
	 * @param user 员工
	 * @return 成功或失败
	 */
	public boolean addUser(TUser user,String roleId);
	/**
	 * 修改员工信息
	 * @param user 员工
	 * @return 成功或失败
	 */
	public boolean updateUser(TUser user);
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
	 * @param userRname 真实名
	 * @param orgId 部门Id
	 * @return 分页信息
	 */
	public PageBean<UserVO> findAddressList(int pageNo,int pageSize,String roleId,String userRname,String orgId);
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
	 * 查询可以派出的车辆
	 * @return list
	 */
	public List<TCar> findCarCanGo(String orgId);
	/**
	 * 转化一下格式
	 * @param user0
	 * @return
	 */
	public PageBean<UserVO> change(PageBean<TUser> pg0);
}
