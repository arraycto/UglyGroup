package com.yc.uglygroup.dao.impl;

import com.yc.uglygroup.dao.DBHelper;
import com.yc.uglygroup.dao.IUserDao;
import com.yc.uglygroup.entity.User;

public class UserDaoImpl implements IUserDao{

	@Override
	public User login(String account, String pwd) {
		DBHelper dbHelper = new DBHelper();
		String sql = "select uid, uname, upwd, utel, email, ustate from user where (uname=? or utel=? or email=?) and upwd=?";
		return dbHelper.find(sql, User.class, account, account, account, pwd);
	}

	@Override
	public int register(String uname, String upwd, String utel) {
		DBHelper dbHelper = new DBHelper();
		String sql = "insert into user values(0,?,?,?,null,'0')";
		return dbHelper.update(sql, uname, upwd, utel);
	}

}
