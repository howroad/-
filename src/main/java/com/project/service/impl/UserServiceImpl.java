package com.project.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ICarDao;
import com.project.dao.IRoleDao;
import com.project.dao.IUserDao;
import com.project.dao.IUserRoleDao;
import com.project.pojo.TCar;
import com.project.pojo.TPower;
import com.project.pojo.TRole;
import com.project.pojo.TUser;
import com.project.pojo.TUserRole;
import com.project.service.IUserService;
import com.project.util.PageBean;
import com.project.vo.UserVO;
@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private ICarDao carDao;
	@Autowired
	private IUserRoleDao userRoleDao;

	@Override
	public List<TPower> findPowerByUserId(String userId) {
		return userDao.findPowerByUserId(userId);
	}

	@Override
	public PageBean<TUser> pageBeanAll(int pageNo, int pageSize, String userName, String roleId,String orgId) {
		return userDao.pageBeanAll(pageNo, pageSize, userName, roleId,orgId);
	}

	@Override
	public TUser showUser(String userId) {
		return userDao.findById(userId);
	}

	@Override
	public boolean addUser(TUser user,String roleId) {
		user.setUserRegistTime(LocalDateTime.now().toString());
		user.setUserStates(0);
		user.setUserOutState(0);
		user.setUserManagerState(0);
		user.setUserSuperState(0);
		userDao.add(user);
		TRole role = roleDao.findById(roleId);
		userRoleDao.add(new TUserRole(role,user));
		return true;
	}

	@Override
	public boolean updateUser(TUser user) {
		TUser user2 = userDao.findById(user.getUserId());
		user2.setUserRname(user.getUserRname());
		user2.setUserTel(user.getUserTel());
		user2.setUserAddress(user.getUserAddress());
		user2.setUserEmail(user.getUserEmail());
		return userDao.update(user2);
	}

	@Override
	public boolean deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public TUser login(String userName, String password) {
		return userDao.login(userName, password);
	}

	@Override
	public PageBean<UserVO> findAddressList(int pageNo, int pageSize, String roleId, String userName, String orgId) {
		PageBean<TUser> pg0 =  userDao.findAddressList(pageNo, pageSize, roleId, userName, orgId);
		return change(pg0);
	}

	@Override
	public List<TUser> findAllUserInRole(String roleId, String orgId) {
		return userDao.findAllUserInRole(roleId, orgId);
	}

	@Override
	public List<TUser> findAllUserNotInRole(String roleId, String orgId) {
		return userDao.findAllUserNotInRole(roleId, orgId);
	}

	@Override
	public TUser findManagerByOrg(String orgId) {
		return userDao.findManagerByOrg(orgId);
	}

	@Override
	public List<TUser> findUserCanGo(String orgId) {
		return userDao.findUserCanGo(orgId);
	}

	@Override
	public List<TCar> findCarCanGo(String orgId) {
		return carDao.findCarCanGo(orgId);
	}

	@Override
	public PageBean<UserVO> change(PageBean<TUser> pg0) {
		List<TUser> list1 = pg0.getList();
		List<UserVO> list2 = new ArrayList<UserVO>();
		for (TUser user : list1) {
			list2.add(new UserVO(user,roleDao.findRole(user.getUserId())));
		}
		return new PageBean<UserVO>(list2,pg0.getPageNo(),pg0.getPageSize(),pg0.getTotalRecord());
	}

}
