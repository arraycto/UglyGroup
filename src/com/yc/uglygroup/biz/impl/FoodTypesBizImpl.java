package com.yc.uglygroup.biz.impl;

import java.util.List;

import com.yc.uglygroup.biz.IFoodTypesBiz;
import com.yc.uglygroup.dao.IFoodTypesDao;
import com.yc.uglygroup.dao.impl.FoodTypesDaoImpl;
import com.yc.uglygroup.entity.FoodTypes;

public class FoodTypesBizImpl implements IFoodTypesBiz{

	@Override
	public List<FoodTypes> findAllTypes() {
			IFoodTypesDao foodTypesDao = new FoodTypesDaoImpl();
			return foodTypesDao.findAllTypes();

	}



}
