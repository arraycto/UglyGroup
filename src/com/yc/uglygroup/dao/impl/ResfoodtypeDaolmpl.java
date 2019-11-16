package com.yc.uglygroup.dao.impl;

import java.util.List;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IResfoodtypeDao;
import com.yc.uglygroup.entity.ResFoodType;

public class ResfoodtypeDaolmpl implements IResfoodtypeDao {
	@Override
	public int addTypes(int rid, String trtype) {
		DBHelper db = new DBHelper();
		String sql = "insert into resfoodtype values (0,?,?)";
		return db.update(sql, rid,trtype);
	}

	@Override
	public List<ResFoodType> findAllTypes(int rid ) {
		DBHelper db = new DBHelper();
		String sql = "select trid,trtype,rid from resfoodtype where rid = ?";
		return db.finds(sql, ResFoodType.class, rid);
	}

}
