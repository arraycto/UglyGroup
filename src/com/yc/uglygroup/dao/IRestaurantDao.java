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
	 * 获取满足条件的数据总数
	 * @param rid
	 * @return
	 */
	public int getTotal(Integer rid);
	
	/**
	 * 修改店铺状态
	 * @return
	 */
	public int updateState(int rstate, int rid);
	
	/**
	 * 查询自己的商铺
	 * @param uid
	 * @return
	 */
	public Map<String, String> findres(Integer uid);
	/**
	 * 查询店铺名字
	 * @return
	 */
	public List<Map<String,String>> resinfo(Integer rid);
	/**
	 * 分页查询
	 * @param rid	如商品类型编号为null，则分页查询所有
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Map<String, String>> findByPage1(Integer rid,int page,int rows);
	
	public List<Map<String,String>> rtinfo(Integer rid);
	/**
	 * 按区域查找店铺
	 * @param aid
	 * @return
	 */
	public List<Map<String,String>> areafinds( Integer aid);
	/**
	 * 按特色菜系查找店铺
	 * @param aid
	 * @return
	 */
	public List<Map<String,String>> foodtypefinds( Integer tid);
}
