package com.project.service;

import java.util.HashMap;
import java.util.List;

import com.project.pojo.TData;

public interface IDataService {
	/**
	 * 查修该种类所有数据
	 * @return 数据List
	 */
	public List<TData> findData(String type);
	/**
	 * 添加信息
	 * @param data 信息
	 * @return 成功或失败
	 */
	public boolean add(TData data);
	/**
	 * 获得所有类型
	 * @return list
	 */
	public List<String> getAllType();
	/**
	 * 根据年份查询各个区域的任务数量
	 * @param year
	 * @return map
	 */
	public HashMap<String,Integer> getData1(String year);
}
