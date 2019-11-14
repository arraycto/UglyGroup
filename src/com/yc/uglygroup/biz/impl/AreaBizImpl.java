package com.yc.uglygroup.biz.impl;

import java.util.List;

import com.yc.uglygroup.biz.IAreaBiz;
import com.yc.uglygroup.dao.IAreaDao;
import com.yc.uglygroup.dao.impl.AreaDaoImpl;
import com.yc.uglygroup.entity.Area;

public class AreaBizImpl implements IAreaBiz{

	@Override
	public List<Area> getArea() {
		IAreaDao areaDao = new AreaDaoImpl();
		return areaDao.getArea();
	}

}
