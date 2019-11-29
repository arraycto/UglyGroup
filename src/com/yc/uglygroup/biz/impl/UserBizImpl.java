package com.yc.uglygroup.biz.impl;

import com.yc.uglygroup.biz.IUserBiz;
import com.yc.uglygroup.dao.IUserDao;
import com.yc.uglygroup.dao.impl.UserDaoImpl;
import com.yc.uglygroup.entity.User;
import com.yc.uglygroup.util.StringUtil;

public class UserBizImpl implements IUserBiz{

	@Override
	public User login(String account, String pwd) {
		if (StringUtil.checkNull(account, pwd)) { // 如果账号密码为空，则直接返回
			return null;
		}
		// 如果不为空，则访问数据模型层获取数据
		IUserDao userDao = new UserDaoImpl();
		return userDao.login(account, pwd);
	}

	/**
	 * 注册后并进行登录操作
	 */
	@Override
	public User register(String uname, String upwd, String utel) {
		// 如果不为空，则访问数据模型层写入数据
		IUserDao userDao = new UserDaoImpl();
		if (userDao.register(uname, upwd, utel) > 0) { //说明注册成功
			return userDao.login(utel, upwd);
		} else {
			return null;
		}
	}

	@Override
	public int userup(Integer uid, String uname, String upwd, String email,Integer ustate) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.userup(uid, uname, upwd, email ,ustate);
	}
}
