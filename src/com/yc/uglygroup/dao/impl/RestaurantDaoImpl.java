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

	public Map<String, String> findres(Integer uid) {
		DBHelper dbHelper = new DBHelper();
		String sql = "select rid , rname , aid,radd,rpic,rdisc,rstate from restaurant where uid = ?";
		return dbHelper.find(sql, uid);
	}

	@Override
	public List<Map<String, String>> resinfo(Integer rid){
		DBHelper db = new DBHelper();
		String sql = "select rdisc, rname,rpic from restaurant res  where res.rid= ? ";
		return db.finds(sql, rid);
	}

	@Override
	public int getTotal(Integer rid) {
		DBHelper db = new DBHelper();
		if(rid == null) {
			String sql = "select count(rid) from restaurant";
			return db.getTotal(sql);
		}else {
			String sql = "select count(rid) from restaurant where rid = ?";
			return db.getTotal(sql,rid);
		}
		
	}

	@Override
	public List<Map<String,String>> findByPage1(Integer rid, int page, int rows) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "select res.rid,res.aid, res.tid,rpic,rname,rstate,rdisc, fod.tname, ar.aname from restaurant res, area ar,foodtypes fod where res.aid=ar.aid and res.tid=fod.tid ";
			if(rid !=null) {
				sql +="and res.rid =?";
				params.add(rid);
			}
			//mysql 分页查找 关键字limit
			sql += " limit ?,?";//第一个参数是从哪一条记录开始查，第二参数是查多少条
			params.add((page-1) * rows);
			params.add(rows);
		return db.finds(sql,params) ;
	}

	@Override
	public List<Map<String, String>> rtinfo(Integer rid) {
		DBHelper db = new DBHelper();
		String sql = "select trtype ,trid from resfoodtype  where  rid= ? ";
		return db.finds(sql, rid);
	}

	@Override
	public List<Map<String, String>> fodinfo(Integer str,Integer id) {
		DBHelper db = new DBHelper();
		if(str == 999) {
			String sql = "select fo.fid,refo.trtype,fo.fname,fo.fprice,fo.fpic,fo.fdisc,acta.discount, acta.acnum from resfoodtype refo, foods fo,action ac,actiondetail acta where acta.acid=ac.acid  and ac.rid=refo.rid and fo.trid=refo.trid and fo.fid=acta.fid and ac.actype=1 and acta.acstate=0 and refo.rid= ?";
			return db.finds(sql, id);
		}else {
			String sql = "select fo.fid,refo.trtype,fname,fprice ,fpic,fdisc,fstate from resfoodtype refo, foods fo  where fo.trid=refo.trid and fo.rid=refo.rid and refo.trid= ? and refo.rid= ?";
			return db.finds(sql, str,id);
		}
	}
}
