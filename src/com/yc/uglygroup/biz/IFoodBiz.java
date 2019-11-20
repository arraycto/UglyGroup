package com.yc.uglygroup.biz;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.entity.Foods;

public interface IFoodBiz {

	public int addfood(Map<String, String> map);
	
	
	/**
	 * 分页查询的方法(图片，名称，类型，价格)
	 * @param Rid
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Map<String,String>> findfoods(Integer rid , int page, int rows);
	
}
