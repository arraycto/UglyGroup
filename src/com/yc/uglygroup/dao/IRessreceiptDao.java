package com.yc.uglygroup.dao;

import java.util.List;
import java.util.Map;

public interface IRessreceiptDao {
	/**
	 * 分页查询收货地址
	 * @param uid
	 * @return
	 */
	public List<Map<String,String>> findByPageress(Integer uid,int page,int rows);
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
	public int address(Integer uid,String arname,String artel,String aradd ,Integer aid);
	/**
	 * 修改配送信息
	 * @param arid
	 * @param arname
	 * @param artel
	 * @param aradd
	 * @param aid
	 * @return
	 */
	public int addressup(Integer arid ,String arname,String artel,String aradd,Integer aid);
	/**
	 * 删除配送信息
	 * @param arid
	 * @return
	 */
	public int deleteaddress(Integer arid);
	/**
	 * 查找区域
	 * @return
	 */
	public  List<Map<String,String>> findarea();
}
