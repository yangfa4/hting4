package com.sy.demo.vo.zxf;

import java.util.Date;
 
public class AuthVo {

	private String stname;
	private Date submittime;
	private Date audittime;
	private int auditstatus;
	private int stid;

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public Date getSubmittime() {
		return submittime;
	}

	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
	}

	public Date getAudittime() {
		return audittime;
	}

	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}

	public int getAuditstatus() {
		return auditstatus;
	}

	public void setAuditstatus(int auditstatus) {
		this.auditstatus = auditstatus;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	@Override
	public String toString() {
		return "AuthVo [stname=" + stname + ", submittime=" + submittime + ", audittime=" + audittime + ", auditstatus="
				+ auditstatus + ", stid=" + stid + "]";
	}

	public AuthVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthVo(String stname, Date submittime, Date audittime, int auditstatus, int stid) {
		super();
		this.stname = stname;
		this.submittime = submittime;
		this.audittime = audittime;
		this.auditstatus = auditstatus;
		this.stid = stid;
	}

}
