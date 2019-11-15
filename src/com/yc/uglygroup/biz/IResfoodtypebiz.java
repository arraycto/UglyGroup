package com.yc.uglygroup.biz;

import java.util.List;

import com.yc.uglygroup.entity.ResFoodType;

public interface IResfoodtypebiz {
	/**
	 * 查询所有美食类型
	 * @return
	 */
	public List<ResFoodType> findAllTypes(int rid);

	/**
	 * 添加美食类型
	 * @return
	 */
	public int addTypes(int rid, String trtype);
}
