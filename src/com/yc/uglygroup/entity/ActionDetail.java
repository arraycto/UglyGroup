package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 *--[活动详细表 actiondetail]
 *--活动详细编号 adid
 *--美食编号 fid 外键 [美食表 foods]
 *--活动编号 acid 外键 [活动表 action]
 *--折扣 discount
 *--满减下限 lowmin
 *--满减金额 remoney
 *--活动起始时间 acptime
 *--活动结束时间 acendtime
 *--满减数量 acnum
 *--活动状态 acstate 0.活动中 1.已结束
 * @author 12412
 *
 */
public class ActionDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	private int adid;
	private int fid;
	private String acid;
	private float discount;
	private int lowmin;
	private int remoney;
	private String acptime;
	private String acendtime;
	private int acnum;
	private int acstate;
	
	@Override
	public String toString() {
		return "actiondetail [adid=" + adid + ", fid=" + fid + ", acid=" + acid + ", discount=" + discount + ", lowmin="
				+ lowmin + ", remoney=" + remoney + ", acptime=" + acptime + ", acendtime=" + acendtime + ", acnum="
				+ acnum + ", acstate=" + acstate + "]";
	}

	public int getAdid() {
		return adid;
	}

	public void setAdid(int adid) {
		this.adid = adid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getLowmin() {
		return lowmin;
	}

	public void setLowmin(int lowmin) {
		this.lowmin = lowmin;
	}

	public int getRemoney() {
		return remoney;
	}

	public void setRemoney(int remoney) {
		this.remoney = remoney;
	}

	public String getAcptime() {
		return acptime;
	}

	public void setAcptime(String acptime) {
		this.acptime = acptime;
	}

	public String getAcendtime() {
		return acendtime;
	}

	public void setAcendtime(String acendtime) {
		this.acendtime = acendtime;
	}

	public int getAcnum() {
		return acnum;
	}

	public void setAcnum(int acnum) {
		this.acnum = acnum;
	}

	public int getAcstate() {
		return acstate;
	}

	public void setAcstate(int acstate) {
		this.acstate = acstate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ActionDetail(int adid, int fid, String acid, float discount, int lowmin, int remoney, String acptime,
			String acendtime, int acnum, int acstate) {
		super();
		this.adid = adid;
		this.fid = fid;
		this.acid = acid;
		this.discount = discount;
		this.lowmin = lowmin;
		this.remoney = remoney;
		this.acptime = acptime;
		this.acendtime = acendtime;
		this.acnum = acnum;
		this.acstate = acstate;
	}

	public ActionDetail() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acendtime == null) ? 0 : acendtime.hashCode());
		result = prime * result + ((acid == null) ? 0 : acid.hashCode());
		result = prime * result + acnum;
		result = prime * result + ((acptime == null) ? 0 : acptime.hashCode());
		result = prime * result + acstate;
		result = prime * result + adid;
		result = prime * result + Float.floatToIntBits(discount);
		result = prime * result + fid;
		result = prime * result + lowmin;
		result = prime * result + remoney;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActionDetail other = (ActionDetail) obj;
		if (acendtime == null) {
			if (other.acendtime != null)
				return false;
		} else if (!acendtime.equals(other.acendtime))
			return false;
		if (acid == null) {
			if (other.acid != null)
				return false;
		} else if (!acid.equals(other.acid))
			return false;
		if (acnum != other.acnum)
			return false;
		if (acptime == null) {
			if (other.acptime != null)
				return false;
		} else if (!acptime.equals(other.acptime))
			return false;
		if (acstate != other.acstate)
			return false;
		if (adid != other.adid)
			return false;
		if (Float.floatToIntBits(discount) != Float.floatToIntBits(other.discount))
			return false;
		if (fid != other.fid)
			return false;
		if (lowmin != other.lowmin)
			return false;
		if (remoney != other.remoney)
			return false;
		return true;
	}
}
