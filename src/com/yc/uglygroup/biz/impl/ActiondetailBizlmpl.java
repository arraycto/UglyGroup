package com.yc.uglygroup.biz.impl;

import com.yc.uglygroup.biz.IActiondetailBiz;
import com.yc.uglygroup.dao.IActiondetailDao;

public class ActiondetailBizlmpl implements IActiondetailBiz{

	@Override
	public int addmj(String acid, Integer rid, Integer actype, Integer lowmin, Integer remoney, Integer fid) {
		IActiondetailDao dao = new ActiondetailDaolmpl();
		return dao.addmj(acid, rid, actype, lowmin, remoney, fid);
	}

	@Override
	public int adddz(String acid, Integer rid, Integer actype, Integer discount, Integer acnum, Integer fid) {
		IActiondetailDao dao = new ActiondetailDaolmpl();
		return dao.adddz(acid, rid, actype, discount, acnum, fid);
	}

}
