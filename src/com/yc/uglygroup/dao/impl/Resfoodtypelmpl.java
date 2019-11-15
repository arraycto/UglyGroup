package com.yc.uglygroup.dao.impl;

import java.util.List;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IResfoodtypeDao;
import com.yc.uglygroup.entity.ResFoodType;

public class Resfoodtypelmpl implements IResfoodtypeDao {
	@Override
	public int addTypes(int rid, String trtype) {
		DBHelper db = new DBHelper();
		String sql = "insert into resfoodtype values (0,?,?)";
		return db.update(sql, rid,trtype);
	}

	@Override
	public List<ResFoodType> findAllTypes(int rid ) {
		DBHelper db = new DBHelper();
		String sql = "select trid,trtype from resfoodtype where rid = ?";
		return db.find(sql, ResFoodType.class, rid);
	}

}
