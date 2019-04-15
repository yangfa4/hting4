package com.sy.demo.vo.zxf;

import java.util.Date;

import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;

public class Ordersvo1 {

	private Integer orderType;// 发货方式(1自发2上门取货)

	private Float totalPrice;// 订单总价

	private String uploadPath;// 上传文件路径

	private Date provideServicesTime;// 提供服务时间

	private Integer orderStatus;// 订单状态(1待付款2待接单3待提供服务4已提供服务6服务完成6服务取消7未接单8已退款)

	private Integer userID;// 外键，用户编号

	private Integer resouroeID;// 外键，资源类别

	private Integer number;// 份数

	private Date orderTime;// 下单时间

	private Date receiptTime;// 接单时间

	private Integer filesatus;// 文档状态(1待提供文档2商家已上传文档)

	private Integer integral;// 订单积分

	private Date scheduledStartTime;// 用户预定开始时间

	private Date paymentTime;// 付款时间

	private String orderID;// 订单id，主键

	private Date scheduledEndTime;// 用户预定结束时间

	private Integer commentstatus;// 评论状态(1待评价2用户已评3双方已评)

	private Date completeTime;// 完成时间

	private Double weight;// 订单重量

	private Integer collectGoods;// 外键，收货地址

	private Float smallPlan;// 小计

	private Integer population;// 人数

	private Integer refundstatus;// 退款状态(1退款申请中2不同意3申请管理员介入4管理员拒绝5退款完成6退款取消)

	private Integer serviceID;// 外键，商品编号(服务编号)

	private Integer addressID;// 外键，发货地址

	private String documentpath;// 韩语翻译文档文件路径

	private String remarks;// 备注

	private Services ser;
	private User u;

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Services getSer() {
		return ser;
	}

	public void setSer(Services ser) {
		this.ser = ser;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public Date getProvideServicesTime() {
		return provideServicesTime;
	}

	public void setProvideServicesTime(Date provideServicesTime) {
		this.provideServicesTime = provideServicesTime;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getResouroeID() {
		return resouroeID;
	}

	public void setResouroeID(Integer resouroeID) {
		this.resouroeID = resouroeID;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Integer getFilesatus() {
		return filesatus;
	}

	public void setFilesatus(Integer filesatus) {
		this.filesatus = filesatus;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Date getScheduledStartTime() {
		return scheduledStartTime;
	}

	public void setScheduledStartTime(Date scheduledStartTime) {
		this.scheduledStartTime = scheduledStartTime;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Date getScheduledEndTime() {
		return scheduledEndTime;
	}

	public void setScheduledEndTime(Date scheduledEndTime) {
		this.scheduledEndTime = scheduledEndTime;
	}

	public Integer getCommentstatus() {
		return commentstatus;
	}

	public void setCommentstatus(Integer commentstatus) {
		this.commentstatus = commentstatus;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getCollectGoods() {
		return collectGoods;
	}

	public void setCollectGoods(Integer collectGoods) {
		this.collectGoods = collectGoods;
	}

	public Float getSmallPlan() {
		return smallPlan;
	}

	public void setSmallPlan(Float smallPlan) {
		this.smallPlan = smallPlan;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Integer getRefundstatus() {
		return refundstatus;
	}

	public void setRefundstatus(Integer refundstatus) {
		this.refundstatus = refundstatus;
	}

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public String getDocumentpath() {
		return documentpath;
	}

	public void setDocumentpath(String documentpath) {
		this.documentpath = documentpath;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Ordersvo1 [orderType=" + orderType + ", totalPrice=" + totalPrice + ", uploadPath=" + uploadPath
				+ ", provideServicesTime=" + provideServicesTime + ", orderStatus=" + orderStatus + ", userID=" + userID
				+ ", resouroeID=" + resouroeID + ", number=" + number + ", orderTime=" + orderTime + ", receiptTime="
				+ receiptTime + ", filesatus=" + filesatus + ", integral=" + integral + ", scheduledStartTime="
				+ scheduledStartTime + ", paymentTime=" + paymentTime + ", orderID=" + orderID + ", scheduledEndTime="
				+ scheduledEndTime + ", commentstatus=" + commentstatus + ", completeTime=" + completeTime + ", weight="
				+ weight + ", collectGoods=" + collectGoods + ", smallPlan=" + smallPlan + ", population=" + population
				+ ", refundstatus=" + refundstatus + ", serviceID=" + serviceID + ", addressID=" + addressID
				+ ", documentpath=" + documentpath + ", remarks=" + remarks + "]";
	}

	public Ordersvo1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
