package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 * --[收获地址表 addressreceipt]
 *--地址编号 arid
 *--用户编号 uid 外键 [用户表 user]
 *--收货人姓名 arname (默认为当前用户)
 *--收货人电话 artel(默认为当前用户)
 *--收货地址 aradd
 * @author 12412
 *
 */
public class AddressReceipt implements Serializable{
	private static final long serialVersionUID = 1L;

	private int arid;
	private int uid;
	private String arname;
	private String artel;
	private String aradd;
	
	@Override
	public String toString() {
		return "addressreceipt [arid=" + arid + ", uid=" + uid + ", arname=" + arname + ", artel=" + artel + ", aradd="
				+ aradd + "]";
	}

	public int getArid() {
		return arid;
	}

	public void setArid(int arid) {
		this.arid = arid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getArname() {
		return arname;
	}

	public void setArname(String arname) {
		this.arname = arname;
	}

	public String getArtel() {
		return artel;
	}

	public void setArtel(String artel) {
		this.artel = artel;
	}

	public String getAradd() {
		return aradd;
	}

	public void setAradd(String aradd) {
		this.aradd = aradd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AddressReceipt(int arid, int uid, String arname, String artel, String aradd) {
		super();
		this.arid = arid;
		this.uid = uid;
		this.arname = arname;
		this.artel = artel;
		this.aradd = aradd;
	}

	public AddressReceipt() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aradd == null) ? 0 : aradd.hashCode());
		result = prime * result + arid;
		result = prime * result + ((arname == null) ? 0 : arname.hashCode());
		result = prime * result + ((artel == null) ? 0 : artel.hashCode());
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
		AddressReceipt other = (AddressReceipt) obj;
		if (aradd == null) {
			if (other.aradd != null)
				return false;
		} else if (!aradd.equals(other.aradd))
			return false;
		if (arid != other.arid)
			return false;
		if (arname == null) {
			if (other.arname != null)
				return false;
		} else if (!arname.equals(other.arname))
			return false;
		if (artel == null) {
			if (other.artel != null)
				return false;
		} else if (!artel.equals(other.artel))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
}
