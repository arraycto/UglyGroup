package com.yc.uglygroup.biz;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.entity.Foods;

public interface IFoodBiz {

	public int addfood(Map<String, String> map);
	/**
	 * 查询食物
	 */
	public List<Foods> findfoods();
}
