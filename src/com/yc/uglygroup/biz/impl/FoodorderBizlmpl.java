package com.yc.uglygroup.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.biz.IFoodorderBiz;
import com.yc.uglygroup.dao.IFoodorderDao;
import com.yc.uglygroup.dao.impl.FoodDaolmpl;
import com.yc.uglygroup.dao.impl.FoodorderDaolmpl;

public class FoodorderBizlmpl implements IFoodorderBiz{

	@Override
	public List<Map<String, String>> findByPage(Integer uid, int page, int rows) {
		IFoodorderDao dao = new FoodorderDaolmpl();
		return dao.findByPage(uid, page, rows);
	}

	@Override
	public Map<String, String> ordertransmission(String fid, String fpic, String fname, String fprice, String num,
			String price) {
		IFoodorderDao dao = new FoodorderDaolmpl();
		return dao.ordertransmission(fid, fpic, fname, fprice, num, price);
	}

}
