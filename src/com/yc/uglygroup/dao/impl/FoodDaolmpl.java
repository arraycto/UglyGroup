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
		String sql = "insert into foods values(0,?,?,?,?,?,2,?)";
		return db.update(sql, map.get("trid"),map.get("rid"),map.get("fname"),map.get("fprice"),map.getOrDefault("pic", ""),map.get("fdisc"));
	}

	@Override
	public List<Map<String,String>> findfoods(Integer rid, int page, int rows) {
		String sql =null;
		DBHelper db =new DBHelper();
		if(rid == null){
			sql = "select trtype ,fname ,fprice , fpic,fstate,fdisc  from foods f, resfoodtype r  where f.rid = r.rid and f.trid=r.trid order by trtype desc limit ?,?";
			return db.finds(sql, (page - 1)*rows,rows);
		}
		sql = "select trtype,fname ,fprice , fpic,fstate,fdisc  from foods f, resfoodtype r  where f.rid = r.rid and r.rid = ?  and f.trid = r.trid order by trtype desc limit ?,?";
		return db.finds(sql,rid, (page - 1)*rows,rows);
	}
	
}