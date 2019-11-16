package com.yc.uglygroup.biz.impl;

import java.util.Map;

import com.yc.uglygroup.biz.IFoodBiz;
import com.yc.uglygroup.dao.IFoodDao;
import com.yc.uglygroup.dao.impl.FoodDaolmpl;

public class FoodBizlmpl implements IFoodBiz{

	@Override
	public int addfood(Map<String,String> map) {
		IFoodDao dao = new FoodDaolmpl();
		return dao.addfood(map);
	}

}
