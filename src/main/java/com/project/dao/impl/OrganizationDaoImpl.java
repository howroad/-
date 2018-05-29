/**
 * 
 */
package com.project.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.project.dao.IOrganizationDao;
import com.project.pojo.TOrganization;
import com.project.util.PageBean;
import com.project.vo.OrgStateDto;

/**
 * @author cyr
 * @Date 2018年5月14日
 * @version 1.0
 */
@Repository("organizationDao")
public class OrganizationDaoImpl extends BasicDaoAdapter<TOrganization, String> implements IOrganizationDao {

	@Override
	public PageBean<TOrganization> pageBean(int pageNo, int pageSize, String orgTypeKey, String AreaKey) {
		String sql1 = "select t_organization.* from t_organization where t_organization.org_type like ? and  t_organization.org_area like ?";
		String sql2 = "select count(0) from t_organization where t_organization.org_type like ? and  t_organization.org_area like ?";
		return this.findAllPage(pageNo, pageSize, sql1, sql2, "%"+orgTypeKey+"%", "%"+AreaKey+"%");
	}

	@Override
	public int countTotalCar(String orgId) {
		String sql ="select count(0) from t_car where org_id = ?";
		return countBySQL(sql,orgId);
	}

	@Override
	public int countTotalPerson(String orgId) {
		String sql ="select count(0) from t_user where org_id = ?";
		return countBySQL(sql,orgId);
	}

	@Override
	public int countCurrentCar(String orgId) {
		String sql ="select count(0) from t_car where org_id = ? and car_out_state = 0";
		return countBySQL(sql,orgId);
	}

	@Override
	public int countCurrentPerson(String orgId) {
		String sql ="select count(0) from t_user where org_id = ? and user_out_state = 0";
		return countBySQL(sql,orgId);
	}

	@Override
	public TOrganization findByCode(String eventCode) {
		String sql = "select t_organization.* from t_organization where t_organization.org_code = ? limit 1";
		return findEntityBySQL(sql, eventCode);
	}

	@Override
	public ResultSet findAllOrg() {
		final String sql = "select DISTINCT org_name,dt1.data_value,dt2.data_value, user_rname,user_Tel,org_code from t_organization " + 
				"left join t_user on t_user.org_id = t_organization.org_id " + 
				"left join t_data as dt1 on dt1.data_key = org_type and dt1.data_type = 'JGLX'" + 
				"left join t_data as dt2 on dt2.data_key = org_area and dt2.data_type = 'QY'" + 
				"where t_user.user_manager_state = 1";
		final ResultSet[] rs = new ResultSet[1];
		sessionFactory.getCurrentSession().doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				rs[0] =  connection.prepareStatement(sql).executeQuery();
			}
		});
		return rs[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrgStateDto> findByCodes(List<String> list) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select org_code orgCode ,org_name orgName,"
				+ "(select count(0) from t_user where t_user.org_id = t_organization.org_id) rCurrentPerson,"
				+ "(select count(0) from t_car where t_car.org_id = t_organization.org_id) rCurrentCar from t_organization "
				+ "where org_code in (:list)";
		Query<OrgStateDto> q = session.createNativeQuery(sql).setParameterList("list", list);
		return q.list();
	}



	
}
