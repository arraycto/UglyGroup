package com.yc.uglygroup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IRestaurantDao;
import com.yc.uglygroup.entity.Restaurant;

public class RestaurantDaoImpl implements IRestaurantDao{

	@Override
	public int addRestaurant(Map<String, String> map) {
		DBHelper dbHelper = new DBHelper();
		String sql = "insert into restaurant values(0,?,?,?,?,?,?,?,?,2)";
		return dbHelper.update(sql, map.get("uid"), map.get("aid"), map.get("tid"),
				map.get("radd"), map.get("rname"), map.get("rtel"), map.getOrDefault("pics", ""),
				map.get("rdisc"));
	}

	@Override
	public List<Restaurant> findByPage(int page, int rows, Object ... rstate) {
		DBHelper dbHelper = new DBHelper();
		List<Object> list = new ArrayList<Object>(); // 用来存储参数
		String sql = "select rid, uid, aid, tid, radd, rname, rtel, rpic,"
				+ " rdisc, rstate from restaurant";
		if (rstate != null && rstate.length > 0) {
			sql += " where";
			for(int i = 0, len = rstate.length; i < len; ++ i){
				sql += " rstate = ?";
				list.add(rstate[i]);
				if ((i+1) != len) { // 如果后面还有元素
					sql += " or";
				}
			}
		}
		sql += " order by rid desc limit ?,?";
		list.add((page-1) * rows);
		list.add(rows);
		return dbHelper.finds(sql, Restaurant.class, list);
	}

	@Override
	public int getTotal(Object ... rstate) {
		DBHelper dbHelper = new DBHelper();
		List<Object> list = new ArrayList<Object>(); // 用来存储参数
		String sql = "select count(rid) from restaurant";
		if (rstate != null && rstate.length > 0) {
			sql += " where";
			for(int i = 0, len = rstate.length; i < len; ++ i){
				sql += " rstate = ?";
				list.add(rstate[i]);
				if ((i+1) != len) { // 如果后面还有元素
					sql += " or";
				}
			}
		}
		return dbHelper.getTotal(sql, list);
	}

	@Override
	public int updateState(int rstate, int rid) {
		DBHelper dbHelper = new DBHelper();
		String sql = "update restaurant set rstate = ? where rid =?";
		return dbHelper.update(sql, rstate, rid);
	}

}
