package com.yc.uglygroup.dao.impl;

import java.util.List;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IAreaDao;
import com.yc.uglygroup.entity.Area;

public class AreaDaoImpl implements IAreaDao{

	@Override
	public List<Area> getArea() {
		DBHelper dbHelper = new DBHelper();
		String sql = "select aid, aname from area";
		return dbHelper.finds(sql, Area.class);
	}

}
