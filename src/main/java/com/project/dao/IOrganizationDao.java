/**
 * 
 */
package com.project.dao;

import java.sql.ResultSet;
import java.util.List;

import com.project.pojo.TOrganization;
import com.project.util.PageBean;
import com.project.vo.OrgStateDto;

/**
 * @author cyr
 * @Date 2018年5月14日
 * @version 1.0
 */
public interface IOrganizationDao extends IBasicDao<TOrganization, String>{
	/**
	 * 根据条件查询所有的机构
	 * @param orgTypeKey 机构key
	 * @param AreaKey 区域key
	 * @return 查询到的所有机构
	 */
	public PageBean<TOrganization> pageBean(int pageNo,int pageSize,String orgTypeKey,String AreaKey);
	
	/**
	 * 获得机构的总车辆数
	 * @param orgId 机构ID
	 * @return 车辆数
	 */
	public int countTotalCar(String orgId) ;
	
	/**
	 * 获得机构的总人数
	 * @param orgId 机构ID
	 * @return 人数
	 */
	public int countTotalPerson(String orgId);
	
	/**
	 * 获得机构的可调配车辆数
	 * @param orgId 机构ID
	 * @return 车辆数
	 */
	public int countCurrentCar(String orgId);
	
	/**
	 * 获得机构的可调配人数
	 * @param orgId 机构ID
	 * @return 人数
	 */
	public int countCurrentPerson(String orgId);
	/**
	 * 根据组织机构代码号查询机构
	 * @param eventCode
	 * @return
	 */
	public TOrganization findByCode(String orgCode);
	/**
	 * 获得所有的机构
	 * @return
	 */
	public ResultSet findAllOrg();
	
	/**
	 * 批量查询
	 * @param lis
	 * @return
	 */
	public List<OrgStateDto> findByCodes(List<String> lis);
}
