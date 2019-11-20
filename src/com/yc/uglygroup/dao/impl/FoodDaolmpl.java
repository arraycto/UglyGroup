package com.yc.uglygroup.dao.impl;

import java.util.Map;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IFoodDao;

public class FoodDaolmpl implements IFoodDao{


	@Override
	public int addfood(Map<String, String> map) {
		DBHelper db = new DBHelper();
		String sql = "insert into foods values(0,?,?,?,?,?,?,?)";
		return db.update(sql, map.get("trid"),map.get("rid"),map.get("fname"),map.get("fprice"),map.getOrDefault("fpic", ""),map.get("fstate"),map.get("fdisc"));
	}

}
