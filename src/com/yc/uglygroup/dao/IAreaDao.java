package com.yc.uglygroup.dao;

import java.util.List;

import com.yc.uglygroup.entity.Area;

public interface IAreaDao {

	/**
	 * 获取所有地区名称的方法
	 * @return
	 */
	public List<Area> getArea();
}
