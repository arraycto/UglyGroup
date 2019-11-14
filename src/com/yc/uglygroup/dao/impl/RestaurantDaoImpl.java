package com.yc.uglygroup.dao.impl;

import java.util.Map;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IRestaurantDao;

public class RestaurantDaoImpl implements IRestaurantDao{

	@Override
	public int addRestaurant(Map<String, String> map) {
		DBHelper dbHelper = new DBHelper();
		String sql = "insert into restaurant values(0,?,?,?,?,?,?,?,?,2)";
		System.out.println("map.get('rpic')" + map.get("rpic"));
		return dbHelper.update(sql, map.get("uid"), map.get("aid"), map.get("tid"),
				map.get("radd"), map.get("rname"), map.get("rtel"), map.get("rpic"),
				map.get("rdisc"));
	}

}
