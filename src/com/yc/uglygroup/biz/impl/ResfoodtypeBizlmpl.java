package com.yc.uglygroup.biz.impl;

import java.util.List;

import com.yc.uglygroup.biz.IResfoodtypebiz;
import com.yc.uglygroup.dao.IFoodTypesDao;
import com.yc.uglygroup.dao.IResfoodtypeDao;
import com.yc.uglygroup.dao.impl.FoodTypesDaoImpl;
import com.yc.uglygroup.dao.impl.ResfoodtypeDaolmpl;
import com.yc.uglygroup.entity.ResFoodType;

public class ResfoodtypeBizlmpl implements IResfoodtypebiz{
	/**
	 * 添加商铺美食类型的方法
	 */
	@Override
	public int addTypes(int rid, String trtype) {
		IResfoodtypeDao resfoodtypedao = new ResfoodtypeDaolmpl();
		return resfoodtypedao.addTypes(rid, trtype);
	}

	@Override
	/**
	 * 查询该商铺美食类型的方法
	 */
	public List<ResFoodType> findAllTypes(int rid ) {
		IResfoodtypeDao resfoodtypedao = new ResfoodtypeDaolmpl();
		
		return resfoodtypedao.findAllTypes(rid);
	}

}
