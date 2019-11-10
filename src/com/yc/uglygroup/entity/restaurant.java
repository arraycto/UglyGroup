package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 * --[店铺表 restaurant]
 *--店铺编号 rid 主键
 *--店主 uid 外键 [用户表 user]
 *--店铺区域 aid 外键 [地区表 area]
 *--店铺特色美食类型 tid 外键 [美食类型表 foodtypes]
 *--详细地址 radd 
 *--店铺名 rname
 *--店铺联系电话 rtel
 *--店铺图片 rpic
 *--店铺简介 rdisc
 *--店铺状态 rstate 0.营业 1.休息 2.审核中
 * @author 12412
 *
 */
public class restaurant implements Serializable{
	private static final long serialVersionUID = 1L;

	private int rid;
	private int uid;
	private int aid;
	private int tid;
	private String radd;
	private String rname;
	private String rtel;
	private String rpic;
	private String rdisc;
	private int rstate;
	
	@Override
	public String toString() {
		return "restaurant [rid=" + rid + ", uid=" + uid + ", aid=" + aid + ", tid=" + tid + ", radd=" + radd
				+ ", rname=" + rname + ", rtel=" + rtel + ", rpic=" + rpic + ", rdisc=" + rdisc + ", rstate=" + rstate
				+ "]";
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getRadd() {
		return radd;
	}

	public void setRadd(String radd) {
		this.radd = radd;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRtel() {
		return rtel;
	}

	public void setRtel(String rtel) {
		this.rtel = rtel;
	}

	public String getRpic() {
		return rpic;
	}

	public void setRpic(String rpic) {
		this.rpic = rpic;
	}

	public String getRdisc() {
		return rdisc;
	}

	public void setRdisc(String rdisc) {
		this.rdisc = rdisc;
	}

	public int getRstate() {
		return rstate;
	}

	public void setRstate(int rstate) {
		this.rstate = rstate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public restaurant(int rid, int uid, int aid, int tid, String radd, String rname, String rtel, String rpic,
			String rdisc, int rstate) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.aid = aid;
		this.tid = tid;
		this.radd = radd;
		this.rname = rname;
		this.rtel = rtel;
		this.rpic = rpic;
		this.rdisc = rdisc;
		this.rstate = rstate;
	}

	public restaurant() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		result = prime * result + ((radd == null) ? 0 : radd.hashCode());
		result = prime * result + ((rdisc == null) ? 0 : rdisc.hashCode());
		result = prime * result + rid;
		result = prime * result + ((rname == null) ? 0 : rname.hashCode());
		result = prime * result + ((rpic == null) ? 0 : rpic.hashCode());
		result = prime * result + rstate;
		result = prime * result + ((rtel == null) ? 0 : rtel.hashCode());
		result = prime * result + tid;
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
		restaurant other = (restaurant) obj;
		if (aid != other.aid)
			return false;
		if (radd == null) {
			if (other.radd != null)
				return false;
		} else if (!radd.equals(other.radd))
			return false;
		if (rdisc == null) {
			if (other.rdisc != null)
				return false;
		} else if (!rdisc.equals(other.rdisc))
			return false;
		if (rid != other.rid)
			return false;
		if (rname == null) {
			if (other.rname != null)
				return false;
		} else if (!rname.equals(other.rname))
			return false;
		if (rpic == null) {
			if (other.rpic != null)
				return false;
		} else if (!rpic.equals(other.rpic))
			return false;
		if (rstate != other.rstate)
			return false;
		if (rtel == null) {
			if (other.rtel != null)
				return false;
		} else if (!rtel.equals(other.rtel))
			return false;
		if (tid != other.tid)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
}
