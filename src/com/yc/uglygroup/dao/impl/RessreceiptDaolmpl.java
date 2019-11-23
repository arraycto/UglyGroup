package com.yc.uglygroup.dao.impl;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IRessreceiptDao;

public class RessreceiptDaolmpl implements IRessreceiptDao{

	@Override
	public List<Map<String, String>> findress(Integer uid) {
		DBHelper db = new DBHelper();
		String sql = "select arid,arname, artel, aradd from addressreceipt where uid = ?";
		return db.finds(sql, uid);
	}

	@Override
	public int address(Integer uid, String arname, String artel, String aradd) {
		DBHelper db = new DBHelper();
		String sql="insert into addressreceipt values(0,?,?,?,?)";
		return db.update(sql, uid,arname,artel,aradd);
	}

	@Override
	public List<Map<String, String>> findarea() {
		DBHelper db = new DBHelper();
		String sql = "select aid ,aname from area";
		return db.finds(sql);
	}

}
