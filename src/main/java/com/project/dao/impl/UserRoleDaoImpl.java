/**
 * 
 */
package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IUserRoleDao;
import com.project.pojo.TUserRole;

/**
 * @author howroad
 * @Date 2018年5月18日
 * @version 1.0
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl extends BasicDaoAdapter<TUserRole, String> implements IUserRoleDao {

}
