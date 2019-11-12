package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 *--[活动表 action]
 *--活动编号 acid
 *--店铺 rid 外键 [店铺表 restaurant]
 *--actype 活动类型 0.满减 1.打折
 *--活动id生成方法 action+5位随机数+店铺id+当前时间 
 * @author 12412
 *
 */
public class Action implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String acid;
	private int rid;
	private int actype;
	
	@Override
	public String toString() {
		return "action [acid=" + acid + ", rid=" + rid + ", actype=" + actype + "]";
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getActype() {
		return actype;
	}

	public void setActype(int actype) {
		this.actype = actype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Action(String acid, int rid, int actype) {
		super();
		this.acid = acid;
		this.rid = rid;
		this.actype = actype;
	}

	public Action() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acid == null) ? 0 : acid.hashCode());
		result = prime * result + actype;
		result = prime * result + rid;
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
		Action other = (Action) obj;
		if (acid == null) {
			if (other.acid != null)
				return false;
		} else if (!acid.equals(other.acid))
			return false;
		if (actype != other.actype)
			return false;
		if (rid != other.rid)
			return false;
		return true;
	}
}
