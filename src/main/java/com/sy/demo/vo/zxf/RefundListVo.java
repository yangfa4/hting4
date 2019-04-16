package com.sy.demo.vo.zxf;

import java.util.Date;

import com.sy.demo.pojo.Orders;

public class RefundListVo {
	private String refundImg;// 退款附带图片

	private String orderID;// 外键，订单编号

	private String refundReason;// 退款原因

	private String adminRemarks;// 管理员审核备注

	private Float actualRefundMoney;// 实际退款金额

	private Integer userID;// 外键，用户编号

	private String businessRemarks;// 商家审核备注

	private Integer point;// 退款申请指向，1：商家，2：管理员

	private Float applyRefundMoney;// 申请退款金额

	private Date adminTime;// 管理员审核时间

	private String refundExplain;// 退款说明

	private Date applicationTime;// 申请时间

	private Date auditTime;// 商家审核时间

	private Integer adminStatus;// 管理员审核状态(1待审核2审核成功3未通过)

	private Integer auditStatus;// 商家审核状态(1待审核2审核成功3未通过)

	private Integer refundID;// 退款id，主键

	private Ordersvo1 order = new Ordersvo1();

	public Ordersvo1 getOrder() {
		return order;
	}

	public void setOrder(Ordersvo1 order) {
		this.order = order;
	}

	public String getRefundImg() {
		return refundImg;
	}

	public void setRefundImg(String refundImg) {
		this.refundImg = refundImg;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getAdminRemarks() {
		return adminRemarks;
	}

	public void setAdminRemarks(String adminRemarks) {
		this.adminRemarks = adminRemarks;
	}

	public Float getActualRefundMoney() {
		return actualRefundMoney;
	}

	public void setActualRefundMoney(Float actualRefundMoney) {
		this.actualRefundMoney = actualRefundMoney;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getBusinessRemarks() {
		return businessRemarks;
	}

	public void setBusinessRemarks(String businessRemarks) {
		this.businessRemarks = businessRemarks;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Float getApplyRefundMoney() {
		return applyRefundMoney;
	}

	public void setApplyRefundMoney(Float applyRefundMoney) {
		this.applyRefundMoney = applyRefundMoney;
	}

	public Date getAdminTime() {
		return adminTime;
	}

	public void setAdminTime(Date adminTime) {
		this.adminTime = adminTime;
	}

	public String getRefundExplain() {
		return refundExplain;
	}

	public void setRefundExplain(String refundExplain) {
		this.refundExplain = refundExplain;
	}

	public Date getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Integer getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(Integer adminStatus) {
		this.adminStatus = adminStatus;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getRefundID() {
		return refundID;
	}

	public void setRefundID(Integer refundID) {
		this.refundID = refundID;
	}

	public RefundListVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RefundListVo [refundImg=" + refundImg + ", orderID=" + orderID + ", refundReason=" + refundReason
				+ ", adminRemarks=" + adminRemarks + ", actualRefundMoney=" + actualRefundMoney + ", userID=" + userID
				+ ", businessRemarks=" + businessRemarks + ", point=" + point + ", applyRefundMoney=" + applyRefundMoney
				+ ", adminTime=" + adminTime + ", refundExplain=" + refundExplain + ", applicationTime="
				+ applicationTime + ", auditTime=" + auditTime + ", adminStatus=" + adminStatus + ", auditStatus="
				+ auditStatus + ", refundID=" + refundID + "]";
	}

}
