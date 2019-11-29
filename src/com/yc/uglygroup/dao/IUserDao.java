package com.yc.uglygroup.dao;

import com.yc.uglygroup.entity.User;

public interface IUserDao{
	/**
	 * 登录的方法
	 * @return
	 */
	public User login(String account, String pwd); 
	
	/**
	 * 注册的方法
	 * @param uname
	 * @param upwd
	 * @param utel
	 * @return
	 */
	public int register(String uname, String upwd, String utel);
	/**
	 * 更改用户信息的方法
	 * @param uname
	 * @param upwd
	 * @param email
	 * @return
	 */
	public int userup(Integer uid, String uname, String upwd, String email, Integer ustate);
}
