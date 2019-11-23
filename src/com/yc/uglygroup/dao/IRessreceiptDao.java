package com.yc.uglygroup.dao;

import java.util.List;
import java.util.Map;

public interface IRessreceiptDao {
	/**
	 * 查询收货地址
	 * @param uid
	 * @return
	 */
	public List<Map<String,String>> findress(Integer uid);
	/**
	 * 添加配送信息
	 * @param uid
	 * @param arname
	 * @param artel
	 * @param aradd
	 * @return
	 */
	public int address(Integer uid,String arname,String artel,String aradd);
	/**
	 * 查找区域
	 * @return
	 */
	public  List<Map<String,String>> findarea();
}
