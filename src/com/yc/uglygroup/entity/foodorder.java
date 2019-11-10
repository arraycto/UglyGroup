package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 *--[订单表 foodorder]
 *--订单编号 oid
 *--下单用户 uid 外键 [用户表 user]
 *--地址编号 arid 外键 [收获地址表 addressreceipt]
 *--总价格 oprice
 *--下单时间 otime
 *--实际送达时间 endtime
 *--订单状态 ostate 0.已下单 1.已付款 2.已送达 3.已取消
 * @author 12412
 *
 */
public class foodorder implements Serializable{
	private static final long serialVersionUID = 1L;

	private String oid;
	private int uid;
	private int arid;
	private float oprice;
	private String otime;
	private String endtime;
	private int ostate;
	
	@Override
	public String toString() {
		return "foodorder [oid=" + oid + ", uid=" + uid + ", arid=" + arid + ", oprice=" + oprice + ", otime=" + otime
				+ ", endtime=" + endtime + ", ostate=" + ostate + "]";
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getArid() {
		return arid;
	}

	public void setArid(int arid) {
		this.arid = arid;
	}

	public float getOprice() {
		return oprice;
	}

	public void setOprice(float oprice) {
		this.oprice = oprice;
	}

	public String getOtime() {
		return otime;
	}

	public void setOtime(String otime) {
		this.otime = otime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getOstate() {
		return ostate;
	}

	public void setOstate(int ostate) {
		this.ostate = ostate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public foodorder(String oid, int uid, int arid, float oprice, String otime, String endtime, int ostate) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.arid = arid;
		this.oprice = oprice;
		this.otime = otime;
		this.endtime = endtime;
		this.ostate = ostate;
	}

	public foodorder() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arid;
		result = prime * result + ((endtime == null) ? 0 : endtime.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + Float.floatToIntBits(oprice);
		result = prime * result + ostate;
		result = prime * result + ((otime == null) ? 0 : otime.hashCode());
		result = prime * result + uid;
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
		foodorder other = (foodorder) obj;
		if (arid != other.arid)
			return false;
		if (endtime == null) {
			if (other.endtime != null)
				return false;
		} else if (!endtime.equals(other.endtime))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (Float.floatToIntBits(oprice) != Float.floatToIntBits(other.oprice))
			return false;
		if (ostate != other.ostate)
			return false;
		if (otime == null) {
			if (other.otime != null)
				return false;
		} else if (!otime.equals(other.otime))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
}
