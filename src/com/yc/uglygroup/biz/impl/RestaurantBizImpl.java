package com.yc.uglygroup.biz.impl;

import java.util.HashMap;
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
	public Map<String, Object> findByPage(int page, int rows, Object ... rstate) {
		Map<String, Object> map = new HashMap<String, Object>();
		IRestaurantDao restaurantDao = new RestaurantDaoImpl();
		
		map.put("total", restaurantDao.getTotal(rstate));
		map.put("rows", restaurantDao.findByPage(page, rows, rstate));
		
		return map;
	}

	@Override
	public int updateState(int rstate, int rid) {
		IRestaurantDao restaurantDao = new RestaurantDaoImpl();
		return restaurantDao.updateState(rstate, rid);
	}
}
