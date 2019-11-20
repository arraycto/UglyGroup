package com.yc.uglygroup.dao.impl;

import java.util.List;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IFoodTypesDao;
import com.yc.uglygroup.entity.FoodTypes;

public class FoodTypesDaoImpl implements IFoodTypesDao{

	@Override
	public List<FoodTypes> findAllTypes() {
		DBHelper dbHelper = new DBHelper();
		String sql = "select tid, tname from foodtypes";
		return dbHelper.finds(sql, FoodTypes.class);
	}


	
}
