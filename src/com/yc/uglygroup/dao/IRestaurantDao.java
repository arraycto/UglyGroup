package com.yc.uglygroup.dao;

import java.util.Map;

public interface IRestaurantDao {
	/**
	 * 添加店铺信息
	 * @param map
	 * @return
	 */
	public int addRestaurant(Map<String, String> map);
	/**
	 * 查询自己的商铺
	 * @param uid
	 * @return
	 */
	public Map<String, String> findres(Integer uid);
	
}
