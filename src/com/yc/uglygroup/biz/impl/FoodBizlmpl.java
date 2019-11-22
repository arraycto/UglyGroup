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
	public List<Foods> findfood() {
		IFoodDao dao = new FoodDaolmpl();
		return dao.findfood();
	public List<Map<String,String>> findfoods(Integer rid, int page, int rows) {
		IFoodDao dao = new FoodDaolmpl();
		return dao.findfoods(rid, page, rows);
>>>>>>> a6b8b626431cccc7ed261cf0329536dc6b0a5c63
	}

}
