package com.yc.uglygroup.dao;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.entity.Foods;

public interface IFoodDao {
	/**
	 * 添加美食的方法
	 * @param map
	 * @return
	 */
	public int addfood(Map<String,String> map);
	
	public List<Foods> findfood();
	/**
	 * 分页查询的方法
	 * @param Rid
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Map<String,String>> findfoods(Integer rid , int page, int rows);
}
