package com.project.dao;

import java.util.HashMap;
import java.util.List;

import com.project.pojo.TData;

public interface IDataDao extends IBasicDao<TData, Integer>{
	/**
	 * 查修该种类所有数据
	 * @return 数据List
	 */
	public List<TData> findData(String type);
	/**
	 * 获得数据
	 * @param type 数据类型
	 * @param key 数据Key
	 * @return 数据Value
	 */
	public String getValue(String type,String key);
	/**
	 * 获得所有数据类型
	 * @return
	 */
	public List<String> getAllType();
	/**
	 * 根据年份查询任务数量
	 * @param year
	 * @return
	 */
	public HashMap<String,Integer> getData1(String year);
}
