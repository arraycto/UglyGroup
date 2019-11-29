package com.yc.uglygroup.biz;

public interface IActiondetailBiz {
	/**
	 * 满减活动
	 * @param acid
	 * @param rid
	 * @param actype
	 * @param lowmin
	 * @param remoney
	 * @param acnum
	 * @return
	 */
	public int addmj(String acid,Integer rid,Integer actype,Integer lowmin ,Integer remoney,Integer fid);
	/**
	 * 打折活动
	 * @param acid
	 * @param rid
	 * @param actype
	 * @param discount
	 * @param acnum
	 * @param fid
	 * @return
	 */
	public int adddz(String acid,Integer rid,Integer actype,Integer discount ,Integer acnum,Integer fid);

}
