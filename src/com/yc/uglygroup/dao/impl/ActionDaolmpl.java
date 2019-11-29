package com.yc.uglygroup.dao.impl;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IActionDao;

import sun.security.pkcs11.Secmod.DbMode;

public class ActionDaolmpl implements IActionDao{

	@Override
	public int addaction(String acid, Integer rid, Integer actype) {
		DBHelper db = new DBHelper();
		String sql = "insert into action values (?,?,?)";
		return db.update(sql, acid,rid,actype);
	}

}
