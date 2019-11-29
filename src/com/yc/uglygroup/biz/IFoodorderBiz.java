package com.yc.uglygroup.biz;

import java.util.List;
import java.util.Map;

public interface IFoodorderBiz {
	/**
	 * mycenter查询订单的方法
	 * @param uid
	 * @return
	 */
	public List<Map<String,String>> findByPage(Integer uid , int page, int rows);
}
