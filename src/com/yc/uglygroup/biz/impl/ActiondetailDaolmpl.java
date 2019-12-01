package com.yc.uglygroup.biz.impl;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IActionDao;
import com.yc.uglygroup.dao.IActiondetailDao;
import com.yc.uglygroup.dao.impl.ActionDaolmpl;

public class ActiondetailDaolmpl implements IActiondetailDao{

	@Override
	public int addmj(String acid, Integer rid, Integer actype, Integer lowmin, Integer remoney,String datatime,String enddatatime,Integer fid) {
		DBHelper db = new DBHelper();
		IActionDao dao = new ActionDaolmpl();
		int ruselt = dao.addaction(acid, rid, actype);
		String sql = "insert into actiondetail value(0,?,?,null,?,?,?,?,null,0)";
		if(ruselt > 0 ){
			return db.update(sql, fid,acid,lowmin,remoney,datatime,enddatatime);
		}else{
			return 0;
		}

	}

	@Override
	public int adddz(String acid, Integer rid, Integer actype, Integer discount, Integer acnum,String datatime,String enddatatime, Integer fid) {
		DBHelper db = new DBHelper();
		IActionDao dao = new ActionDaolmpl();
		int ruselt = dao.addaction(acid, rid, actype);
		String sql = "insert into actiondetail value(0,?,?,?,null,null,?,?,?,0)";
		if(ruselt > 0 ){
			return db.update(sql, fid,acid,discount,datatime,enddatatime,acnum);
		}else{
			return 0;
		}
	}

}
