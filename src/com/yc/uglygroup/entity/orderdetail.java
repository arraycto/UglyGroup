package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 * --[订单详情表 orderdetail]
 *--订单详情编号 did
 *--订单号 oid 外键 [订单表 foodorder]
 *--美食编号 fid 外键 [美食表 foods]
 *--食品数量 num
 *--交易金额 price
 * @author 12412
 *
 */
public class orderdetail implements Serializable{
	private static final long serialVersionUID = 1L;

	private int did;
	private String oid;
	private int fid;
	private int num;
	private float price;
	
	@Override
	public String toString() {
		return "orderdetail [did=" + did + ", oid=" + oid + ", fid=" + fid + ", num=" + num + ", price=" + price + "]";
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public orderdetail(int did, String oid, int fid, int num, float price) {
		super();
		this.did = did;
		this.oid = oid;
		this.fid = fid;
		this.num = num;
		this.price = price;
	}

	public orderdetail() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + did;
		result = prime * result + fid;
		result = prime * result + num;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + Float.floatToIntBits(price);
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
		orderdetail other = (orderdetail) obj;
		if (did != other.did)
			return false;
		if (fid != other.fid)
			return false;
		if (num != other.num)
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
}
