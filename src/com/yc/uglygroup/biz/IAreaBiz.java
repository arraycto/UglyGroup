package com.yc.uglygroup.biz;

import java.util.List;

import com.yc.uglygroup.entity.Area;

public interface IAreaBiz {
	
	/**
	 * 获取所有的地区名称
	 * @return
	 */
	public List<Area> getArea();
}
