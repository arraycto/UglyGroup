package com.yc.uglygroup.biz;

import java.util.Map;

public interface IRestaurantBiz {
	/**
	 * 添加店铺信息
	 * @param map
	 * @return
	 */
	public int addRestaurant(Map<String, String> map);
	/**
	 * 查询用户店铺
	 * @param rid
	 * @return
	 */
	public Map<String, String> findres(Integer uid);
}
