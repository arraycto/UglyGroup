package com.yc.uglygroup.biz.impl;

import java.util.List;

import com.yc.uglygroup.biz.IResfoodtypebiz;
import com.yc.uglygroup.dao.IFoodTypesDao;
import com.yc.uglygroup.dao.impl.FoodTypesDaoImpl;
import com.yc.uglygroup.dao.impl.Resfoodtypelmpl;
import com.yc.uglygroup.entity.ResFoodType;

public class ResfoodtypeBizlmpl implements IResfoodtypebiz{
	/**
	 * 添加商铺美食类型的方法
	 */
	@Override
	public int addTypes(int rid, String trtype) {
		IResfoodtypebiz resfoodtypebiz = new ResfoodtypeBizlmpl();
		return resfoodtypebiz.addTypes(rid, trtype);
	}

	@Override
	/**
	 * 查询该商铺美食类型的方法
	 */
	public List<ResFoodType> findAllTypes(int rid ) {
		Resfoodtypelmpl resfoodtypelmpl = new Resfoodtypelmpl();
		
		return resfoodtypelmpl.findAllTypes(rid);
	}

}
