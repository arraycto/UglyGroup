package com.yc.uglygroup.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.biz.IFoodBiz;
import com.yc.uglygroup.dao.IFoodDao;
import com.yc.uglygroup.dao.impl.FoodDaolmpl;
import com.yc.uglygroup.entity.Foods;

public class FoodBizlmpl implements IFoodBiz{

	@Override
	public int addfood(Map<String,String> map) {
		IFoodDao dao = new FoodDaolmpl();
		return dao.addfood(map);
	}

	@Override
	public List<Foods> findfood(String str) {
		IFoodDao dao = new FoodDaolmpl();
		return dao.findfood(str);
	}

	public List<Map<String,String>> findfoods(Integer rid, int page, int rows) {
		IFoodDao dao = new FoodDaolmpl();
		return dao.findfoods(rid, page, rows);
	}

	@Override
	public List<Foods> findAllfood(Integer rid) {
		IFoodDao dao = new FoodDaolmpl();
		return dao.findAllfood(rid);
	}

	@Override
	public int foodup(Integer fid, String fname, Double fprice, Integer trid) {
		IFoodDao dao = new FoodDaolmpl();
		return dao.foodup(fid, fname, fprice, trid);
	}

	@Override
	public int fooddelete(Integer fid) {
		IFoodDao dao = new FoodDaolmpl();
		return dao.fooddelete(fid);		
	}
}
