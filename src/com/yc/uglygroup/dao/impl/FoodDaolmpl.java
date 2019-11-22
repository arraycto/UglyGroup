package com.yc.uglygroup.dao.impl;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IFoodDao;
import com.yc.uglygroup.entity.Foods;

public class FoodDaolmpl implements IFoodDao{


	@Override
	public int addfood(Map<String, String> map) {
		DBHelper db = new DBHelper();
		String sql = "insert into foods values(0,?,?,?,?,?,?,?)";
		return db.update(sql, map.get("trid"),map.get("rid"),map.get("fname"),map.get("fprice"),map.getOrDefault("fpic", ""),map.get("fstate"),map.get("fdisc"));
	}

	@Override
	public List<Foods> findfoods() {
		DBHelper db = new DBHelper();
		String sql = "select * from foods where fname like % ";
		return db.finds(sql, Foods.class);
	}
	

}
