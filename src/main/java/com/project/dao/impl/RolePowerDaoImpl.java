/**
 * 
 */
package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IRolePowerDao;
import com.project.pojo.TRolePower;

/**
 * @author howroad
 * @Date 2018年5月9日
 * @version 1.0
 */
@Repository("rolePowerDao")
public class RolePowerDaoImpl extends BasicDaoAdapter<TRolePower, String> implements IRolePowerDao{

}
