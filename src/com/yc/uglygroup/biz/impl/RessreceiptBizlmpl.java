package com.yc.uglygroup.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.uglygroup.biz.IRessreceiptBiz;
import com.yc.uglygroup.dao.IRessreceiptDao;
import com.yc.uglygroup.dao.impl.RessreceiptDaolmpl;

public class RessreceiptBizlmpl implements IRessreceiptBiz {

	@Override
	public List<Map<String, String>> findress(Integer uid) {
		IRessreceiptDao dao = new RessreceiptDaolmpl();
		return dao.findress(uid);
	}

	@Override
	public int address(Integer uid, String arname, String artel, String aradd) {
		IRessreceiptDao dao = new RessreceiptDaolmpl();
		return dao.address(uid, arname, artel, aradd);
	}

	@Override
	public List<Map<String, String>> findarea() {
		IRessreceiptDao dao = new RessreceiptDaolmpl();
		return dao.findarea();
	}
}
