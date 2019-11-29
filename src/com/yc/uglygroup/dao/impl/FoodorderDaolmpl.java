package com.yc.uglygroup.dao.impl;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IFoodorderDao;


public class FoodorderDaolmpl implements IFoodorderDao{

	@Override
	public List<Map<String, String>> findByPage(Integer uid, int page, int rows) {
		DBHelper db =new DBHelper();
		String sql = "select rname ,r.rpic,oprice,otime,ostate from foodorder f ,restaurant r where f.rid = r.rid and f.uid = ?  order by otime desc limit ?,?";
		return db.finds(sql, uid,(page-1)*rows,rows);
	}

}
