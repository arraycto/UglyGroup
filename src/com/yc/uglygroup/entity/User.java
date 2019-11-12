package com.yc.uglygroup.entity;

import java.io.Serializable;

/**
 * --[用户表 user]
 *--用户编号 uid 主键
 *--账号 uname
 *--密码 upwd
 *--电话 utel
 *--邮箱 email
 *--用户角色  ustate 0.用户，1.店家，2.管理员
 * @author 12412
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int uid;
	private String uname;
	private String upwd;
	private String utel;
	private String email;
	private int ustate;
	
	@Override
	public String toString() {
		return "user [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", utel=" + utel + ", email=" + email
				+ ", ustate=" + ustate + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUstate() {
		return ustate;
	}

	public void setUstate(int ustate) {
		this.ustate = ustate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User(int uid, String uname, String upwd, String utel, String email, int ustate) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.utel = utel;
		this.email = email;
		this.ustate = ustate;
	}

	public User() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((upwd == null) ? 0 : upwd.hashCode());
		result = prime * result + ustate;
		result = prime * result + ((utel == null) ? 0 : utel.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (upwd == null) {
			if (other.upwd != null)
				return false;
		} else if (!upwd.equals(other.upwd))
			return false;
		if (ustate != other.ustate)
			return false;
		if (utel == null) {
			if (other.utel != null)
				return false;
		} else if (!utel.equals(other.utel))
			return false;
		return true;
	}
}
