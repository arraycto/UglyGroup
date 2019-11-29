package com.yc.uglygroup.biz.impl;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IActionDao;
import com.yc.uglygroup.dao.IActiondetailDao;
import com.yc.uglygroup.dao.impl.ActionDaolmpl;

public class ActiondetailDaolmpl implements IActiondetailDao{

	@Override
	public int addmj(String acid, Integer rid, Integer actype, Integer lowmin, Integer remoney,Integer fid) {
		DBHelper db = new DBHelper();
		IActionDao dao = new ActionDaolmpl();
		int ruselt = dao.addaction(acid, rid, actype);
		String sql = "insert into actiondetail value(0,?,?,null,?,?,null,null,null,0)";
		if(ruselt > 0 ){
			return db.update(sql, fid,acid,lowmin,remoney);
		}else{
			return 0;
		}

	}

	@Override
	public int adddz(String acid, Integer rid, Integer actype, Integer discount, Integer acnum, Integer fid) {
		DBHelper db = new DBHelper();
		IActionDao dao = new ActionDaolmpl();
		int ruselt = dao.addaction(acid, rid, actype);
		String sql = "insert into actiondetail value(0,?,?,?,null,null,null,null,?,0)";
		if(ruselt > 0 ){
			return db.update(sql, fid,acid,discount,acnum);
		}else{
			return 0;
		}
	}

}
