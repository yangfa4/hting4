package com.sy.demo.pojo;import org.springframework.format.annotation.DateTimeFormat;import java.util.Date;@SuppressWarnings("all")public class Goldnotes {    private Integer recordID;// 金币流向操作记录id，主键    private String recordDescribe;// 记录描述    private Float recordInAndOut;// 记录收入，支出    private Date recordDate;// 记录日期    private Integer auditStatus;// 审核状态(1待审核2审核成功3未通过)    private Integer userID;// 外键，用户编号    private Integer acquisitionMode;// (1预定服务2服务收益3取消物流订单4其他5充值6线下充值7退款8提现)    public Goldnotes() {        super();    }    /**     * @param recordID        金币流向操作记录id     * @param recordDescribe  记录描述     * @param recordInAndOut  记录收入，支出     * @param recordDate      记录日期     * @param auditStatus     审核状态(1待审核2审核成功3未通过)     * @param userID          外键，用户编号     * @param acquisitionMode (1预定服务2服务收益3取消物流订单4其他5充值6线下充值7退款8提现)     * @description: 含主键的构造函数     */    public Goldnotes(Integer recordID, String recordDescribe, Float recordInAndOut, Date recordDate, Integer auditStatus, Integer userID, Integer acquisitionMode) {        super();        this.recordID = recordID;        this.recordDescribe = recordDescribe;        this.recordInAndOut = recordInAndOut;        this.recordDate = recordDate;        this.auditStatus = auditStatus;        this.userID = userID;        this.acquisitionMode = acquisitionMode;    }    public Integer getRecordID() {        return this.recordID;    }    public void setRecordID(Integer recordID) {        this.recordID = recordID;    }    public String getRecordDescribe() {        return this.recordDescribe;    }    public void setRecordDescribe(String recordDescribe) {        this.recordDescribe = recordDescribe;    }    public Float getRecordInAndOut() {        return this.recordInAndOut;    }    public void setRecordInAndOut(Float recordInAndOut) {        this.recordInAndOut = recordInAndOut;    }    public Date getRecordDate() {        return this.recordDate;    }    public void setRecordDate(Date recordDate) {        this.recordDate = recordDate;    }    public Integer getAuditStatus() {        return this.auditStatus;    }    public void setAuditStatus(Integer auditStatus) {        this.auditStatus = auditStatus;    }    public Integer getUserID() {        return this.userID;    }    public void setUserID(Integer userID) {        this.userID = userID;    }    public Integer getAcquisitionMode() {        return this.acquisitionMode;    }    public void setAcquisitionMode(Integer acquisitionMode) {        this.acquisitionMode = acquisitionMode;    }}	