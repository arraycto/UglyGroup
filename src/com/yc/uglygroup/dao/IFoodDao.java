package com.yc.uglygroup.dao;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.entity.Foods;

public interface IFoodDao {
	
	public int addfood(Map<String,String> map);
	
	public List<Foods> findfoods();
}
