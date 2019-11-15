package com.yc.uglygroup.biz;

import java.util.List;

import com.yc.uglygroup.entity.FoodTypes;

public interface IFoodTypesBiz {
	/**
	 * 查询所有美食类型
	 * @return
	 */
	public List<FoodTypes> findAllTypes();

}
