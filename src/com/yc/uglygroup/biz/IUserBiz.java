package com.yc.uglygroup.biz;

import com.yc.uglygroup.entity.User;

public interface IUserBiz {
	/**
	 * 用户登录
	 * @param account
	 * @param pwd
	 * @return
	 */
	public User login(String account, String pwd);
	
	/**
	 * 用户注册的方法
	 * @param uname
	 * @param upwd
	 * @param utel
	 * @return
	 */
	public User register(String uname, String upwd, String utel);
}
