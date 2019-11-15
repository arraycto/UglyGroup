package com.yc.uglygroup.dao;

import java.util.List;

import com.yc.uglygroup.entity.ResFoodType;

public interface IResfoodtypeDao {
	/**
	 * 查询所有美食类型
	 */
	public List<ResFoodType> findAllTypes(int rid);
	/**
	 * 添加店铺美食类型
	 * @return
	 */
	public int addTypes(int rid,String trtype);
}
