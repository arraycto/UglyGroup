package com.yc.uglygroup.biz;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.entity.Foods;

public interface IFoodBiz {

	public int addfood(Map<String, String> map);
	/**
	 * 查询食物
	 */
	public List<Map<String,String>> findfood(String str);
	/**
	 * 分页查询的方法
	 * @param Rid
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Map<String,String>> findfoods(Integer rid , int page, int rows);
	/**
	 * 查询店铺所有食物
	 * @return
	 */
	public List<Foods> findAllfood(Integer rid);
	
	/**
	 * 修改店铺美食
	 * @param fid
	 * @param fname
	 * @param fprice
	 * @param trid
	 * @return
	 */
	public int foodup(Integer fid ,String fname,Double fprice,Integer trid);
	
	/**
	 * 删除店铺美食
	 * @param fid
	 * @return
	 */
	public int fooddelete(Integer fid);
	
	
}
