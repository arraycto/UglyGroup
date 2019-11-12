package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 * --[地区表 area]
 *--地区序号 aid 主键
 *--地区名 aname
 * @author 12412
 *
 */
public class Area implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int aid;
	private String aname;
	
	@Override
	public String toString() {
		return "area [aid=" + aid + ", aname=" + aname + "]";
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Area(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}

	public Area() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
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
		Area other = (Area) obj;
		if (aid != other.aid)
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		return true;
	}
}
