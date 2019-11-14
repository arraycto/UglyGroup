package com.yc.uglygroup.dao;

import java.util.List;

import com.yc.uglygroup.entity.FoodTypes;

public interface IFoodTypesDao {
	/**
	 * 查询所有美食类型
	 */
	public List<FoodTypes> findAllTypes();
}
