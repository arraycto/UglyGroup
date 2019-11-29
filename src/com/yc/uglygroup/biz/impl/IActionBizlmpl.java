package com.yc.uglygroup.biz.impl;

import com.yc.uglygroup.biz.IActionBiz;
import com.yc.uglygroup.dao.IActionDao;
import com.yc.uglygroup.dao.impl.ActionDaolmpl;

public class IActionBizlmpl implements IActionBiz{

	@Override
	public int addaction(String acid, Integer rid, Integer actype) {
		IActionDao dao = new ActionDaolmpl();
		return dao.addaction(acid, rid, actype);
	}

}
