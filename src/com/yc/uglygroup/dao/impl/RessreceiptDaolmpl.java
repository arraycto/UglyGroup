package com.yc.uglygroup.dao.impl;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IRessreceiptDao;

public class RessreceiptDaolmpl implements IRessreceiptDao{

	@Override
	public List<Map<String, String>> findress(Integer uid) {
		DBHelper db = new DBHelper();
		String sql = "select arid,arname, artel, aradd ,ad.aid, aname  from addressreceipt ad ,area ar where uid = ? and ad.aid = ar.aid";
		return db.finds(sql, uid);
	}

	@Override
	public int address(Integer uid, String arname, String artel, String aradd,Integer aid) {
		DBHelper db = new DBHelper();
		String sql="insert into addressreceipt values(0,?,?,?,?,?)";
		return db.update(sql, uid,arname,artel,aradd,aid);
	}

	@Override
	public List<Map<String, String>> findarea() {
		DBHelper db = new DBHelper();
		String sql = "select aid ,aname from area";
		return db.finds(sql);
	}

	@Override
	public int addressup(Integer arid, String arname, String artel, String aradd, Integer aid) {
		DBHelper db = new DBHelper();
		String sql = "update  addressreceipt set arname= ? ,artel= ? ,aradd = ? ,aid=? where arid = ?";
		return db.update(sql, arname,artel,aradd,aid,arid);
	}

	@Override
	public int deleteaddress(Integer arid) {
		DBHelper db = new DBHelper();
		String sql = "delete from addressreceipt where arid = ?";
		return db.update(sql, arid);
	}

	@Override
	public List<Map<String, String>> findByPageress(Integer uid, int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select arid,arname, artel, aradd ,ad.aid, aname  from addressreceipt ad ,area ar where uid = ? and ad.aid = ar.aid order by arid desc limit ?,?";
		return db.finds(sql, uid,(page-1)*rows,rows);
	}

}
