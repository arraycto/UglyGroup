package com.yc.uglygroup.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.uglygroup.biz.IRestaurantBiz;
import com.yc.uglygroup.dao.IRestaurantDao;
import com.yc.uglygroup.dao.impl.RestaurantDaoImpl;
import com.yc.uglygroup.entity.Restaurant;
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
	
	public Map<String, String> findres(Integer uid) {
		IRestaurantDao restaurantDao = new RestaurantDaoImpl();
		return restaurantDao.findres(uid);
	}

	@Override
	public List<Restaurant> findrestaurantname(String str) {
		IRestaurantDao restaurantdao = new RestaurantDaoImpl();
		return restaurantdao.findrestaurantname(str);
		
	}

	@Override
	public Map<String, Object> findByFirstPage(Integer rid, int page, int rows) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", this.findByPage1(rid, page, rows));
		map.put("total", this.getTotal(rid));
		return map;
	}

	@Override
	public int getTotal(Integer rid) {
		IRestaurantDao restaurantdao = new RestaurantDaoImpl();
		return restaurantdao.getTotal(rid);
	}

	@Override
	public List<Restaurant> findByPage1(Integer rid, int page, int rows) {
		IRestaurantDao restaurantdao = new RestaurantDaoImpl();
		return restaurantdao.findByPage1(rid, page, rows);
	}

	@Override
	public List<Restaurant> findsan(Integer rid) {
		IRestaurantDao restaurantdao = new RestaurantDaoImpl();
		return restaurantdao.findsan(rid);
	}
}
