package com.sy.demo.vo.zsm;

import java.util.Date;

public class moneyVo {

	private Integer userID;
	private String userName;
	private Integer recordID;
	private Integer acquisitionMode;
	private Date recordDate;
	private String recordDescribe;
	private String recordInAndOut;
	private Integer auditStatus;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getRecordID() {
		return recordID;
	}
	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}
	public Integer getAcquisitionMode() {
		return acquisitionMode;
	}
	public void setAcquisitionMode(Integer acquisitionMode) {
		this.acquisitionMode = acquisitionMode;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecordDescribe() {
		return recordDescribe;
	}
	public void setRecordDescribe(String recordDescribe) {
		this.recordDescribe = recordDescribe;
	}
	public String getRecordInAndOut() {
		return recordInAndOut;
	}
	public void setRecordInAndOut(String recordInAndOut) {
		this.recordInAndOut = recordInAndOut;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public moneyVo(Integer userID, String userName, Integer recordID, Integer acquisitionMode, Date recordDate,
			String recordDescribe, String recordInAndOut, Integer auditStatus) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.recordID = recordID;
		this.acquisitionMode = acquisitionMode;
		this.recordDate = recordDate;
		this.recordDescribe = recordDescribe;
		this.recordInAndOut = recordInAndOut;
		this.auditStatus = auditStatus;
	}
	public moneyVo() {
		super();
	}
	@Override
	public String toString() {
		return "moneyVo [userID=" + userID + ", userName=" + userName + ", recordID=" + recordID + ", acquisitionMode="
				+ acquisitionMode + ", recordDate=" + recordDate + ", recordDescribe=" + recordDescribe
				+ ", recordInAndOut=" + recordInAndOut + ", auditStatus=" + auditStatus + "]";
	}
	
	
}
