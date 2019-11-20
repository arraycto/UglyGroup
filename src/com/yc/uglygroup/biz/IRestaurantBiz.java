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
	 * 查询所有指定状态的信息店铺信息
	 * @return
	 */
	public Map<String, Object> findByPage(int page, int rows, Object ... rstate);
	
	/**
	 * 修改店铺状态
	 * @param rstate
	 * @param rid
	 * @return
	 */
	public int updateState(int rstate, int rid);
}
