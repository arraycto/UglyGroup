package com.yc.uglygroup.biz;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.entity.Restaurant;

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
	
	/**
	 * 查询用户店铺
	 * @param rid
	 * @return
	 */
	public Map<String, String> findres(Integer uid);
	/**
	 * 查询店铺名字
	 * @return
	 */
	public List<Restaurant> findrestaurantname(String str);
	/**
	 * 第一次分页查询
	 * @param rid 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String,Object> findByFirstPage(Integer rid,int page,int rows);
	/**
	 * 获取满足条件的数据总数
	 * @param tid
	 * @return
	 */
	public int getTotal(Integer tid);
	/**
	 * 分页查询
	 * @param rid 如rid为则查询所有
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Restaurant> findByPage1(Integer rid,int page,int rows);
	/**
	 * 三表查询
	 * @param rid
	 * @return
	 */
	public List<Restaurant> findsan(Integer rid);



}
