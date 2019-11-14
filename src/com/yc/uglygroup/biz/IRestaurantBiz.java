package com.yc.uglygroup.biz;

import java.util.Map;

public interface IRestaurantBiz {
	/**
	 * 添加店铺信息
	 * @param map
	 * @return
	 */
	public int addRestaurant(Map<String, String> map);
}
