package com.yc.uglygroup.entity;
/**
 * 这个是为了Restaurantservlet  里面findsan专门创的实体类
 * @author djl
 *
 */
public class Restaurant1 {
	private int aid;
	private int tid;
	private String rname;
	private String rpic;
	private String rdisc;
	private int rstate;
	private String tname;
	private String aname;
	
	@Override
	public String toString() {
		return "Restaurant1 [aid=" + aid + ", tid=" + tid + ", rname=" + rname + ", rpic=" + rpic + ", rdisc=" + rdisc
				+ ", rstate=" + rstate + ", tname=" + tname + ", aname=" + aname + "]";
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
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
}
