package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 * --[美食表 foods]
 *--美食编号 fid 主键
 *--美食类型 trid 外键 [店铺美食类型表 resfoodtype]
 *--所属店铺 rid 外键 [店铺表 restaurant]
 *--美食名称 fname
 *--价格 fprice
 *--图片 fpic
 *--状态 fstate 0.已下架 1.已售完 2.销售中
 *--简介 fdisc
 * @author 12412
 *
 */
public class foods implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int fid;
	private int trid;
	private int rid;
	private String fname;
	private String fprice;
	private int fstate;
	private String fdisc;
	
	@Override
	public String toString() {
		return "foods [fid=" + fid + ", trid=" + trid + ", rid=" + rid + ", fname=" + fname + ", fprice=" + fprice
				+ ", fstate=" + fstate + ", fdisc=" + fdisc + "]";
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getTrid() {
		return trid;
	}

	public void setTrid(int trid) {
		this.trid = trid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFprice() {
		return fprice;
	}

	public void setFprice(String fprice) {
		this.fprice = fprice;
	}

	public int getFstate() {
		return fstate;
	}

	public void setFstate(int fstate) {
		this.fstate = fstate;
	}

	public String getFdisc() {
		return fdisc;
	}

	public void setFdisc(String fdisc) {
		this.fdisc = fdisc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public foods(int fid, int trid, int rid, String fname, String fprice, int fstate, String fdisc) {
		super();
		this.fid = fid;
		this.trid = trid;
		this.rid = rid;
		this.fname = fname;
		this.fprice = fprice;
		this.fstate = fstate;
		this.fdisc = fdisc;
	}

	public foods() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fdisc == null) ? 0 : fdisc.hashCode());
		result = prime * result + fid;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((fprice == null) ? 0 : fprice.hashCode());
		result = prime * result + fstate;
		result = prime * result + rid;
		result = prime * result + trid;
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
		foods other = (foods) obj;
		if (fdisc == null) {
			if (other.fdisc != null)
				return false;
		} else if (!fdisc.equals(other.fdisc))
			return false;
		if (fid != other.fid)
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (fprice == null) {
			if (other.fprice != null)
				return false;
		} else if (!fprice.equals(other.fprice))
			return false;
		if (fstate != other.fstate)
			return false;
		if (rid != other.rid)
			return false;
		if (trid != other.trid)
			return false;
		return true;
	}
}
