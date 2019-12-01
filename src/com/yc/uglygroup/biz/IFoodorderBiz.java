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
	/**
	 * 订单数据整合传输
	 */
	public Map<String,String> ordertransmission(String fid , String fpic, String fname,String fprice,String num,String price);
}
