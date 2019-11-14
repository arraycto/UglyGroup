package com.yc.uglygroup.dao;

import java.util.Map;

public interface IRestaurantDao {
	/**
	 * 添加店铺信息
	 * @param map
	 * @return
	 */
	public int addRestaurant(Map<String, String> map);
}
