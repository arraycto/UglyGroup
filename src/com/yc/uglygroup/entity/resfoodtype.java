package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 * --[店铺美食类型表 resfoodtype]
 *--美食编号 trid 主键
 *--店铺 rid 外键 [店铺表 restaurant]
 *--美食类型 trtype
 * @author 12412
 *
 */
public class resfoodtype implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int trid;
	private int rid;
	private String trtype;
	
	@Override
	public String toString() {
		return "resfoodtype [trid=" + trid + ", rid=" + rid + ", trtype=" + trtype + "]";
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

	public String getTrtype() {
		return trtype;
	}

	public void setTrtype(String trtype) {
		this.trtype = trtype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public resfoodtype(int trid, int rid, String trtype) {
		super();
		this.trid = trid;
		this.rid = rid;
		this.trtype = trtype;
	}

	public resfoodtype() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rid;
		result = prime * result + trid;
		result = prime * result + ((trtype == null) ? 0 : trtype.hashCode());
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
		resfoodtype other = (resfoodtype) obj;
		if (rid != other.rid)
			return false;
		if (trid != other.trid)
			return false;
		if (trtype == null) {
			if (other.trtype != null)
				return false;
		} else if (!trtype.equals(other.trtype))
			return false;
		return true;
	}
}
