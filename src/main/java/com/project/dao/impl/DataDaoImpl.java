package com.project.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.project.dao.IDataDao;
import com.project.pojo.TData;

@Repository("dataDao")
public class DataDaoImpl extends BasicDaoAdapter<TData, Integer> implements IDataDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<TData> findData(String type) {
		String sql = "select t_data.* from t_data where t_data.data_type = ?";
		NativeQuery<TData> query = sessionFactory.getCurrentSession().createNativeQuery(sql).setParameter(1, type).addEntity(TData.class);
		return query.list();
	}

	@Override
	public String getValue(String type, String key) {
		String sql = "select t_data.* from t_data where t_data.data_type = ? and t_data.data_key = ?";
		return findEntityBySQL(sql, type,key).getDataValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllType() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select DISTINCT new java.lang.String(dataType) from TData";
		return session.createQuery(hql).list();
	}

	@Override
	public HashMap<String, Integer> getData1(String year) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		final String sql = "select area,count(task_id) as num from v_getdata1 group by area order by area asc";
		final ResultSet[] rs = new ResultSet[1];
		sessionFactory.getCurrentSession().doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				rs[0] =  connection.prepareStatement(sql).executeQuery();
			}
		});
		try {
			while(rs[0].next()) {
				map.put(rs[0].getString(1), rs[0].getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

}
