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
	public List<Foods> findfoods() {
		IFoodDao dao = new FoodDaolmpl();
		return dao.findfoods();
	}

}
