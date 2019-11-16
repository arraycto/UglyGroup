package com.yc.uglygroup.biz.impl;

import java.util.Map;

import com.yc.uglygroup.biz.IRestaurantBiz;
import com.yc.uglygroup.dao.IRestaurantDao;
import com.yc.uglygroup.dao.impl.RestaurantDaoImpl;
import com.yc.uglygroup.util.StringUtil;

public class RestaurantBizImpl implements IRestaurantBiz{

	@Override
	public int addRestaurant(Map<String, String> map) {
		if (StringUtil.checkNull(map.get("uid"), map.get("aid"), map.get("tid"), map.get("radd"), map.get("rname"), map.get("rtel"))) {
			return -1;
		}
		IRestaurantDao restaurantDao = new RestaurantDaoImpl();
		return restaurantDao.addRestaurant(map);
	}

	@Override
	public Map<String, String> findres(Integer uid) {
		IRestaurantDao restaurantDao = new RestaurantDaoImpl();
		return restaurantDao.findres(uid);
	}

}
