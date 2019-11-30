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
		/**
		 * 店铺名 店铺图片 美食图片 美食名字 美食价格
		 */
	@Override
	public List<Map<String, String>> findfood(String str) {
		DBHelper db = new DBHelper();
		if(str !=null) {
			String sql = "select fo.rid, fname,fprice,fpic,res.aid, res.tid,rpic,rname,rstate,rdisc, fod.tname, ar.aname  from foods fo,restaurant res, area ar,foodtypes fod where res.aid=ar.aid and res.tid=fod.tid and fo.rid=res.rid and (fname like ? or res.rname like ? ) ";
			return db.finds(sql,'%'+str+'%','%'+str+'%');
		}
		return null;
	}
	
	
	public List<Map<String,String>> findfoods(Integer rid, int page, int rows) {
		String sql =null;
		DBHelper db =new DBHelper();
		if(rid == null){
			sql = "select  fid ,trtype ,fname ,fprice , fpic,fstate,fdisc  from foods f, resfoodtype r  where f.rid = r.rid and f.trid=r.trid order by trtype desc limit ?,?";
			return db.finds(sql, (page - 1)*rows,rows);
		}
		sql = "select fid ,trtype,fname ,fprice , fpic,fstate,fdisc  from foods f, resfoodtype r  where f.rid = r.rid and r.rid = ?  and f.trid = r.trid order by trtype desc limit ?,?";
		return db.finds(sql,rid, (page - 1)*rows,rows);
	}

	@Override
	public List<Foods> findAllfood(Integer rid) {
		DBHelper db =new DBHelper();
		String sql = "select fid, trid,rid,fname,fprice,fpic,fstate,fdisc from foods where rid = ? ";
		return db.finds(sql, Foods.class, rid);
	}
	
	@Override
	public int getTotal(Integer rid) {
		DBHelper db = new DBHelper();
		String sql = "select count(fid) from foods where rid = ?";
		return db.getTotal(sql);
	}

	@Override
	public int foodup(Integer fid, String fname, Double fprice, Integer trid) {
		DBHelper db = new DBHelper();
		String sql = "update  foods set fname= ? ,fprice= ? ,trid = ? where fid = ?";
		return db.update(sql, fname,fprice,trid,fid);
	}

	@Override
	public int fooddelete(Integer fid) {
		DBHelper db = new DBHelper();
		String sql = "delete from foods WHERE fid = ?";
		return db.update(sql,fid);
	}


}
