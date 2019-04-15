package com.sy.demo.vo.zsm;

import java.util.Date;

public class OrdersVo {

	private String orderID;
	private Integer totalPrice;
	private String stName;
	private String userName;
	private Date orderTime;
	private String serviceTitle;
	private String serviceFuTitle;
	private Integer orderStatus;
	private Integer number;
	private Date paymentTime;
	private String uploadPath;
	private Integer commentstatus;
	private Integer refundstatus;
	private Integer filesatus;
	private String documentpath;
	private String serviceCoverImg;
	private Date receiptTime;
	private Date provideServicesTime;
	private Date completeTime;
	private Integer population;
	private Integer serviceID;
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Date getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	public Date getProvideServicesTime() {
		return provideServicesTime;
	}
	public void setProvideServicesTime(Date provideServicesTime) {
		this.provideServicesTime = provideServicesTime;
	}
	public Date getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	

	@Override
	public String toString() {
		return "OrdersVo [orderID=" + orderID + ", totalPrice=" + totalPrice + ", stName=" + stName + ", userName="
				+ userName + ", orderTime=" + orderTime + ", serviceTitle=" + serviceTitle + ", serviceFuTitle="
				+ serviceFuTitle + ", orderStatus=" + orderStatus + ", number=" + number + ", paymentTime="
				+ paymentTime + ", uploadPath=" + uploadPath + ", commentstatus=" + commentstatus + ", refundstatus="
				+ refundstatus + ", filesatus=" + filesatus + ", documentpath=" + documentpath + ", serviceCoverImg="
				+ serviceCoverImg + ", receiptTime=" + receiptTime + ", provideServicesTime=" + provideServicesTime
				+ ", completeTime=" + completeTime + ", population=" + population + ", serviceID=" + serviceID + "]";
	}
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public OrdersVo(String orderID, Integer totalPrice, String stName, String userName, Date orderTime,
			String serviceTitle, String serviceFuTitle, Integer orderStatus, Integer number, Date paymentTime,
			String uploadPath, Integer commentstatus, Integer refundstatus, Integer filesatus, String documentpath,
			String serviceCoverImg, Date receiptTime, Date provideServicesTime, Date completeTime, Integer population,
			Integer serviceID) {
		super();
		this.orderID = orderID;
		this.totalPrice = totalPrice;
		this.stName = stName;
		this.userName = userName;
		this.orderTime = orderTime;
		this.serviceTitle = serviceTitle;
		this.serviceFuTitle = serviceFuTitle;
		this.orderStatus = orderStatus;
		this.number = number;
		this.paymentTime = paymentTime;
		this.uploadPath = uploadPath;
		this.commentstatus = commentstatus;
		this.refundstatus = refundstatus;
		this.filesatus = filesatus;
		this.documentpath = documentpath;
		this.serviceCoverImg = serviceCoverImg;
		this.receiptTime = receiptTime;
		this.provideServicesTime = provideServicesTime;
		this.completeTime = completeTime;
		this.population = population;
		this.serviceID = serviceID;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public Integer getCommentstatus() {
		return commentstatus;
	}
	public void setCommentstatus(Integer commentstatus) {
		this.commentstatus = commentstatus;
	}
	
	public Integer getRefundstatus() {
		return refundstatus;
	}
	public void setRefundstatus(Integer refundstatus) {
		this.refundstatus = refundstatus;
	}
	public Integer getFilesatus() {
		return filesatus;
	}
	public void setFilesatus(Integer filesatus) {
		this.filesatus = filesatus;
	}
	public String getDocumentpath() {
		return documentpath;
	}
	
	public void setDocumentpath(String documentpath) {
		this.documentpath = documentpath;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceFuTitle() {
		return serviceFuTitle;
	}
	public void setServiceFuTitle(String serviceFuTitle) {
		this.serviceFuTitle = serviceFuTitle;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}


	public OrdersVo() {
		super();
	}
	
	
	
}
