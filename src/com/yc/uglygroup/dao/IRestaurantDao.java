package com.yc.uglygroup.dao;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.entity.Restaurant;

public interface IRestaurantDao {
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
	public List<Restaurant> findByPage(int page, int rows, Object ... rstate);
	
	/**
	 * 获取未通过审核的店铺总记录数
	 * @return
	 */
	public int getTotal(Object ... rstate);
	
	/**
	 * 修改店铺状态
	 * @return
	 */
	public int updateState(int rstate, int rid);
}
