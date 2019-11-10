package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 * --[美食类型表 foodtypes]
 *--类型编号 tid 主键
 *--类型名称 tname
 * @author 12412
 *
 */
public class foodtypes implements Serializable{
	private static final long serialVersionUID = 1L;

	private int tid;
	private String tname;
	
	@Override
	public String toString() {
		return "foodtypes [tid=" + tid + ", tname=" + tname + "]";
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public foodtypes(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}

	public foodtypes() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tid;
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
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
		foodtypes other = (foodtypes) obj;
		if (tid != other.tid)
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		return true;
	}
}
